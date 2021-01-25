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

        if (!mostrarTudo){
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




    public static void atualizarTabela(String tabela, String atributo){

        ArrayList<String> coluna = getInfoTabela(tabela,false);

        System.out.println(coluna);

        int i;

        for(i= 0; i<coluna.size(); i++){

            System.out.println("Vai querer atualizar" + coluna.get(i) + "essa coluna");
            String resposta = Input.get("Digite sua resposta sendo S ou N: ");

            if(resposta.equals("S")) {

                String atributoValor = Input.get("Digite oque voce vai querer colocar no lugar deste atributo: ");

                Banco.doUpdate("UPDATE" + tabela+"SET" + coluna.get(i) + "=" + atributoValor);
            }
        }
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




    public static void insertTabela(String tabela){
        ArrayList<String> col = getInfoTabela(tabela, false);
        ArrayList<String> valores = new ArrayList<>();
        String val;
        String sql = String.format("insert into %s (", tabela);

       for(int i=0; i<col.size(); i++){

            if(col.get(i) != null){
                val = Input.get("Digite o "+col.get(i));
                valores.add(val);

                if(valores.size() > 1){
                    sql += ",";
                }
                sql += col.get(i);
            }
        }
        sql += ") values (";



        for(int i=0; i<valores.size(); i++) {

            if(i != 0){
                sql += ",";
            }
            sql += "'"+valores.get(i)+"'";

        }
        sql += " )";

        System.out.println(sql);

        Banco.doUpdate(sql);

    }
}

//print("Olá Mundo!!!") ---Pra dar Sorte, O Mateus que disse :)---
