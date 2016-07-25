package saw;

import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import saw.annotations.Credit;
import saw.banks.Bank;
import saw.clients.Client;
import saw.inspections.Inspection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BankConfig.class)
@ActiveProfiles("dev")
public class BankTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    @Credit
    private Client client;

    @Autowired
    private Bank bank;

    @Test
    public void clientExists(){
        assertNotNull(client);
    }

    @Test
    public void checkClient(){
        client.visit();
        assertEquals("I'm bank client. I would like to take credit.",log.getLog());
    }

    @Test
    public void checkBankClient(){
        bank.serve();
        assertEquals("ING : " + "I'm bank client. I would like to take credit.",log.getLog());
    }

    @Autowired
    private Inspection inspection;

    @Test
    public void checkProfileVariable(){
        assertNotNull(inspection);
    }
}
