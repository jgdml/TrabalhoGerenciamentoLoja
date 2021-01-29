package testes;

import modelo.*;
import sistema.DaoGenerico;

public class Inserts {

    public static void init(){

        Categoria cat = new Categoria("Categoria 1", "Descricao 1");
        Categoria cat2 = new Categoria("Categoria 2", "Descricao 2");

        DaoGenerico<Categoria> dc = new DaoGenerico<>();

        dc.salvarOuAtualizar(cat);
        dc.salvarOuAtualizar(cat2);




        Estado est = new Estado("⠄⠄⠄⢠⣶⣶⣦⣤⣶⣦⣤⣶⣶⣤⡄⠄⡆\n" +
                "⠄⣂⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⡆\n" +
                "⢠⢻⣿⡿⣟⡛⠻⢿⣿⣿⡿⠿⠟⠻⢿⣿⣇\n" +
                "⢀⣺⣿⡟⠋⡉⢉⠚⢿⣿⠗⢊⠙⡛⢿⣿⡌\n" +
                "⠈⣝⣿⣿⣿⣧⣤⣤⣿⣿⣶⣤⣼⣿⣿⣿⡇\n" +
                "⠄⠙⣿⣿⣿⣿⣿⡿⣿⣿⣷⣿⣿⣿⣿⡟⠄\n" +
                "⠄⠄⣿⣿⣿⠛⣋⣩⣬⣥⣤⡍⢙⣿⣿⡇⠄\n" +
                "⠄⠄⠘⣿⣿⣴⣭⣿⣿⣿⣿⣵⣾⣿⠏⠄⠄\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣷⣤⣴⣿⣿⣿⣿⠄⣠⠤\n" +
                "⢀⠄⠚⣿⣿⣷⡌⣁⣀⣀⣩⣴⣿⣿⠄⠈⣍⣛.", "RJ");
        Estado est1 = new Estado("Estado 2", "e2");

        DaoGenerico<Estado> de = new DaoGenerico<>();

        de.salvarOuAtualizar(est);
        de.salvarOuAtualizar(est1);





//        System.out.println(dc.findId(Categoria.class, 1).getNome());

    }
}
