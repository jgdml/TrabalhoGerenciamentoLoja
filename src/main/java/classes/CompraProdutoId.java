package classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode

public class CompraProdutoId implements Serializable {


    @ManyToOne
    @JoinColumn(name="produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="compra_id")
    private Compra compra;


}
