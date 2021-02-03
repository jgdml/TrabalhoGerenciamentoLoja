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

    public void preencher(){
        this.nome = Input.get("Digite o nome da cidade: ");
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.estado.getNome()+"   "
                +this.getStatus());
    }
}