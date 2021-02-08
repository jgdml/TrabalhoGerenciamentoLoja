package modelo;

import lombok.*;
import sistema.Constantes;
import sistema.Input;

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


    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    //prints
    public void printLegenda(){
        System.out.format("%-15s%-15s%n", "Nome", "Estado");
    }

    public void print(){
        System.out.format("%-15s%-15s%n"
                ,this.getNome()
                ,this.estado.getNome()

        );
    }
    public void preencher(){
        this.nome = Input.get("Digite o nome da cidade: ");
    }
}