import sistema.App;
import testes.Inserts;

public class Main {

    public static void main(String[] args){

        Inserts.init();

        App app = new App();

        app.init();

    }
}
