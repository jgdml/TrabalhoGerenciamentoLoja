package sistema;

import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Input {

    public static Scanner scan = new Scanner(System.in);

    public static String get(String msg){

        System.out.println(msg);
        return scan.nextLine();
    }

    public static int getInt(String msg){

        System.out.println(msg);
        return Integer.parseInt(scan.nextLine());
    }

    public static double getDouble(String msg){

        System.out.println(msg);
        return parseDouble(scan.nextLine());
    }



}
