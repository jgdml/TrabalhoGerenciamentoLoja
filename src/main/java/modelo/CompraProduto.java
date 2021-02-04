package modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.Constantes;
import sistema.Input;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@IdClass(CompraProdutoId.class)
public class CompraProduto implements BaseEntityAssociativa {

    private int quantidade;
    private double preco;


    @Id
    private Produto produto;
    @Id
    private Compra compra;


    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;



    public CompraProduto(int quantidade, Produto produto, Compra compra) {
        this.quantidade = quantidade;
        this.preco = produto.getPreco() * quantidade;
        this.produto = produto;
        this.compra = compra;
    }

    public void print(){
        System.out.println(
                this.produto.getNome()+"  "
                +this.getQuantidade()+"   "
                +this.getPreco()+"   "
                +this.compra.getData()+"   ");
    }

    public void preencher(){
        this.quantidade = Input.getInt("Digite o quantidade: ");
    }

    public Boolean keyExists(){
        if (this.compra != null && this.produto != null){
            return true;
        }
        return false;
    }
}
