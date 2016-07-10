package saw.banks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import saw.annotations.Credit;
import saw.intefaces.Bank;
import saw.intefaces.Client;

@Component("Bank")
public class ING implements Bank{
    private Client client;

    @Autowired
    @Credit
    public ING(Client client) {
        this.client = client;
    }

    @Override
    public void serve() {
        System.out.print("ING: ");
        client.visit();
    }
}
