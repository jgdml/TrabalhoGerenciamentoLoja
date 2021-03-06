package testes;

import modelo.*;
import sistema.DaoGenerico;
import sistema.DaoGenericoAssociativo;

import java.util.Date;

public class Inserts {

    public static void init(){

        Categoria cat = new Categoria("Categoria 1", "Descricao 1");
        Categoria cat2 = new Categoria("Categoria 2", "Descricao 2");

        DaoGenerico<Categoria> dcat = new DaoGenerico<>(Categoria.class);

        dcat.salvarOuAtualizar(cat);
        dcat.salvarOuAtualizar(cat2);

//==========================================================================================

        Estado est = new Estado("Estado 1", "RJ");
        Estado est1 = new Estado("Estado 2", "e2");

        DaoGenerico<Estado> dest = new DaoGenerico<>(Estado.class);

        dest.salvarOuAtualizar(est);
        dest.salvarOuAtualizar(est1);

//==========================================================================================

        Cidade cid = new Cidade ("Cidade 1", est);
        Cidade cid1 = new Cidade("Cidade 2", est);

        DaoGenerico<Cidade> dcid = new DaoGenerico<>(Cidade.class);

        dcid.salvarOuAtualizar(cid);
        dcid.salvarOuAtualizar(cid1);

//==========================================================================================

        Cliente cli = new Cliente ( "Cliente 1", "Endereço 1", "Telefone 1", "E-mail 1", "Cpf 1", cid);
        Cliente cli1 = new Cliente ( "Cliente 2", "Endereço 2", "telefone 2", "E-mail 2", "Cpf 2", cid );

        DaoGenerico<Cliente> dcli = new DaoGenerico<>(Cliente.class);

        dcli.salvarOuAtualizar(cli);
        dcli.salvarOuAtualizar(cli1);

//==========================================================================================

        Usuario usu = new Usuario ("login1","senha", true);
        Usuario usu1 = new Usuario ( "login2", "senha2", false);

        DaoGenerico<Usuario> dusu = new DaoGenerico<>(Usuario.class);

        dusu.salvarOuAtualizar(usu);
        dusu.salvarOuAtualizar(usu1);

//==========================================================================================

        Funcionario fun = new Funcionario ("Funcionario 1", "Endereço 1","Telefone 1", "E-Mail 1", "Cpf 1", "Cargo 1", cid, usu);
        Funcionario fun1 = new Funcionario ("Funcionario 2", "Endereço 2","Telefone 2", "E-Mail 2", "Cpf 2", "Cargo 2", cid, usu1);

        DaoGenerico<Funcionario> dfun = new DaoGenerico<>(Funcionario.class);

        dfun.salvarOuAtualizar(fun);
        dfun.salvarOuAtualizar(fun1);

//==========================================================================================

        Fornecedor forn = new Fornecedor ("Fornecedor 1", "Telefone 1", "Documento 1",cid );
        Fornecedor forn1 = new Fornecedor ("Fornecedor 2", "Telefone 2", "Documento 2",cid );

        DaoGenerico<Fornecedor> dforn = new DaoGenerico<>(Fornecedor.class);

        dforn.salvarOuAtualizar(forn);
        dforn.salvarOuAtualizar(forn1);

//==========================================================================================

        Compra com = new Compra (new Date(),forn);
        Compra com1 = new Compra (new Date(),forn);

        DaoGenerico<Compra> dcom = new DaoGenerico<>(Compra.class);

        dcom.salvarOuAtualizar(com);
        dcom.salvarOuAtualizar(com1);

//==========================================================================================

        Venda ven = new Venda(fun,cli, new Date());
        Venda ven1 = new Venda(fun,cli, new Date());

        DaoGenerico<Venda> dven = new DaoGenerico<>(Venda.class);

        dven.salvarOuAtualizar(ven);
        dven.salvarOuAtualizar(ven1);

//==========================================================================================

        Produto prod = new Produto ("Produto 1", 1, 16.00,cat);
        Produto prod1 = new Produto ("Produto 2", 2, 52.00,cat);

        DaoGenerico<Produto> dprod = new DaoGenerico<>(Produto.class);

        dprod.salvarOuAtualizar(prod);
        dprod.salvarOuAtualizar(prod1);

//==========================================================================================

//        VendaProduto venprod = new VendaProduto (1, prod, ven);
//        VendaProduto venprod1 = new VendaProduto (2, prod1, ven);
//
//        DaoGenericoAssociativo<VendaProduto> dvp = new DaoGenericoAssociativo<>(VendaProduto.class);
//
//        dvp.salvarOuAtualizar(venprod);
//        dvp.salvarOuAtualizar(venprod1);

////==========================================================================================

        CompraProduto comprod = new CompraProduto (1, prod, com);
        CompraProduto comprod1 = new CompraProduto (2, prod1, com);

        DaoGenericoAssociativo<CompraProduto> dcp = new DaoGenericoAssociativo<>(CompraProduto.class);

        dcp.salvarOuAtualizar(comprod);
        dcp.salvarOuAtualizar(comprod1);

//==========================================================================================



//        System.out.println(dc.findId(Categoria.class, 1).getNome());

    }
}
