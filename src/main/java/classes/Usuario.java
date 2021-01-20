package classes;

public class Usuario {

    private String senha;
    private String login;

    Usuario(String senha, String login){
        this.senha = senha;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
