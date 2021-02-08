package modelo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sistema.Constantes;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Compra implements BaseEntity{

    //new Date para pegar data Automaticamente
    private Date data = new Date();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="fornecedor_id")
    private Fornecedor fornecedor;


    //Status e Dt de atualização atomática
    private Date dt_atualiza = new Date();

    @Column(name="status")
    private String status = Constantes.STATUS_ATIVO;

    public Compra(Date data, Fornecedor fornecedor) {
        this.data = data;
        this.fornecedor = fornecedor;

    }

    //prints
    public void printLegenda(){
        System.out.format("%-15s%-15s%n", "Data", "Fornecedor");
    }

    public void print(){
        System.out.format("%-15s%-15s%n"
                ,this.getData()
                ,this.fornecedor.getNome()

        );
    }

//    public void print(){
//        System.out.println(
//                this.getData()+"   "
//                +this.getFornecedor()+"   "
//                +this.getStatus()+"   ");
//    }

}
