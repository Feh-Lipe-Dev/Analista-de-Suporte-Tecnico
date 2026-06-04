package lista_produtos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaDeProdutos<T> {

	private List<T> produtosCadastrados;
	
	public ListaDeProdutos() {
		this.produtosCadastrados = new ArrayList<>();
	}
	
	public void adicionarProduto(T produto) {
		produtosCadastrados.add(produto);
	}
	
	public void mostrarLista() {
			for (T produtoDaLista : produtosCadastrados) {
				//JOptionPane.showMessageDialog(null, produtoDaLista, "LISTA DE PRODUTOS", JOptionPane.DEFAULT_OPTION);
				System.out.println("[" + produtoDaLista + "]");
			}
	}
	
	public List<T> getProdutosCadastrados() {
		return produtosCadastrados;
	}
	

	public void setProdutosCadastrados(List<T> produtosCadastrados) {
		this.produtosCadastrados = produtosCadastrados;
	}
}
