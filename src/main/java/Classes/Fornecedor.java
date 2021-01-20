package Classes;

public class Fornecedor {

    private String nome;
    private String telefone;
    private String documento;
    private Cidade cidade;

    Fornecedor(String nome, String telefone, String documento, Cidade cidade){
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;

        this.cidade = cidade;
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

}
