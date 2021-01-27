package classes;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    private Date data;


    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;

    public Venda(Funcionario funcionario, Cliente cliente, Date data, Date dt_atualiza, String status) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
        this.dt_atualiza = dt_atualiza;
        this.status = status;
    }
}
