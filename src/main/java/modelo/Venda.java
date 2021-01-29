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
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;

    public Venda(Funcionario funcionario, Cliente cliente, Date data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
    }
}
