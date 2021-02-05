package modelo;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.Constantes;
import sistema.Input;

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
    private String status = Constantes.STATUS_ATIVO;

    public Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.getDescricao()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }

    public void preencher(){
        this.nome = Input.get("Digite o nome: ");
        this.descricao = Input.get("Digite a descrição: ");
    }

    //////////////////////////// Hash & Equals e toString

    @Override
    public String toString() {
        return this.nome;
    }
}

