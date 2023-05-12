package model.dao;

import java.util.List;

import model.beans.Categoria;
import model.beans.Produto;

public interface ProdutoDao {
	
	void insert(Produto obj);

	void update(ProdutoDao obj);

	void deleteByid(Integer id);

	Produto findById(Integer id);

	List<Produto> findAll();
	
	List<Produto> findByCategoria(Categoria Categoria);

	
}
