package saw.clients;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/*
    @Scope Annotation:
    - by default Components are singletons and one instance is created for all application
    - prototype means that each use or injection of object creates new instance

    For Web applications there are another scopes:
    WebApplicationContext.SCOPE_SESSION
        object for each session
    WebApplicationContext.SCOPE_REQUEST
        object for each http request

 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
