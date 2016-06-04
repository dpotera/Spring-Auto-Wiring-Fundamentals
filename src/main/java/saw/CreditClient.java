package saw;

import org.springframework.stereotype.Component;
import saw.intefaces.Client;

@Component("CreditTaker")
public class CreditClient implements Client {
    @Override
    public void visit() {
        System.out.print("I'm bank client. I would like to take credit.");
    }
}
