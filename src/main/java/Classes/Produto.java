package Classes;

import java.util.List;

public class Produto {

    private String nome;
    private int estoque;
    private double preco;
    private Categoria categoria;
    private List<Venda> venda;

    Produto(String nome, int estoque, double preco, Categoria categoria, List<Venda> venda){
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.categoria = categoria;
        this.venda = venda;
    }

    ///GETs and SETs

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Venda> getVenda() {
        return venda;
    }
    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }

}
