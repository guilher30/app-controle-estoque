package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.beans.Categoria;
import model.beans.Produto;
import model.dao.ProdutoDao;

public class ProdutoDaoJDBC implements ProdutoDao{
	
	private Connection conn;
	
	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ProdutoDao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ProdutoDao obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT produto.*,categoria.Nome as CatNome "
					+ "FROM produto INNER JOIN categoria "
					+ "ON produto.CategoriaId = categoria.Id "
					+ "WHERE produto.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Categoria cat = instanciarCategoria(rs);
				Produto obj = instaciarProduto(rs, cat);
				return obj;
				
			}
			return null;
		    }catch(SQLException e) {
		    	throw new DbException(e.getMessage());
		    }finally {
		    	DB.closeStatement(st);
		    	DB.closeResultSet(rs);
		    }
		
	}

	private Produto instaciarProduto(ResultSet rs, Categoria cat) throws SQLException {
		
		 Produto obj = new Produto();
			obj.setId(rs.getInt("Id"));
			obj.setNome(rs.getString("Nome"));
			obj.setQtd(rs.getInt("Qtd"));
			obj.setQtdMin(rs.getInt("QtdMin"));
			obj.setQtdMax(rs.getInt("QtdMax"));
			obj.setDataCad(rs.getDate("DataCad"));
			obj.setCategoria(cat);
			return obj;
	}

	private Categoria instanciarCategoria(ResultSet rs) throws SQLException {
		Categoria cat = new Categoria();
		cat.setId(rs.getInt("CategoriaId"));
		cat.setNome(rs.getString("CatNome"));
		return cat;
	}

	@Override
	public List<ProdutoDao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
