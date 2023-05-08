package view;

import javax.swing.JOptionPane;

import controller.ProdutoController;

public class ApresentacaoDeTela {

	public Integer telaFindById() {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que deseja buscar"));
		return id;
	}

	public void mostrarMsg(String msg) {
		JOptionPane.showMessageDialog(null, msg);

	}

	public int menuErro() {

		int opcao = 0;

		opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o:", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Tentar novamente", "Voltar ao menu" }, "default");

		return opcao;
	}

	public int telaFindByCategoria() {
		int opcao = 0;

		while (opcao != 3) {

			String[] opcoes = { "Alimento", "Limpeza", "Bebida", "Voltar" };

			opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o:", "Menu Busca Por Categoria",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

			switch (opcao) {
			case 0:
				return opcao;
			case 1:
				return opcao;
			case 2:
				return opcao;
			case 3:
				return opcao;
			}
		}
		return opcao;
	}

//	public int menuPrincipal() {
//		int opcao = 0;
//
//		while (opcao <= 2) {
//
//			String[] opcoes = { "Cadastro/Exclus�o de Produtos", "Atualizar Produtos", "Realizar Busca",
//					"Encerrar Programa" };
//
//			opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o:", "Menu", JOptionPane.DEFAULT_OPTION,
//					JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//
//			switch (opcao) {
//			case 0:
//				// C�digo para cadastro/exclus�o de produtos
//				return opcao;
//			case 1:
//				// C�digo para atualizar produtos
//				return opcao;
//			
//			case 2:
//				// C�digo para realizar busca
//				return opcao;
//			
//			case 3:
//				// Encerra o programa
//				JOptionPane.showMessageDialog(null, "Encerrando o programa...");
//				return opcao;
//			}
//		}
//		return opcao;
//
//	}

//	public void menuBuscar() {
//		int opcao = 0;
//		ProdutoController pc = new ProdutoController();
//		while (opcao <= 1) {
//
//			String[] opcoes = { "Buscar por Id", "Buscar por categoria", "Voltar ao Menu Principal" };
//
//			opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o:", "Menu de Busca",
//					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//
//			switch (opcao) {
//			case 0:
//				pc.valFindById();
//				break;
//			case 1:
//				pc.findByCategoria();
//				break;
//			case 2:
//				menuPrincipal();
//			}
//		}
//
//	}
}
