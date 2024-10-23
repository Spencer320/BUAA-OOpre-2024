import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class CommandManagerTest {
    @Test
    public void testPoint1() {
        String data = "5\n" +
                "1 123456 123\n" +
                "3 123456 1 equipment 1 Axe 50\n" +
                "6 123456 1\n"+
                "1 234567 234\n"+
                "10 123456 equipment normal 1 234567\n";

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

    @Test
    public void testPoint4() {
        String data = "21\n" +
                "1 1 adv1\n" +
                "1 2 adv2\n" +
                "1 3 adv3\n" +
                "1 4 adv4\n" +
                "1 5 adv5\n" +
                "1 6 adv6\n" +
                "11 2 3\n" +
                "11 2 4\n" +
                "11 3 4\n" +
                "11 3 5\n" +
                "11 5 6\n" +
                "3 1 10 equ 3 Axe 5\n" +
                "3 3 11 equ1 3 Axe 5\n" +
                "3 4 12 equ2 3 Axe 5\n" +
                "6 3 11\n" +
                "6 4 12\n" +
                "6 1 10\n" +
                "10 1 equ chain 2 2 3\n" +
                "10 1 equ normal 2 2 3\n" +
                "4 2 11\n" +
                "4 2 12\n";

        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ArrayList<ArrayList<String>> inputInfo = MainClass.getInputInfo();
        MainClass.typeCommand(inputInfo);
    }

    @Test
    public void testPoint5() {
        String data = "41\n" +
                "1 0 X\n" +
                "1 1 A\n" +
                "1 2 B\n" +
                "1 3 C\n" +
                "1 4 D\n" +
                "1 5 E\n" +
                "1 6 F\n" +
                "1 7 G\n" +
                "1 8 H\n" +
                "1 9 I\n" +
                "1 10 J \n" +
                "1 11 K\n" +
                "1 12 L\n" +
                "1 13 M\n" +
                "1 14 N\n" +
                "1 15 O\n" +
                "1 16 P\n" +
                "3 0 200 Sword1 20 Sword 10\n" +
                "6 0 200\n" +
                "3 1 201 Sword2 20 Sword 100\n" +
                "6 1 201\n" +
                "2 1 100 DefBottle1 10 DefBottle 10\n" +
                "6 1 100\n" +
                "7 1 100\n" +
                "11 1 2\n" +
                "11 1 3\n" +
                "11 2 4\n" +
                "11 2 5\n" +
                "11 3 6\n" +
                "11 5 7\n" +
                "11 6 8\n" +
                "11 6 9\n" +
                "11 7 10\n" +
                "11 8 11\n" +
                "11 10 12\n" +
                "11 10 13\n" +
                "11 11 13\n" +
                "11 11 14\n" +
                "11 11 15\n" +
                "11 0 16\n" +
                "10 0 Sword1 chain 2  1 8\n";


        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        ArrayList<ArrayList<String>> inputInfo = MainClass.getInputInfo();
        MainClass.typeCommand(inputInfo);
    }
}