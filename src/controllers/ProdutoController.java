package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Fornecedor;
import entities.Produto;
import enums.TipoProduto;
import interfaces.ProdutoRepository;
import repositories.ProdutoRepositoryTxt;
import repositories.ProdutoRepositoryXml;

public class ProdutoController {

	/*
	 * / Metodo para realizar cadastro de um produto
	 */

	public void cadastrarProduto() {

		Scanner scanner = new Scanner(System.in);

		try {

			Produto produto = new Produto();

			produto.setId(UUID.randomUUID());
			produto.setFornecedor(new Fornecedor());

			System.out.println("\n*** CADASTRO DE PRODUTO ***\n");

			System.out.print("NOME DO PRODUTO...........................: ");
			produto.setNome(scanner.nextLine());

			System.out.print("PREÇO......................................:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.print("QUANTIDADE.................................:");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			System.out.print("INFORME (1) PERECIVEL OU (2) NÃO PERECÍVEL.:");
			Integer opcao = Integer.parseInt(scanner.nextLine());

			switch (opcao) {
			case 1:
				produto.setTipo(TipoProduto.PERECIVEL);
				break;
			case 2:
				produto.setTipo(TipoProduto.NAO_PERECIVEL);
				break;
			default: // nunhum dos anteriores
				throw new Exception("Opção inválida"); // função para jogar pro catch manualmente
			}

			System.out.print("NOME DO FORNECEDOR..........................:");
			produto.getFornecedor().setNome(scanner.nextLine());

			System.out.print("CNPJ DO FORNECEDOR..........................:");
			produto.getFornecedor().setCnpj(scanner.nextLine());

			System.out.print("Escolha O TIPO DE ARQUIVO (1)TXT ou (2) XML");
			Integer tipo = Integer.parseInt(scanner.nextLine());

			// Declarando o objeto da interface ProdutoRepository
			// este objeto será criado inicialmente vazio(null) Sem espaço de momoria

			ProdutoRepository produtoRepository = null;

			switch (tipo) {
			case 1:
				produtoRepository = new ProdutoRepositoryTxt();
				break;
			case 2:
				produtoRepository = new ProdutoRepositoryXml();
				break;
			default:
				throw new Exception("Tipo de arquivo inválido!");

			}

			// EXECUTANDO A EXPORTACAO DO ARQUIVO

			produtoRepository.exportarDados(produto);

		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PRODUTO!");
			System.out.println(e.getMessage());
		} finally { // Dando erro ou não, o scanner precisa ser fechado.
			scanner.close();
		}

	}
}