package saw.banks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import saw.annotations.Credit;
import saw.intefaces.Bank;
import saw.intefaces.Client;

@Component("Bank")
public class BankImpl implements Bank{
    private Client client;
    private String bankName;

    @Autowired
    @Credit
    public BankImpl(Client client) {
        this.client = client;
        this.bankName = "ING";
    }

    @Override
    public void serve() {
        System.out.print(bankName+" : ");
        client.visit();
    }
}