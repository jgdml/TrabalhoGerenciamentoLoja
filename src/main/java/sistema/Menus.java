package sistema;


import java.io.IOException;

public class Menus {


    public static void bemVindo() {

        System.out.println("\n【Este é o \uD835\uDC6E\uD835\uDC86\uD835\uDC93\uD835\uDC86\uD835\uDC8F\uD835\uDC84\uD835\uDC8A\uD835\uDC82\uD835\uDC8E\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC90 \uD835\uDC73\uD835\uDC90\uD835\uDC8B\uD835\uDC82】");
        System.out.println("【Seja Bem Vindo!】");

    }

    public static void menuLogin() {
        System.out.println("┃☰☰\uD835\uDE47\uD835\uDE64\uD835\uDE5C\uD835\uDE5E\uD835\uDE63☰☰\n" +
                "┃\n" +
                "┃Login:");

        System.out.println("┃\n" +
                "┃\n" +
                "┃Senha:");

        System.out.println("┃\n" +
                "┃☰☰☰☰☰☰☰");
    }

    public static void menuPrincipal() {
        System.out.println("┃☰☰\uD835\uDC6E\uD835\uDC86\uD835\uDC93\uD835\uDC86\uD835\uDC8F\uD835\uDC84\uD835\uDC8A\uD835\uDC82\uD835\uDC8E\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC90 \uD835\uDC73\uD835\uDC90\uD835\uDC8B\uD835\uDC82☰☰\n" +
                "┃\n" +
                "┃1. Realizar Venda\n" +
                "┃2. Realizar Compra\n" +
                "┃3. Produtos\n" +
                "┃4. Clientes\n" +
                "┃5. Utilidades\n" +
                "┃6. Admin\n" +
                "┃0. Sair\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰☰☰☰☰☰");
    }


    public static void menuProdutos() {
        System.out.println("┃☰☰\uD835\uDC77\uD835\uDC93\uD835\uDC90\uD835\uDC85\uD835\uDC96\uD835\uDC95\uD835\uDC90\uD835\uDC94☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar novo\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰");
    }

    public static void menuClientes(){
        System.out.println("┃☰☰\uD835\uDC6A\uD835\uDC8D\uD835\uDC8A\uD835\uDC86\uD835\uDC8F\uD835\uDC95\uD835\uDC86\uD835\uDC94☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar novo\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰");
    }

    public static void menuAdmin(){
        System.out.println("┃☰☰\uD835\uDC68\uD835\uDC85\uD835\uDC8E\uD835\uDC8A\uD835\uDC8F☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar usuário\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar usuário\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰");
    }

    public static void menuUtilidades(){
        System.out.println("┃☰☰\uD835\uDC7C\uD835\uDC95\uD835\uDC8A\uD835\uDC8D\uD835\uDC8A\uD835\uDC85\uD835\uDC82\uD835\uDC85\uD835\uDC86\uD835\uDC94☰☰\n" +
                "┃\n" +
                "┃1. Ver vendas\n" +
                "┃2. Ver compras\n" +
                "┃3. Fornecedor\n" +
                "┃4. Cidade e Estado\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰");
    }

    public static void menuFornecedor(){
        System.out.println("┃☰☰\uD835\uDC6D\uD835\uDC90\uD835\uDC93\uD835\uDC8F\uD835\uDC86\uD835\uDC84\uD835\uDC86\uD835\uDC85\uD835\uDC90\uD835\uDC93☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar novo\n" +
                "┃2. Ver todos\n" +
                "┃3. Alterar cadastro\n" +
                "┃4. Deletar\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰");
    }

    public static void menuCidadeEstado(){
        System.out.println("┃☰☰\uD835\uDC6A\uD835\uDC8A\uD835\uDC85\uD835\uDC82\uD835\uDC85\uD835\uDC86 \uD835\uDC86 \uD835\uDC6C\uD835\uDC94\uD835\uDC95\uD835\uDC82\uD835\uDC85\uD835\uDC90☰☰\n" +
                "┃\n" +
                "┃1. Cadastrar cidade\n" +
                "┃2. Cadastrar estado\n" +
                "┃3. Ver Cidades\n" +
                "┃4. Ver Estados\n" +
                "┃5. Alterar Cidade\n" +
                "┃6. Alterar Estado\n" +
                "┃0. Voltar\n" +
                "┃\n" +
                "┃☰☰☰☰☰☰☰☰☰☰☰☰☰");
    }
}