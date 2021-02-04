package sistema;

import modelo.*;

public class PreencherFk {

    private static final DaoGenerico<Cliente> daoCliente = new DaoGenerico<>(Cliente.class);
    private static final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private static final DaoGenerico<Estado> daoEstado = new DaoGenerico<>(Estado.class);
    private static final DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>(Usuario.class);


    private static String askTipo(String classe){
        while (true){
            System.out.println("É obrigatorio ter um "+classe+" neste registro");
            String op = Input.get(String.format("\n1. Criar novo registro de %s \n2. Selecionar registro existente de %s\nOpção: ", classe, classe));

            if (op.equals("1") || op.equals("2")){
                return op;
            }
            else{
                System.out.println("Opção inválida");
            }
        }
    }


    public static void fkCidade(Cidade c){
        String tipo = askTipo("Estado");
        Estado e = new Estado();

        if (tipo.equals("1")){
            e.preencher();
            daoEstado.salvarOuAtualizar(e);
        }
        else{
            e = daoEstado.escolher();
        }
        c.setEstado(e);

    }


    public static void fkCliente(Cliente cli){
        String tipo = askTipo("Cidade");
        Cidade c = new Cidade();

        if (tipo.equals("1")){
            c.preencher();
            daoCidade.salvarOuAtualizar(c);
            fkCidade(c);
        }
        else{
            c = daoCidade.escolher();
        }
        cli.setCidade(c);
    }


    public static void fkFuncionario(Funcionario f){
        String tipo = askTipo("Cidade");
        Cidade c = new Cidade();

        if (tipo.equals("1")){
            c.preencher();
            daoCidade.salvarOuAtualizar(c);
            fkCidade(c);
        }
        else{
            c = daoCidade.escolher();
        }
        f.setCidade(c);


        tipo = askTipo("Usuario");
        Usuario u = new Usuario();

        if (tipo.equals("1")){
            u.preencher();
            daoUsuario.salvarOuAtualizar(u);
        }
        else{
            u = daoUsuario.escolher();
        }
        f.setUsuario(u);

    }

}
