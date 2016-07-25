package saw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import saw.aspects.BankWorker;
import saw.notifier.Notifier;
import saw.notifier.NotifierImpl;

@Configuration
@ComponentScan("saw")
@EnableAspectJAutoProxy
@PropertySource("bank.properties")
public class BankConfig {

    // Read some data using Spring Expression Language
    // Read other @Beans Properties
    // If Bank.bankName is null then "bank name not set" will be returned because of ?: operator
    @Value("#{Bank.bankName ?: \"bank name not set\"}")
    String bank;

    // ?.toUpperCase if value at the left of ? is not null then toUpperCase method will be executed
    @Value("#{investClient.clientText?.toUpperCase()}")
    String clientVisitResult;

    // Read SystemPorperties uing SpEL  #{}
    @Value("#{systemProperties['user.timezone']}")
    String timezone;

    @Value("#{systemProperties['os.name']}")
    String osName;

    // Scientific notation eq equals to integer
    @Value("#{1.5486E4 eq 15486}")
    boolean match;

    // Boolean Value
    @Value("#{'1'}")
    boolean bool;

    // Generate random number
    @Value("#{T(java.lang.Math).random()*150}")
    int random;

    @Bean
    public Notifier appNotofier(){
        Notifier ntf = new NotifierImpl(bank);
        ntf.addMessage("#{investClient.clientText} : " + clientVisitResult);
        ntf.addMessage("#{systemProperties['user.timezone']} : " + timezone);
        ntf.addMessage("#{systemProperties['os.name']} : " + osName);
        ntf.addMessage("#{1.5486E4 matches 15486} : " + match);
        ntf.addMessage("#{'1'} to boolean: " + bool);
        ntf.addMessage("#{T(java.lang.Math).random()*150} " + random);
        return ntf;
    }

    // ASPECT
    @Bean
    public BankWorker bankWorker(){
        return new BankWorker();
    }


}
