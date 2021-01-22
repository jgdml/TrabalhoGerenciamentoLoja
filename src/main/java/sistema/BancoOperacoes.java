package sistema;

import sistema.Banco;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class BancoOperacoes {

    private static ArrayList<String> getInfoTabela(String tabela, boolean mostrarTudo){

        ArrayList<String> colunas = new ArrayList<String>();
        ResultSetMetaData rsmd;

        ResultSet res = Banco.doSelect("SELECT * FROM "+tabela);

        try{
            rsmd = res.getMetaData();
            for (int i = 1; i < rsmd.getColumnCount()+1; i++){
                colunas.add(rsmd.getColumnName(i));
            }
        }
        catch(SQLException err){
            System.out.println("\nOcorreu um erro ao realizar o select\n\n" + err);
        }

        if (mostrarTudo){
            for (int i = 0; i < colunas.size(); i++){

                if (colunas.get(i).startsWith("ID_")){
                    colunas.set(i, null);
                }
                if (Objects.equals(colunas.get(i), "STATUS") || Objects.equals(colunas.get(i), "DT_ATUALIZA")){
                    colunas.set(i, null);
                }
            }
        }

        return colunas;
    }


        public void deletearAtributo(String tabela, String dado){

            try{
                ArrayList<String> nomeTabela = getInfoTabela(tabela, true);

                String sql = String.format("UPDATE %s SET STATUS = \"F\" WHERE ID = %d",tabela, dado );
                Banco.doUpdate(sql);

            } catch (Exception e) {
                System.out.println(Constantes.ERRO_BANCO_DADOS);
            }

        }
}
