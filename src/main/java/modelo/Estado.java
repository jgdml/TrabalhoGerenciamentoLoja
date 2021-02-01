package modelo;


import lombok.*;
import sistema.Constantes;

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


    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;

    public Estado(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.getSigla()+"   "
                +this.getStatus());
    }
}
