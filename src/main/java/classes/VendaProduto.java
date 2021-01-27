package classes;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class VendaProduto {


    private Produto produto;
    private Venda venda;
    private int quantidade;
    private double preco;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;


    @Deprecated
    public VendaProduto() {}

    VendaProduto(Produto produto, Venda venda, int quantidade, double preco) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    ///GETs and SETs

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {this.produto = produto;}

    public Venda getVenda() {return venda;}
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
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
}