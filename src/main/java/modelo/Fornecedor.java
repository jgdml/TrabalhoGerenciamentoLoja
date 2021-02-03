package modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import sistema.Constantes;
import sistema.Input;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Fornecedor implements BaseEntity{

    private String nome;
    private String telefone;
    private String documento;

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


    public Fornecedor(String nome, String telefone, String documento, Cidade cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
        this.cidade = cidade;
    }

    public void print(){
        System.out.println(
                this.getNome()+"   "
                +this.getTelefone()+"   "
                +this.getDocumento()+"  "
                +this.cidade.getNome()+"   "
                +this.getStatus()+"   "
                +this.getDt_atualiza());
    }

    public void preencher(){
        this.nome = Input.get("Digite o nome: ");
        this.telefone = Input.get("Digite a telefone: ");
        this.documento = Input.get("Digite o documento");
    }

}
