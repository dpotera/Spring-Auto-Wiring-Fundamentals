package saw.clients;

import org.springframework.stereotype.Component;

@Component
public class InvestClient implements Client{
    private String clientText = "I'm bank client. I'm going to invest in gold.";

    public String getClientText() {
        return clientText;
    }

    @Override
    public void visit() {
        System.out.print(clientText);
    }
}
