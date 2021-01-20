package classes;

public class Funcionario {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String cargo;
    private Cidade cidade;
    private Usuario usuario;

    Funcionario(String nome, String endereco, String telefone, String email, String cpf, String cargo, Cidade cidade, Usuario usuario){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.cidade = cidade;
        this.usuario = usuario;
    }

    ///Gets & Sets
    public String getNome() {return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
