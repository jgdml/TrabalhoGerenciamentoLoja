package cadastro;

import modelo.Cidade;
import modelo.Estado;
import sistema.DaoGenerico;

public class PreencherCidade extends PreencherBase {

    // Instanciar o Dao da FK de Cidade, neste caso, o dao estado
    private final DaoGenerico<Estado> daoEstado = new DaoGenerico<>(Estado.class);


    public Cidade preencherTudo(){
        // Instancia uma cidade nova porque o usuário selecionou para criar uma nova cidade
        Cidade cidade = new Cidade();
        // Prencher a cidade criada
        cidade.preencher();

        // Fazer o input para saber se o usuário quer criar um novo Estado(FK) ou selecionar um que ja existe
        String tipo = askTipo("Estado");

        // Instanciar a FK
        Estado estado = new Estado();


        // Caso o usuário quiser cadastrar um novo Estado(FK)
        if (tipo.equals("1")){
            // Preencher o estado criado
            estado.preencher();

            // Salvar o novo estado no banco
            daoEstado.salvarOuAtualizar(estado);
        }
        else{
            // Caso o usuário quiser escolher um Estado(FK) existente
            estado = daoEstado.escolher();
        }

        // Settar que a Cidade criada pertence ao Estado(FK) criada
        cidade.setEstado(estado);

        // Retornar a cidade para salvar ela com o daoCidade no Menu
        return cidade;
    }
}
