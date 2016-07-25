package saw.clients;

import org.springframework.stereotype.Component;
import saw.annotations.Credit;

@Component
@Credit
public class CreditClient implements Client {
    @Override
    public void visit() {
        System.out.print("I'm bank client. I would like to take credit.");
    }
}
