package modelo;
import lombok.*;
import sistema.Constantes;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Venda implements BaseEntity{

    //new Date para pegar data Automaticamente
    private Date data = new Date();

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
    private String status = Constantes.STATUS_ATIVO;


    public Venda(Funcionario funcionario, Cliente cliente, Date data) {
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data = data;
    }

    //Prints
    public void printLegenda(){
        System.out.format("%-15s%-15s%-15s%%n", "Nome Funcionario", "Nome Cliente", "Data", "Categoria");
    }

    public void print(){
        System.out.format("%-15s%-15s%-15s%%n"
                ,this.funcionario.getNome()
                ,this.cliente.getNome()
                ,this.getData()+"  "
        );
    }
//    public void print(){
//        System.out.println(
//                this.funcionario.getNome()+"   "
//                +this.cliente.getNome()+"   "
//                +this.getData()+"  "
//                +this.getStatus()+"   "
//                +this.getDt_atualiza());
//    }
}
