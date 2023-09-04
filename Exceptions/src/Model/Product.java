package Model;

import java.text.DecimalFormat;

public class Product {
    private int codigo;
    private double preco;
    private String nome;

    public Product(int codigo, double preco, String nome){
        super();
        if (codigo <= 0){
            throw new IllegalArgumentException("O código não pode ser nulo nem igual a 0");
        }
        if(preco <= 0){
            throw new IllegalArgumentException("O preço não pode ser nulo nem igual a 0");
        }
        if (nome.isEmpty() || nome.equals(" ")){
            throw new IllegalArgumentException("O valor atribuído ao nome não pode ser aceito");
        }

        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Produto: " + nome + "\n Código identificador: " + codigo + "\n Preço: " + new DecimalFormat("0.000").format(preco);
    }
}
