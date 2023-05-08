package application;

import controller.ProdutoController;
import db.DB;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;


public class Program {

	public static void main(String[] args) {
		DB db = new DB();
		DB.getConnection();
		db.estaConecatdo();
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		ProdutoController pc = new ProdutoController();
		pc.valFindById();
		pc.findByCategoria();
		
		
		
	}

}
