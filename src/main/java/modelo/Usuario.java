package modelo;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import sistema.Constantes;
import sistema.Input;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Usuario implements BaseEntity{

    private String login;
    private String senha;
    private Boolean isAdm;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;


    public Usuario(String login, String senha, Boolean isAdm) {
        this.login = login;
        this.senha = senha;
        this.isAdm = isAdm;
    }

    //prints
    public void printLegenda(){
        System.out.format("%-15s%-15s%-15s%n", "login", "Senha", "IsAdm");
    }

    public void print(){
        System.out.format("%-15s%-15s%-15s%n"
                ,this.getLogin()+"   "
                ,this.getSenha()
                ,this.getIsAdm()

        );
    }

//    public void print(){
//        System.out.println(
//                this.getLogin()+"   "
//                +this.getSenha()+"   "
//                +this.getIsAdm()+"   "
//                +this.getStatus()+"   "
//                +this.getDt_atualiza());
//    }

    public void preencher(){
        this.login = Input.get("Digite o login: ");
        this.senha = Input.get("Digite o senha: ");
        this.isAdm = Input.getBool("Digite se o usuario é ADM: ");
    }
}
