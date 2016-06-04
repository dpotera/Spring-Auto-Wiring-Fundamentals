package saw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import saw.intefaces.Bank;
import saw.intefaces.Client;

@Configuration
public class BankConfig {

    @Bean(name = "CreditTaker")
    public Client creditTaker(){
        return new CreditClient();
    }

    @Bean
    public Bank createBank(){
        return new ING(creditTaker());
    }
}
