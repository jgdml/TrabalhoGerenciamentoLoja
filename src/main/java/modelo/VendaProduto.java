package modelo;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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



    public VendaProduto(int quantidade, double preco, Produto produto, Venda venda) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.venda = venda;
    }

    public void print(){
        System.out.println(
                this.getQuantidade()+"   "
                +this.getPreco()+"   "
                +this.produto.getNome()+"  "
                +this.venda.getData()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }

    public void preencher(){
        this.quantidade = Input.getInt("Digite o nome: ");
        this.preco = Input.getDouble("Digite a endereco: ");
    }
}