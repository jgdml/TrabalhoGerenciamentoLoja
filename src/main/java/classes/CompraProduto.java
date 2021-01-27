package classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

//@Entity
public class CompraProduto {

    private int quantidade;
    private double preco;


    private Produto produto;
    private Compra compra;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status", columnDefinition = "char(1) default 'A' ")
    private String status;


    public CompraProduto(int quantidade, double preco, Produto produto, Compra compra, Date dt_atualiza, String status) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
        this.compra = compra;
        this.dt_atualiza = dt_atualiza;
        this.status = status;
    }
}
