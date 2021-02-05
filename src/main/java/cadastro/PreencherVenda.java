package cadastro;

import modelo.*;
import sistema.Constantes;
import sistema.DaoGenerico;
import sistema.Input;

public class PreencherVenda extends PreencherBase {

    private final PreencherCliente preencherCliente = new PreencherCliente();
    private final PreencherFuncionario preencherFuncionario = new PreencherFuncionario();

    private final DaoGenerico<Venda> daoVenda = new DaoGenerico<>(Venda.class);
    private final DaoGenerico<Cliente> daoCliente= new DaoGenerico<>(Cliente.class);
    private final DaoGenerico<Funcionario> daoFuncionario = new DaoGenerico<>(Funcionario.class);
    private final DaoGenerico<Produto> daoProduto = new DaoGenerico<>(Produto.class);


    // Preencher uma venda primeiro pois nao pode ter venda sem venda_produto e vice versa
    private Venda preencherVenda(){
        // Pedir pela fk cliente da venda
        String tipo = askTipo("Cliente");

        Venda venda = new Venda();
        // fk cliente
        Cliente cliente;

        if (tipo.equals("1")){
            // preenchendo tudo da nova fk cliente, incluindo cidade e estado
            cliente = preencherCliente.preencherTudo();
            // salvar o novo cliente antes de coloca lo na venda
            daoCliente.salvarOuAtualizar(cliente);
        }
        else{
            // escolher um cliente já cadastrado
            cliente = daoCliente.escolher();
        }
        venda.setCliente(cliente);



        // pedindo fk funcionario
        tipo = askTipo("Funcionario");
        Funcionario funcionario;

        if(tipo.equals("1")){
            // preenchendo tudo da fk nova
            funcionario = preencherFuncionario.preencherTudo();
            daoFuncionario.salvarOuAtualizar(funcionario);
        }
        else{
            // escolhendo funcionario ja cadastrado
            funcionario = daoFuncionario.escolher();
        }
        // setando funcionario na venda
        venda.setFuncionario(funcionario);

        return venda;
    }




    public VendaProduto preencherTudo(){
        // criando uma nova venda para colocar como fk
        Venda venda = preencherVenda();
        daoVenda.salvarOuAtualizar(venda);

        VendaProduto vendaProduto = new VendaProduto();
        vendaProduto.setVenda(venda);


        // escolhendo um produto ja cadastrado
        Produto produto = daoProduto.escolher();
        // verificando se o produto tem estoque para ser vendido
        while(produto.getEstoque()<0){
            System.out.println(Constantes.ERRO_SEM_ESTOQUE);
            produto = daoProduto.escolher();
        }

        int qntde = Input.getInt("Digite a quantidade a vender: ");
        // verificando se a quantidade não é maior que a disponivel no estoque
        while(qntde > produto.getEstoque()){
            System.out.println(Constantes.ERRO_ESTOQUE_INSUFICIENTE);
            qntde = Input.getInt("Digite a quantidade a vender: ");
        }

        // atualizando o estoque do produto
        produto.setEstoque(produto.getEstoque() - qntde);
        // salvando alteração
        daoProduto.salvarOuAtualizar(produto);

        // setando quantidade a ser vendida
        vendaProduto.setQuantidade(qntde);
        vendaProduto.setProduto(produto);

        // retornando a venda_produto para ser salva
        return vendaProduto;
    }

}
