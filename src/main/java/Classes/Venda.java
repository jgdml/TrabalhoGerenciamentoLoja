package Classes;
import java.util.Date;
import java.util.List;


public class Venda {
    private Funcionario funcionario;
    private Cliente cliente;
    private Date data;
    private List<Produto> produto;

    Venda(Funcionario funcionario, Cliente cliente, Date data, List<Produto> produto;){
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.produto = produto;
    }

    ///GETs and SETs
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}
