package repositories;

/*
 * Implementação do repositório de produtos
 * para exportar para TXT
 */

import java.io.PrintWriter;

import entities.Produto;
import interfaces.ProdutoRepository;

public class ProdutoRepositoryTxt implements ProdutoRepository{ 


	@Override
	public void exportarDados(Produto produto) {
	
		try {
			
			PrintWriter printwriter = new PrintWriter("c:\\temp\\Produto_" + produto.getId() + ".txt");
			
			printwriter.write("\nID DO PRODUTO.............: " + produto.getId());			
			printwriter.write("\nNOME......................: " + produto.getNome());
			printwriter.write("\nPRECO.....................: " + produto.getPreco());
			printwriter.write("\nQUANTIDADE................: " + produto.getQuantidade());
			printwriter.write("\nTIPO......................: " + produto.getTipo());
			printwriter.write("\nFORNECEDOR................: " + produto.getFornecedor().getNome());
			printwriter.write("\nCNPJ......................: " + produto.getFornecedor().getCnpj());
			
			printwriter.flush();
			printwriter.close();
		
			System.out.println("\nARQUIVO TXT GRAVADO COM SUCESSO!");
				
		} catch(Exception e) {
			System.out.println("\nFALHA AO EXPORTAR PARA TXT:");
			System.out.println(e.getMessage());
		}

}

		
	}

