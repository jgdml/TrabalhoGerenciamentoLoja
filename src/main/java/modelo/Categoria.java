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
public class Categoria implements BaseEntity{


    private String nome;
    private String descricao;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    //////////////////////////// Hash & Equals e toString


    @Override
    public String toString() {
        return this.nome;
    }
}
