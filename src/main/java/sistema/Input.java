package sistema;

import java.util.Scanner;

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

}
