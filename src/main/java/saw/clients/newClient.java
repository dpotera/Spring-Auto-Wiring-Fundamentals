package saw.clients;

import org.springframework.stereotype.Component;
import saw.intefaces.Client;

@Component
public class newClient implements Client{
    @Override
    public void visit() {
        System.out.print("I'm new Bank client.");
    }
}
