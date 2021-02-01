package modelo;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Funcionario implements BaseEntity{

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String cargo;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    @OneToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";



    public Funcionario(String nome, String endereco, String telefone, String email, String cpf, String cargo, Cidade cidade, Usuario usuario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.cidade = cidade;
        this.usuario = usuario;
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.getEndereco()+"   "
                +this.getTelefone()+"  "
                +this.getEmail()+"   "
                +this.getCpf()+"   "
                +this.getCargo()+"   "
                +this.cidade.getNome()+"   "
                +this.usuario.getLogin());
    }
}
