package classes;

import lombok.*;

import javax.persistence.JoinColumn;


@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode

public class VendaProdutoId {

    @JoinColumn(name="produto_id")
    private Produto produto;

    @JoinColumn(name="venda_id")
    private Venda venda;


    public VendaProdutoId(Produto produto, Venda venda) {
        this.produto = produto;
        this.venda = venda;
    }



}
