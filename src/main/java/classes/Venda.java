package classes;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Funcionario funcionario;
    private Cliente cliente;
    private Date data;
    private List<Produto> produto;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'T' ")
    private String status;

    Venda(Funcionario funcionario, Cliente cliente, Date data, List<Produto> produto){
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

    public List<Produto> getProduto() {
        return produto;
    }
    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDt_atualiza() {
        return dt_atualiza;
    }

    public void setDt_atualiza(Date dt_atualiza) {
        this.dt_atualiza = dt_atualiza;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //////////////////////////// Hash & Equals e toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
