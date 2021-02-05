package cadastro;

import modelo.Cidade;
import modelo.Fornecedor;
import sistema.DaoGenerico;

public class PreencherFornecedor extends PreencherBase{

    private final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);
    private final PreencherCidade preencherCidade = new PreencherCidade();

    public Fornecedor preencherTudo(){

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.preencher();

        String tipo = askTipo("Cidade");
        Cidade cidade = new Cidade();

        if (tipo.equals("1")){
            cidade = preencherCidade.preencherTudo();
            daoCidade.salvarOuAtualizar(cidade);
        }
        else{
            cidade = daoCidade.escolher();
        }

        fornecedor.setCidade(cidade);
        return fornecedor;
    }
}
