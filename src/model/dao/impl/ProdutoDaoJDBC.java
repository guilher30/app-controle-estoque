package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.beans.Categoria;
import model.beans.Produto;
import model.dao.ProdutoDao;
import view.ApresentacaoDeTela;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conn;

	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Produto obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO produto " + "(Nome, Qtd, QtdMin, QtdMAx, DataCad, CategoriaId) "
					+ "VALUES " + "(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getQtd());
			st.setInt(3, obj.getQtdMin());
			st.setInt(4, obj.getQtdMax());
			st.setDate(5, new java.sql.Date(obj.getDataCad().getTime()));
			st.setInt(6, obj.getCategoria().getId());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);

			} else {
				throw new DbException("Nenhuma linha foi alterada");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Integer newQtd, Integer id) {
		
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE produto " + "SET Qtd = ? WHERE Id = ?");
			
			st.setInt(1, newQtd);
			st.setInt(2, id);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByid(Integer id) {
		ApresentacaoDeTela at = new ApresentacaoDeTela();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM produto WHERE Id = ?" );
			st.setInt(1, id);
			int rowsAffected = st.executeUpdate();
			if(rowsAffected == 0) {
				at.mostrarMsg("Não há nenhum produto com esse ID");
			}
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Produto findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT produto.*,categoria.Nome as CatNome " + "FROM produto INNER JOIN categoria "
							+ "ON produto.CategoriaId = categoria.Id " + "WHERE produto.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Categoria cat = instanciarCategoria(rs);
				Produto obj = instaciarProduto(rs, cat);
				return obj;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
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
	public List<Produto> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT produto.*,categoria.Nome as CatNome "
					+ "FROM produto INNER JOIN categoria " + "ON produto.CategoriaId = categoria.Id " + "ORDER BY Id");

			rs = st.executeQuery();

			List<Produto> list = new ArrayList<>();
			Map<Integer, Categoria> map = new HashMap<>();

			while (rs.next()) {
				Categoria cat = map.get(rs.getInt("CategoriaId"));

				if (cat == null) {
					cat = instanciarCategoria(rs);
					map.put(rs.getInt("CategoriaId"), cat);
				}

				Produto obj = instaciarProduto(rs, cat);
				list.add(obj);

			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<Produto> findByCategoria(Categoria categoria) {

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT produto.*,categoria.Nome as CatNome " + "FROM produto INNER JOIN categoria "
							+ "ON produto.CategoriaId = categoria.Id " + "WHERE CategoriaId = ? " + "ORDER BY Nome");
			st.setInt(1, categoria.getId());
			rs = st.executeQuery();

			List<Produto> list = new ArrayList<>();
			Map<Integer, Categoria> map = new HashMap<>();

			while (rs.next()) {
				Categoria cat = map.get(rs.getInt("CategoriaId"));

				if (cat == null) {
					cat = instanciarCategoria(rs);
					map.put(rs.getInt("CategoriaId"), cat);
				}

				Produto obj = instaciarProduto(rs, cat);
				list.add(obj);

			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}
