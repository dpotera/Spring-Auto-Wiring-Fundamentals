package saw.clients;

import org.springframework.stereotype.Component;
import saw.intefaces.Client;

@Component
public class InvestClient implements Client{
    @Override
    public void visit() {
        System.out.print("I'm bank client. I'm going to invest in gold.");
    }
}
