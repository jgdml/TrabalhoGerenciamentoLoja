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
            System.out.print(msg);

            try{
                int val = Integer.parseInt(scan.nextLine());
                if (val < 0){
                    System.out.println(Constantes.ERRO_MENOR_UM);
                }
                else{
                    return val;
                }
            }
            catch(NumberFormatException err){
                System.out.println(Constantes.ERRO_STR_INT);
            }
        }
    }

    public static double getDouble(String msg){

        while(true){
            System.out.print(msg);
            try{
                double val = parseDouble(scan.nextLine());
                if (val < 0){
                    System.out.println(Constantes.ERRO_MENOR_UM);
                }
                else{
                    return val;
                }
            }
            catch(NumberFormatException err){
                System.out.println(Constantes.ERRO_STR_DOUBLE);
            }
        }
    }

    public static Boolean getBool(String msg){

        while(true) {

            System.out.println(msg);
            System.out.println("1. Sim \n2. Não");

            int op = getInt("Opcão: ");


            if (op == 1) {
                return true;

            } else if (op == 2) {
                return false;

            } else {

                System.out.println("Opção invalida!");
            }
        }
    }



}
