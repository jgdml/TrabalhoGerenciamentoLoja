package classes;

public class VendaProduto {
    private Produto produto;
    private Venda venda;
    private int quantidade;
    private double preco;


    VendaProduto(Produto produto, Venda venda, int quantidade, double preco) {
        this.produto = produto;
        this.venda = venda;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    ///GETs and SETs

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {this.produto = produto;}

    public Venda getVenda() {return venda;}
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}