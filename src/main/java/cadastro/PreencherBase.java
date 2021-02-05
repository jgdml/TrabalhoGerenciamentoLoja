package cadastro;

import sistema.Input;

public class PreencherBase {

    public String askTipo(String classe){
        while (true){
            System.out.println("\n\nÉ obrigatorio ter um "+classe+" neste registro");
            String op = Input.get(String.format("\n1. Criar novo registro de %s \n2. Selecionar registro existente de %s\nOpção: ", classe, classe));

            if (op.equals("1") || op.equals("2")){
                return op;
            }
            else{
                System.out.println("Opção inválida");
            }
        }
    }
}
