package cadastro;

import modelo.Cidade;
import modelo.Cliente;
import sistema.DaoGenerico;

public class PreencherCliente extends PreencherBase {




    // Instanciar o Dao da FK para salvar ela antes de linkar com cliente
    private final DaoGenerico<Cidade> daoCidade = new DaoGenerico<>(Cidade.class);

    // Instanciar a classe que preenche cliente, desse jeito o usuário
    // pode inserir um novo estado em cidade ou selecionar um existente
    private final PreencherCidade preencherCidade = new PreencherCidade();


    public Cliente preencherTudo(){
        Cliente cliente = new Cliente();
        // Preenchendo novo cliente
        cliente.preencher();

        // Tipo de operação que será feita
        String tipo = askTipo("Cidade");

        // Não é necessário instanciar a FK neste caso pois
        // ela vai receber um valor instanciado com return de preencherTudo() ou escolher()
        Cidade cidade;

        if (tipo.equals("1")){
            cidade = preencherCidade.preencherTudo();
            daoCidade.salvarOuAtualizar(cidade);
        }
        else{
            cidade = daoCidade.escolher();
        }

        // Setando a cidade do cliente
        cliente.setCidade(cidade);

        // Retornando para ser salva
        return cliente;
    }
}
