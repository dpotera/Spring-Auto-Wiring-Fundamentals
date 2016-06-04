package saw;

import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import saw.intefaces.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BankConfig.class)
public class BankTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private Client client;

    @Test
    public void clientExists(){
        assertNotNull(client);
    }

    @Test
    public void checkClient(){
        client.visit();
        assertEquals("I'm bank client. I would like to take credit.",log.getLog());
    }
}
