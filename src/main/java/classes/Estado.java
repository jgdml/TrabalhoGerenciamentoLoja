package classes;

public class Estado {

    private String nome;
    private String sigla;

    Estado(String nome, String sigla){
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        sigla = sigla;
    }
}
