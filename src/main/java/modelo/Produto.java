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
public class Produto implements BaseEntity{

    private String nome;
    private int estoque;
    private double preco;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;



    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";


    public Produto(String nome, int estoque, double preco, Categoria categoria) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.getEstoque()+"   "
                +this.getPreco()+"  "
                +this.categoria.getNome()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }
}
