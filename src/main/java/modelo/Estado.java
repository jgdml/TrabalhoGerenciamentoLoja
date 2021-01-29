package modelo;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


@Entity
public class Estado implements BaseEntity{

    private String nome;
    private String sigla;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
