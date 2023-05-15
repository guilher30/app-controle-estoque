package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.beans.Categoria;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.dao.impl.ProdutoDaoJDBC;
import view.ApresentacaoDeTela;

public class ProdutoController {

	public void valFindById() {
		ApresentacaoDeTela at = new ApresentacaoDeTela();

		try {

			Integer id = at.telaFindById();
			ProdutoDao produtoDao = DaoFactory.createProdutoDao();
			Produto produto = produtoDao.findById(id);
			if (produto == null) {
				at.mostrarMsg("Produto não encontrado");
			} else {
				at.mostrarMsg("Produto Encontrado: " + produto);
			}

		} catch (NumberFormatException e) {
			at.mostrarMsg("Formato Invalido. Digite Novamente");
			if (at.menuErro() == 0) {
				valFindById();
			}

		}
	}

	public void findByCategoria() {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		Categoria cat = new Categoria();

		try {

			int menu = at.telaFindByCategoria();

			if (menu == 0) {
				cat = new Categoria(1, null);
			} else if (menu == 1) {
				cat = new Categoria(2, null);
			} else if (menu == 2) {
				cat = new Categoria(3, null);
			} else if (menu > 2) {
				System.out.println("Categoria Invalida");
			}

			ProdutoDao produtoDao = DaoFactory.createProdutoDao();
			List<Produto> list = produtoDao.findByCategoria(cat);
			at.mostrarMsg("Produto Encontrados: " + list);

		} catch (NumberFormatException e) {
			at.mostrarMsg("Formato Invalido. Digite Novamente");
			if (at.menuErro() == 0) {
				valFindById();
			}

		}

	}

	public void findAll() {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		List<Produto> list = produtoDao.findAll();
		at.exibirMensagem(list);
	}

	public void update() {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();

		int id = at.telaUpdate("Digite o id do produto que deseja atualizar quantidade: ");
		Produto obj = produtoDao.findById(id);
		String resp =null;
		
			
		if (obj != null) {
			int qtd;
			int newQtd;

			resp = at.menuUpdate();
			if (resp.equalsIgnoreCase("retirar")) {
				qtd = at.telaUpdate("Digite o a quantidade a ser removido: ");
				newQtd = obj.getQtd() - qtd;
			} else {
				qtd = at.telaUpdate("Digite o a quantidade a ser adionada: ");
				newQtd = obj.getQtd() + qtd;
			}

			if(obj.validarUpdate(obj, resp, newQtd)) {
				produtoDao.update(newQtd, obj.getId());
			}
		} else {
			at.mostrarMsg("Produto não encontrado");
		}
		
	}
	public void deleteById() {
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		produtoDao.deleteByid(7);
		
		
	}

}
