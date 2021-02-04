package sistema;

import modelo.*;

public class PreencherFk {

    private static final DaoGenerico<Cliente> daoCliente = new DaoGenerico<>(Cliente.class);
    private static final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private static final DaoGenerico<Categoria> daoCategoria = new DaoGenerico<>(Categoria.class);
    private static final DaoGenerico<Estado> daoEstado = new DaoGenerico<>(Estado.class);
    private static final DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>(Usuario.class);
    private static final DaoGenerico<Funcionario> daoFuncionario = new DaoGenerico<>(Funcionario.class);
    private static final DaoGenerico<Venda> daoVenda = new DaoGenerico<>(Venda.class);
    private static final DaoGenerico<Produto> daoProduto = new DaoGenerico<>(Produto.class);
    private static final DaoGenerico<Fornecedor> daoFornecedor = new DaoGenerico<>(Fornecedor.class);
    private static final DaoGenerico<Compra> daoCompra = new DaoGenerico<>(Compra.class);


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




    //Se o cara escolher 1 ele escolhe criar um novo cadastro
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
            fkCidade(c);
            daoCidade.salvarOuAtualizar(c);
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
            fkCidade(c);
            daoCidade.salvarOuAtualizar(c);
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



    public static void fkFornecedor(Fornecedor fr){
        String tipo = askTipo("Cidade");
        Cidade c = new Cidade();

        if(tipo.equals("1")){
            c.preencher();
            fkCidade(c);
            daoCidade.salvarOuAtualizar(c);
        }
        else{
            c = daoCidade.escolher();
        }

        fr.setCidade(c);

    }



    //Se o cara escolher 1 ele escolhe criar um novo cadastro
    public static void fkProduto(Produto produto){
        String tipo = askTipo("Categoria");
        Categoria categoria = new Categoria();

        if(tipo.equals("1")){
            categoria.preencher();
            daoCategoria.salvarOuAtualizar(categoria);
        }else{
            categoria = daoCategoria.escolher();
        }

        produto.setCategoria(categoria);

    }


    public static void fkVenda(Venda v){
        String tipo = askTipo("Cliente");
        Cliente cli = new Cliente();

        if (tipo.equals("1")){
            cli.preencher();
            fkCliente(cli);
        }
        else{
            cli = daoCliente.escolher();
        }
        v.setCliente(cli);




        tipo = askTipo("Funcionario");
        Funcionario f = new Funcionario();

        if(tipo.equals("1")){
            f.preencher();
            fkFuncionario(f);
            daoFuncionario.salvarOuAtualizar(f);
        }
        else{
            f = daoFuncionario.escolher();
        }
        v.setFuncionario(f);
    }



    public static void fkVendaProduto(VendaProduto vp){

        Venda v = new Venda();
        fkVenda(v);
        daoVenda.salvarOuAtualizar(v);
        vp.setVenda(v);


        String tipo = askTipo("Produto");
        Produto p = new Produto();

        if(tipo.equals("1")){
            p.preencher();
            fkProduto(p);
            daoProduto.salvarOuAtualizar(p);
        }
        else{
            p = daoProduto.escolher();
        }
        vp.setProduto(p);
    }


    public static void fkCompra(Compra compra) {
        String tipo = askTipo("Fornecedor");
        Fornecedor fornecedor = new Fornecedor();

        if (tipo.equals("1")) {
            fornecedor.preencher();
            fkFornecedor(fornecedor);
            daoFornecedor.salvarOuAtualizar(fornecedor);
        } else {
            fornecedor = daoFornecedor.escolher();
        }
        compra.setFornecedor(fornecedor);
    }



    public static void fkCompraProduto(CompraProduto compraProduto){

        String tipo = askTipo("Produto");
        Produto p = new Produto();

        if(tipo.equals("1")){
            p.preencher();
            fkProduto(p);
            daoProduto.salvarOuAtualizar(p);
        }
        else{
            p = daoProduto.escolher();
        }

        Compra compra = new Compra();
        fkCompra(compra);
        daoCompra.salvarOuAtualizar(compra);
        compraProduto.setCompra(compra);


        compraProduto.setProduto(p);
    }

}
