package lista_produtos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastrarProduto extends NovoProduto {
	
	String textoPadrao = "CADASTRO DE PRODUTOS";
	JOptionPane jop = new JOptionPane();
	
	@Override
	public void cadastrarProduto() {
		boolean cadastrar = true;
		ListaDeProdutos<Object> listaDeProdutos = new ListaDeProdutos<>();
		ArrayList<String> cadastrados = new ArrayList<>();
		
		while(cadastrar) {
			NovoProduto produto = new NovoProduto();
			
			produto.setNome(jop.showInputDialog(null, "Nome do produto:", textoPadrao, jop.QUESTION_MESSAGE));
			produto.setMarca(jop.showInputDialog(null, "Marca do produto:", textoPadrao, jop.QUESTION_MESSAGE));
			String jopPreco = jop.showInputDialog(null, "Preço do produto:", textoPadrao, jop.QUESTION_MESSAGE);
			produto.setPreco(Double.parseDouble(jopPreco.replace(",", ".")));
			String jopQuant = jop.showInputDialog(null, "Quantidade do produto:", textoPadrao, jop.QUESTION_MESSAGE);
			produto.setQuantidade(Integer.parseInt(jopQuant));
			
			listaDeProdutos.adicionarProduto(produto);
			jop.showMessageDialog(null, "Cadastro efetuado com sucesso!\n" + produto.cadastroEfetuado(), textoPadrao, jop.INFORMATION_MESSAGE);
			
			cadastrados.add(produto.toString() + "\n");
			jop.showMessageDialog(null, cadastrados, textoPadrao, jop.DEFAULT_OPTION);
		
			String continuar = jop.showInputDialog(null, "Deseja cadastrar mais?\n'S' para sim / Qualquer para encerrar", textoPadrao, jop.QUESTION_MESSAGE);		
			if (continuar.equals("S") || continuar.equals("s")) {
				cadastrar = true;
			} else {
				cadastrar = false;
				jop.showMessageDialog(null, "Cadastramento encerrado.", textoPadrao, jop.DEFAULT_OPTION);
			}
		}
		listaDeProdutos.mostrarLista();
	}
}
