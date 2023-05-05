package application;

import db.DB;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;


public class Program {

	public static void main(String[] args) {
		DB db = new DB();
		DB.getConnection();
		db.estaConecatdo();
		
		
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		Produto produto = produtoDao.findById(3);
		
		System.out.println(produto);
		
		
	}

}
