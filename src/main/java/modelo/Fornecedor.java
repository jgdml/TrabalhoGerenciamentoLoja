package modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Fornecedor implements BaseEntity{

    private String nome;
    private String telefone;
    private String documento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";


    public Fornecedor(String nome, String telefone, String documento, Cidade cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
        this.cidade = cidade;
    }
}