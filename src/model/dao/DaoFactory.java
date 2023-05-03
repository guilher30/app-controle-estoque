package model.dao;

import model.dao.impl.ProdutoDaoJDBC;

public class DaoFactory {
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC();
	}
}
