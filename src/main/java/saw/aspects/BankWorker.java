package saw.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BankWorker {
    private String name = "BankWorker: ";


    public void beforeBankServeClient(){
        System.out.println(name + "Bank is going to serve client");
    }

}
