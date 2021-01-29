package classes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Fornecedor {

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
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;


    public Fornecedor(String nome, String telefone, String documento, Cidade cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
        this.cidade = cidade;
    }
}
