package sistema;

import java.sql.*;
import java.util.ArrayList;


public class Banco {

    final static String ip = "jdbc:mysql://localhost:3306/bd?useTimezone=true&serverTimezone=UTC";
    final static String user = "root";
    final static String pass = "password";

    static Connection conn;
    static Statement st;


    public static void conectar(){

        try {
            conn = DriverManager.getConnection(ip, user, pass);
            st = conn.createStatement();
        }
        catch (SQLException err) {
            System.out.println("\nOcorreu um erro ao se conectar com o banco\n\n" + err);
        }
    }


    public static void desconectar(){
        try{
            conn.close();
        }
        catch(SQLException err){
            System.out.println("Erro ao se desconectar" + err);
        }
    }


    public static ResultSet doSelect(String sql){
        ResultSet rs = null;

        try{
            rs = st.executeQuery(sql);
        }

        catch(SQLException err){
            System.out.println("\nOcorreu um erro ao realizar o select\n\n" + err);
        }

        return rs;
    }


    public static void doUpdate(String sql){
        try{
            st.executeUpdate(sql);
        }
        catch(SQLException err){
            System.out.println("\nOcorreu um erro ao realizar a atualizaçao\n\n" + err);
        }
    }
}

