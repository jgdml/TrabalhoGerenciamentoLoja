
import modelo.Categoria;
import sistema.DaoGenerico;

public class Main {

    public static void main(String[] args){

        Categoria cat = new Categoria("cat1", "desc1");

        DaoGenerico<Categoria> dc = new DaoGenerico<>();

        dc.save(cat);

        System.out.println(dc.findId(Categoria.class, 1).getNome());

    }
}
