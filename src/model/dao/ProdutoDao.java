package model.dao;

import java.util.List;

import model.beans.Categoria;
import model.beans.Produto;

public interface ProdutoDao {
	
	void insert(Produto obj);

	void update(Integer Qtd,Integer id);

	void deleteByid(Integer id);

	Produto findById(Integer id);

	List<Produto> findAll();
	
	List<Produto> findByCategoria(Categoria Categoria);

	
}
