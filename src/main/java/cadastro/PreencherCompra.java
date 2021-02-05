package cadastro;

import modelo.Compra;
import modelo.CompraProduto;
import modelo.Fornecedor;
import modelo.Produto;
import sistema.DaoGenerico;

public class PreencherCompra extends PreencherBase{

    private final PreencherFornecedor preencherFornecedor = new PreencherFornecedor();
    private final PreencherProduto preencherProduto = new PreencherProduto();

    private final DaoGenerico<Fornecedor> daoFornecedor = new DaoGenerico<>(Fornecedor.class);
    private final DaoGenerico<Compra> daoCompra = new DaoGenerico<>(Compra.class);
    private final DaoGenerico<Produto> daoProduto = new DaoGenerico<>(Produto.class);

    private Compra preencherCompra(){

        String tipo = askTipo("Fornecedor");
        Fornecedor fornecedor;
        Compra compra = new Compra();

        if (tipo.equals("1")) {
            fornecedor = preencherFornecedor.preencherTudo();
            daoFornecedor.salvarOuAtualizar(fornecedor);

        } else {
            fornecedor = daoFornecedor.escolher();
        }
        compra.setFornecedor(fornecedor);

        return compra;



    }

    public CompraProduto preencherTudo(){
        String tipo = askTipo("Produto");
        Produto produto;
        CompraProduto compraProduto = new CompraProduto();

        if(tipo.equals("1")){
            produto = preencherProduto.preencherTudo();
            daoProduto.salvarOuAtualizar(produto);
        }
        else{
            produto = daoProduto.escolher();

        }

        Compra compra;
        compra = preencherCompra();

        daoCompra.salvarOuAtualizar(compra);
        compraProduto.setCompra(compra);

        compraProduto.preencher();
        compraProduto.setProduto(produto);

        produto.setEstoque(produto.getEstoque()+ compraProduto.getQuantidade());
        daoProduto.salvarOuAtualizar(produto);

        return compraProduto;
    }

}
