package lista_produtos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NovoProduto {

	private String nome, marca;
	private double preco;
	private int quantidade;
	
	public NovoProduto() {}

	public String getNome() {
		return nome;
	}
	
	public void cadastrarProduto() {
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
	
	@Override
	public String toString() {
		return "nome: " + nome + ", marca: " + marca + ", preço: " + String.format("%.2f", preco) + ", quantidade: " + quantidade + " un.";
	}
	
	public String cadastroEfetuado() {
		return getNome() + " " + getMarca() + "\n"
				+ "R$ " + String.format("%.2f", getPreco())+ "\n" + getQuantidade() + " unidades.";
	}
}
