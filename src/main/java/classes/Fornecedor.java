package classes;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Fornecedor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String telefone;
    private String documento;

    @ManyToOne
    @JoinColumn(name="cidade_id")
    private Cidade cidade;

    //Status e Dt de atualização atomática
    @ColumnDefault( value = "CURRENT_TIMESTAMP" )
    private Date dt_atualiza;

    @Column(name="status",  columnDefinition = "char(1) default 'A' ")
    private String status;



    @Deprecated
    public Fornecedor() {}

    public Fornecedor(String nome, String telefone, String documento, Cidade cidade, Date dt_atualiza, String status) {
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
        this.cidade = cidade;
        this.dt_atualiza = dt_atualiza;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDt_atualiza() {
        return dt_atualiza;
    }

    public void setDt_atualiza(Date dt_atualiza) {
        this.dt_atualiza = dt_atualiza;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    //////////////////////////// Hash & Equals e toString


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
