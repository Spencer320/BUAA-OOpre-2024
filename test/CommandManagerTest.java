import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class CommandManagerTest {
    CommandManager manager = new CommandManager();

    @Test
    public void testPoint1() {
        String data = "5\n" +
                "1 123456 123\n" +
                "3 123456 1 equipment 1 Axe 50\n" +
                "6 123456 1\n"+
                "1 234567 234\n"+
                "10 123456 equipment 1 234567\n";

        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ArrayList<ArrayList<String>> inputInfo = MainClass.getInputInfo();
        MainClass.typeCommand(inputInfo);
    }

    @Test
    public void testPoint2() {
        String data = "16" + "\n" +
                "1 123456 123" + "\n" +
                "8 123456 1 fragment" + "\n" +
                "8 123456 2 fragment" + "\n" +
                "8 123456 3 fragment" + "\n" +
                "8 123456 4 fragment" + "\n" +
                "8 123456 5 fragment" + "\n" +
                "8 123456 6 fragment" + "\n" +
                "8 123456 7 fragment" + "\n" +
                "8 123456 8 fragment" + "\n" +
                "9 123456 fragment 654321" + "\n" +
                "9 123456 fragment 65432" + "\n" +
                "8 123456 9 fragment" + "\n" +
                "8 123456 10 fragment" + "\n" +
                "8 123456 11 fragment" + "\n" +
                "3 123456 234567 equipment 1 Sword 100" + "\n" +
                "9 123456 fragment 234567\n";

        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ArrayList<ArrayList<String>> inputInfo = MainClass.getInputInfo();
        MainClass.typeCommand(inputInfo);
    }

    @Test
    public void testPoint3() {
        String data = "6" + "\n" +
                "1 123456 advName" + "\n" +
                "2 123456 123 bottleName 40 HpBottle 0" + "\n" +
                "7 123456 123" + "\n" +
                "6 123456 123" + "\n" +
                "7 123456 123" + "\n" +
                "5 123456 123\n";


        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ArrayList<ArrayList<String>> inputInfo = MainClass.getInputInfo();
        MainClass.typeCommand(inputInfo);
    }
}