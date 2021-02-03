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
    private Date dt_atualiza;

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;


    public Usuario(String login, String senha, Boolean isAdm) {
        this.login = login;
        this.senha = senha;
        this.isAdm = isAdm;
    }

    public void print(){
        System.out.println(
                this.getLogin()+"   "
                +this.getSenha()+"   "
                +this.getIsAdm()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }

    public void preencher(){
        this.login = Input.get("Digite o nome: ");
        this.senha = Input.get("Digite a endereco: ");
    }
}
