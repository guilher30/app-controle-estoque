package controller;

import java.util.List;

import model.beans.Categoria;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import view.ApresentacaoDeTela;

public class ProdutoController {

	public void findById(Integer id) {
		ApresentacaoDeTela at = new ApresentacaoDeTela();

		try {

			
			ProdutoDao produtoDao = DaoFactory.createProdutoDao();
			Produto produto = produtoDao.findById(id);
			if (produto == null) {
				at.mostrarMsg("Produto não encontrado");
			} else {
				at.mostrarMsg("Produto Encontrado: " + produto);
			}

		} catch (NumberFormatException e) {
			at.mostrarMsg("Formato Invalido. Digite Novamente");
			
		}
	}

	public void findByCategoria(Categoria cat) {
		StringBuilder sb = new StringBuilder();
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		
		try {

			if(cat.getNome().equalsIgnoreCase("Alimento"))
				cat.setId(1);
				else if(cat.getNome().equalsIgnoreCase("Limpeza")){
					cat.setId(2);
				}
				else if(cat.getNome().equalsIgnoreCase("Bebida")) {
					cat.setId(3);
				}

			ProdutoDao produtoDao = DaoFactory.createProdutoDao();
			List<Produto> list = produtoDao.findByCategoria(cat);
			at.mostrarMsg("Produto Encontrados: " + list);

		} catch (NumberFormatException e) {
			at.mostrarMsg("Formato Invalido. Digite Novamente");
			if (at.menuErro() == 0) {
				findById(cat.getId());
			}

		}

	}

	public String findAll() {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		StringBuilder sb = new StringBuilder();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		List<Produto> list = produtoDao.findAll();
		for(Produto p : list) {
			sb.append(p.toString());
		}
		return sb.toString();
	}

	public void update(Integer id, Integer qtd, String operacao) {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		
		Produto obj = produtoDao.findById(id);
		
		
			
		if (obj != null) {
		
			int newQtd;

			
			if (operacao.equalsIgnoreCase("Remover")) {
				
				newQtd = obj.getQtd() - qtd;
			} else {
				
				newQtd = obj.getQtd() + qtd;
			}

			if(obj.validarUpdate(obj, operacao, newQtd)) {
				produtoDao.update(newQtd, obj.getId());
			}
		} else {
			at.mostrarMsg("Produto não encontrado");
		}
		
	}
	public void deleteById(Integer id) {
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		produtoDao.deleteByid(id);
		
		
	}
	public void insert(Produto obj) {
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		produtoDao.insert(obj);
	}
	

}
