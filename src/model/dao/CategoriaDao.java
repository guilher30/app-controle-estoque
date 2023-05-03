package model.dao;

import java.util.List;

import model.beans.Categoria;

public interface CategoriaDao {
	 
	void insert(Categoria obj);
	
	void update(Categoria obj);
	
	void deleteByid(Integer id);
	
	Categoria findById(Integer id);
	
	List<Categoria> findAll();
	
	
}
