package modelo;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@IdClass(VendaProdutoId.class)
public class VendaProduto {

    private int quantidade;
    private double preco;

    @Id
    private Produto produto;
    @Id
    private Venda venda;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;


    public VendaProduto(int quantidade, double preco, Produto produto, Venda venda) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.venda = venda;
    }
}