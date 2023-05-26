package model.dao;

import java.util.List;

import model.beans.Usuario;

public interface UsuarioDao {
	void insert(Usuario obj);

	void update(Usuario obj);

	void deleteByid(Integer id);

	Usuario findById(Integer id);

	List<Usuario> findAll();

	Usuario login (String email, String senha);
}
