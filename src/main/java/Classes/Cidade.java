package Classes;

public class Cidade {

    private String  nome;
    private Estado estado;


    Cidade(String nome, Estado estado){
        this.nome = nome;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
