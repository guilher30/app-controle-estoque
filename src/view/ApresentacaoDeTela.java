package view;

import javax.swing.JOptionPane;

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

		opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new Object[] { "Tentar novamente", "Voltar ao menu" }, "default");

		return opcao;
	}
}
