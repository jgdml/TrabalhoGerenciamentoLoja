package modelo;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class CompraProdutoId implements Serializable {


    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="compra_id")
    private Compra compra;


}
