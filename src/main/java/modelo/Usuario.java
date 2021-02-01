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
public class Usuario implements BaseEntity{

    private String login;
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status")
    private String status = "A";


    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void print(){
        System.out.println(
                this.getLogin()+"   "
                +this.getSenha()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }
}
