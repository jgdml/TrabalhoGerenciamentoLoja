package cadastro;

import modelo.Cidade;
import modelo.Funcionario;
import sistema.DaoGenerico;
import modelo.Usuario;

public class PreencherFuncionario extends PreencherBase{

    private final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private final DaoGenerico<Usuario> daoUsuario = new DaoGenerico<>(Usuario.class);
    private final PreencherCidade preencherCidade = new PreencherCidade();

    public Funcionario preencherTudo(){

        Funcionario funcionario = new Funcionario();

        funcionario.preencher();

        String tipo = askTipo("Cidade");
        Cidade cidade;

        if (tipo.equals("1")){
            cidade = preencherCidade.preencherTudo();
            daoCidade.salvarOuAtualizar(cidade);
        }
        else{
            cidade = daoCidade.escolher();
        }

        funcionario.setCidade(cidade);

        tipo = askTipo("Usuario");
        Usuario usuario = new Usuario();

        if (tipo.equals("1")){
            usuario.preencher();
            daoUsuario.salvarOuAtualizar(usuario);
        }
        else{
            usuario = daoUsuario.escolher();
        }

        funcionario.setUsuario(usuario);

        return funcionario;
    }
}
