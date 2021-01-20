package Classes;
import java.util.Date;

public class Compra {

    private Date data;
    private Fornecedor fornecedor;

    Compra(Date data, Fornecedor fornecedor){
        this.data = data;
        this.fornecedor = fornecedor;
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

}
