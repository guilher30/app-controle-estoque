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
import model.beans.Usuario;
import model.dao.UsuarioDao;

public class UsuarioDaoJDBC implements UsuarioDao{
	
	private Connection conn;

	public UsuarioDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByid(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario login(String email, String senha) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT usuario.* " + "FROM usuario  "
							+  "WHERE usuario.Email = ? and usuario.Senha = ?");

			st.setString(1, email);
			st.setString(2, senha);
			rs = st.executeQuery();
			Usuario obj = new Usuario();
			if (rs.next()) {
				obj.setNome(rs.getString("Nome"));
				obj.setEmail(rs.getString("Email"));
				obj.setSenha(rs.getString("Senha"));
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

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
