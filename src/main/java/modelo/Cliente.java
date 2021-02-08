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
public class Cliente implements BaseEntity{

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
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;



    public Cliente(String nome, String endereco, String telefone, String email, String cpf, Cidade cidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    //Prints
    public void printLegenda(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%n", "Nome", "Endereco", "Telefone", "Email", "Cpf", "Cidade");
    }

    public void print(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%n"
                ,this.getNome()
                ,this.getEndereco()
                ,this.getTelefone()
                ,this.getEmail()
                ,this.getCpf()
                ,this.cidade.getNome()
        );
    }

//    public void print(){
//        System.out.println(
//                this.getNome()+"   "
//                +this.getEndereco()+"   "
//                +this.getTelefone()+"   "
//                +this.getEmail()+"   "
//                +this.getCpf()+"   "
//                +this.cidade.getNome());
//    }

    public void preencher(){
        this.nome = Input.get("Digite o nome do cliente: ");
        this.endereco = Input.get("Digite o endereço: ");
        this.telefone = Input.get("Digite o telefone: ");
        this.email = Input.get("Digite o email: ");
        this.cpf = Input.get("Digite o cpf: ");
    }


//    @Override
//    public int hashCode() {return getClass().hashCode();}

    @Override
    public String toString() {
        return this.nome;
    }

}
