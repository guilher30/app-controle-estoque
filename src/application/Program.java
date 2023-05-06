package application;

import controller.ProdutoController;
import db.DB;
import model.beans.Produto;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;


public class Program {

	public static void main(String[] args) {
		DB db = new DB();
		DB.getConnection();
		db.estaConecatdo();
		
		
		ProdutoController pc = new ProdutoController();
		pc.valFindById();
		
	}

}
