package sistema;

import sistema.Banco;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BancoOperacoes {

    public void printTabela(String tabela){
        ResultSet res = Banco.doSelect("SELECT * FROM "+tabela);

        try{
            ResultSetMetaData metadata = res.getMetaData();
        }
        catch(SQLException err){
            System.out.println("\nOcorreu um erro ao realizar o select\n\n" + err);
        }



    }


}
