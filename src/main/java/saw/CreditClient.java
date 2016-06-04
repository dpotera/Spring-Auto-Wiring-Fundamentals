package saw;

import org.springframework.stereotype.Component;

@Component("CreditTaker")
public class CreditClient implements Client {
    @Override
    public void visit() {
        System.out.println("I'm bank client. I would like to take credit.");
    }
}
