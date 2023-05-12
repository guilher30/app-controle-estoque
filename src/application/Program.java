package application;

import java.util.Date;

import controller.ProdutoController;
import db.DB;
import model.beans.Categoria;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;


public class Program {

	public static void main(String[] args) {
		DB db = new DB();
		DB.getConnection();
		db.estaConecatdo();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		ProdutoController pc = new ProdutoController();
//		pc.valFindById();
//		pc.findByCategoria();
		//pc.findAll();
		Categoria cat = new Categoria(1, null);
		Produto produto = new Produto(null, "Oleo", 30, 20, 100, new Date(), cat);
		produtoDao.insert(produto);
		System.out.println("Inserido com sucesso Novo id = " + produto.getId());
		
	}

}
