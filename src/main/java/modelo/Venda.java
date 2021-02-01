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
public class Venda implements BaseEntity{

    private Date data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;


    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";


    public Venda(Funcionario funcionario, Cliente cliente, Date data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
    }

    public void print(){
        System.out.println(
                this.funcionario.getNome()+"   "
                +this.cliente.getNome()+"   "
                +this.getData()+"  "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }
}
