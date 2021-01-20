package Classes;
import java.util.Date;

public class Venda {
    Funcionario funcionario;
    Cliente cliente;
    Date data;

    Venda(Funcionario funcionario, Cliente cliente, Date data){
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
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
