package saw;

import org.springframework.beans.factory.annotation.Autowired;
import saw.intefaces.Bank;
import saw.intefaces.Client;

public class ING implements Bank{
    private Client client;

    @Autowired
    public ING(Client client) {
        this.client = client;
    }

    @Override
    public void serve() {
        client.visit();
    }
}
