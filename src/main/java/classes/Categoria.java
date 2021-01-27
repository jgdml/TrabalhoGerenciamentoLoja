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
public class Categoria {

    private String nome;
    private String descricao;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;

    public Categoria(String nome, String descricao, Date dt_atualiza, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dt_atualiza = dt_atualiza;
        this.status = status;
    }

    //////////////////////////// Hash & Equals e toString


    @Override
    public String toString() {
        return this.nome;
    }
}
