package saw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("saw")
@PropertySource("bank.properties")
public class BankConfig {


}
