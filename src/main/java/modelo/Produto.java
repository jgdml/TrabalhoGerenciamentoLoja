package modelo;

import lombok.*;
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
    private String status = Constantes.STATUS_ATIVO;


    public Produto(String nome, int estoque, double preco, Categoria categoria) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
    }

    public void print(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s%n"
                ,this.getNome()
                ,this.getEstoque()
                ,this.getPreco()+"  "
                ,this.categoria.getNome()+"   "
                ,this.getDt_atualiza());
    }

    public void preencher(){
        this.nome = Input.get("Digite o nome: ");
        this.estoque = Input.getInt("Digite o estoque: ");
        this.preco = Input.getDouble("Digite o preço: ");
    }
}
