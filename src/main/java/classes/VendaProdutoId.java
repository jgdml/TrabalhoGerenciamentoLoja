package classes;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.util.Objects;

@Entity
public class VendaProdutoId {

    @JoinColumn(name="produto_id")
    private Produto produto;

    @JoinColumn(name="venda_id")
    private Venda venda;

    public VendaProdutoId(){}

    public VendaProdutoId(Produto produto, Venda venda) {
        this.produto = produto;
        this.venda = venda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaProdutoId that = (VendaProdutoId) o;
        return Objects.equals(produto, that.produto) &&
                Objects.equals(venda, that.venda);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
