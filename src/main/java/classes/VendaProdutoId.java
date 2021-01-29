package classes;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor

public class VendaProdutoId implements Serializable {

    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="venda_id")
    private Venda venda;


}
