package saw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import saw.banks.Bank;
import saw.notifier.Notifier;

public class BankApplication {
    public static void main(String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
        // Get Application Environment
        ConfigurableEnvironment env = context.getEnvironment();
        env.setActiveProfiles("dev");

        // Get properties from bank.properties file imported in BankConfig by @PropertySource Annotation
        // Get String property only with key
        String bankName = env.getProperty("bank.name");
        // Get property in indicated type (Integer)
        int bankYear = env.getProperty("bank.year",Integer.class);

        // Print recived properties
        System.out.println("ApplicationEnvironment.getProperty('bank.name') = " + bankName);
        System.out.println("ApplicationEnvironment.getProperty('bank.year',Integer.class) = " + bankYear +
            " after incrementation = " + ++bankYear);

        Notifier notifier = context.getBean(Notifier.class);
        notifier.print();

        Bank bank = context.getBean(Bank.class);
        bank.serve();
    }
}
