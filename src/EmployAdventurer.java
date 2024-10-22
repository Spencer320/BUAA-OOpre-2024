import java.util.ArrayList;

public class EmployAdventurer implements CommandUtil {
    @Override
    public void execute(ArrayList<String> message) {
        String employerId = message.get(0);
        String employeeId = message.get(1);
        Adventurer employer = MainClass.adventurers.get(employerId);
        Adventurer employee = MainClass.adventurers.get(employeeId);
        employer.employAdventurer(employee);
    }
}
