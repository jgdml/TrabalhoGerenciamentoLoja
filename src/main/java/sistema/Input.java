package sistema;

import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Input {

    public static Scanner scan = new Scanner(System.in);

    public static String get(String msg){

        System.out.print(msg);
        return scan.nextLine();
    }

    public static int getInt(String msg){

        while(true){
            System.out.println(msg);
            try{
                return Integer.parseInt(scan.nextLine());
            }
            catch(NumberFormatException err){
                System.out.println(Constantes.ERRO_STR_INT);
            }
        }
    }

    public static double getDouble(String msg){

        while(true){
            System.out.println(msg);
            try{
                return parseDouble(scan.nextLine());
            }
            catch(NumberFormatException err){
                System.out.println(Constantes.ERRO_STR_DOUBLE);
            }
        }
    }



}
