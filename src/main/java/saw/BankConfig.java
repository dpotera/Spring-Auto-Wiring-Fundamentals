package saw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import saw.notifier.Notifier;
import saw.notifier.NotifierImpl;

@Configuration
@ComponentScan("saw")
@PropertySource("bank.properties")
public class BankConfig {

    // Read some data using Spring Expression Language
    // Read other @Beans Properties
    @Value("#{Bank.bankName}")
    String bank;

    // ?.toUpperCase if value at the left of ? is not null then toUpperCase method will be executed
    @Value("#{investClient.clientText?.toUpperCase()}")
    String clientVisitResult;

    // Read SystemPorperties uing SpEL  #{}
    @Value("#{systemProperties['user.timezone']}")
    String timezone;

    @Value("#{systemProperties['os.name']}")
    String osName;

    // Scientific notation
    @Value("#{1.5486E4}")
    int sciNotation;

    // Boolean Value
    @Value("#{'1'}")
    boolean bool;


    @Bean
    Notifier appNotofier(){
        Notifier ntf = new NotifierImpl(bank);
        ntf.addMessage("#{investClient.clientText} : " + clientVisitResult);
        ntf.addMessage("#{systemProperties['user.timezone']} : " + timezone);
        ntf.addMessage("#{systemProperties['os.name']} : " + osName);
        ntf.addMessage("#{1.5486E4} : " + sciNotation);
        ntf.addMessage("#{'1'} to boolean: " + bool);
        return ntf;
    }

}
