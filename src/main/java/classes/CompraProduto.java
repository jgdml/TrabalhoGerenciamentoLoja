package classes;

public class CompraProduto {

    private Produto produto;
    private Compra compra;
    private int quantidade;
    private double preco;

    CompraProduto(Produto produto, Compra compra, int quantidade, double preco){
        this.produto = produto;
        this.compra = compra;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }

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
