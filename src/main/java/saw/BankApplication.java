package saw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import saw.intefaces.Bank;


public class BankApplication {
    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
        context.getEnvironment().setActiveProfiles("dev");

        Bank bank = context.getBean(Bank.class);
        bank.serve();
    }
}
