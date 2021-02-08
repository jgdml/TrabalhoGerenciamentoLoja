package modelo;

import lombok.*;
import sistema.Constantes;
import sistema.Input;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@IdClass(VendaProdutoId.class)
public class VendaProduto implements BaseEntityAssociativa {

    private int quantidade;
    private double preco;

    @Id
    private Produto produto;
    @Id
    private Venda venda;


    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;



    public VendaProduto(int quantidade, Produto produto, Venda venda) {
        this.quantidade = quantidade;
        this.preco = produto.getPreco() * quantidade;
        this.produto = produto;
        this.venda = venda;
    }


    public void printLegenda(){
        System.out.format("%-15s%-15s%-15s%-15s%n", "Nome", "Quantidade", "Preco", "Data");
    }

    public void print(){
        System.out.format("%-15s%-15s%-15s%-15s%n"
                ,this.produto.getNome()
                ,this.getQuantidade()
                ,this.getPreco()
                ,this.venda.getData()
        );
    }
//    public void print(){
//        System.out.println(
//                this.produto.getNome()+"  "
//                +this.getQuantidade()+"   "
//                +this.getPreco()+"   "
//                +this.venda.getData()+"   ");
//    }

    public void preencher(){
        this.quantidade = Input.getInt("Digite a quantidade: ");
    }

    public Boolean keyExists(){
        if (this.venda != null && this.produto != null){
            return true;
        }
        return false;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
        this.preco = produto.getPreco() * this.quantidade;
    }
}