package modelo;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Cidade implements BaseEntity{

    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="estado_id")
    private Estado estado;


    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }
}