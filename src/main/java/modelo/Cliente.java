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
public class Cliente {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

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


    public Cliente(String nome, String endereco, String telefone, String email, String cpf, Cidade cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cidade = cidade;
    }


//    @Override
//    public int hashCode() {return getClass().hashCode();}

    @Override
    public String toString() {
        return this.nome;
    }

}
