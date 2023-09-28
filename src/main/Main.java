package main;

import controllers.ProdutoController;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 * Criando um objeto da classe controller:
		 */
		ProdutoController produtocontroller = new ProdutoController();
		
		/*
		 * Método para cadastrar o produto: 
		 */
		produtocontroller.cadastrarProduto();

	}

}
