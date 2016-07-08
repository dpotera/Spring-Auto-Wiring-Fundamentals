package saw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saw.intefaces.Bank;
import saw.intefaces.Client;

@Component("Bank")
public class ING implements Bank{
    private Client client;

    @Autowired
    public ING(Client client) {
        this.client = client;
    }

    @Override
    public void serve() {
        System.out.print("Client comes: ");
        client.visit();
    }
}
