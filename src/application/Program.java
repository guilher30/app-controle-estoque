package application;

import db.DB;
import view.ApresentacaoDeTela;


public class Program {

	public static void main(String[] args) {
		DB db = new DB();
		DB.getConnection();
		db.estaConecatdo();
		
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		at.telaLogin();
		
		
	}

}
