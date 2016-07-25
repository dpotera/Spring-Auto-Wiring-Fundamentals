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

    @Value("#{investClient.clientText}")
    String clientVisitResult;

    // Read SystemPorperties uing SpEL  #{}
    @Value("#{systemProperties['user.timezone']}")
    String timezone;

    @Value("#{systemProperties['os.name']}")
    String osName;

    @Bean
    Notifier appNotofier(){
        Notifier ntf = new NotifierImpl(bank);
        ntf.addMessage("@Value(\"#{investClient.clientText}\") : " + clientVisitResult);
        ntf.addMessage("@Value(\"#{systemProperties['user.timezone']}\") : " + timezone);
        ntf.addMessage("@Value(\"#{systemProperties['os.name']}\") : " + osName);
        return ntf;
    }

}
