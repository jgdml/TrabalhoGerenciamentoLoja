package Classes;
import java.util.Date;
import java.util.List;

public class Compra {

    private Date data;
    private Fornecedor fornecedor;
    private List<Produto> produto;

    Compra(Date data, Fornecedor fornecedor, List<Produto> produto){
        this.data = data;
        this.fornecedor = fornecedor;
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
