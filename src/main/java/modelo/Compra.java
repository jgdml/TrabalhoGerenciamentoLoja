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
public class Compra implements BaseEntity{

    private Date data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="fornecedor_id")
    private Fornecedor fornecedor;


    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = "A";

    public Compra(Date data, Fornecedor fornecedor) {
        this.data = data;
        this.fornecedor = fornecedor;

    }
}
