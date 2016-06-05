package saw;

import saw.intefaces.Bank;
import saw.intefaces.Client;

public class ING implements Bank{
    private Client client;

    public ING(Client client) {
        this.client = client;
    }

    @Override
    public void serve() {
        System.out.print("Client comes: ");
        client.visit();
    }
}
