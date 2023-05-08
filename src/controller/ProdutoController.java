package controller;

import java.util.List;

import model.beans.Categoria;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
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
			} else if(menu > 2) {
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
}
