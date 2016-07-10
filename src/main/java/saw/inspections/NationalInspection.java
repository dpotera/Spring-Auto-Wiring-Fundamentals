package saw.inspections;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import saw.intefaces.Inspection;

@Component("Inspection")
@Profile("dev")
public class NationalInspection implements Inspection {
    public void inspect(){
        System.out.print("Inspecting Bank.");
    }
}
