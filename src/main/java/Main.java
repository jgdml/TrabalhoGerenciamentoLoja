import sistema.Banco;
import sistema.BancoOperacoes;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Banco.conectar();
        BancoOperacoes.insertTabela("usuario");

//        System.out.println(Input.get("Input teste: "));


    }
}
