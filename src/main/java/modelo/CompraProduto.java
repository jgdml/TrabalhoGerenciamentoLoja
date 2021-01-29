package modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

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
public class CompraProduto {

    private int quantidade;
    private double preco;


    @Id
    private Produto produto;
    @Id
    private Compra compra;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status", columnDefinition = "char(1) default 'A' ")
    private String status;


    public CompraProduto(int quantidade, double preco, Produto produto, Compra compra) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.compra = compra;
    }
}
