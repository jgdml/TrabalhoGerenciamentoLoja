package classes;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


@Entity
public class Estado {

    private String nome;
    private String sigla;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
