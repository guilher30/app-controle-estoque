package model.dao;

import java.util.List;

import model.beans.Produto;

public interface ProdutoDao {
	
	void insert(ProdutoDao obj);

	void update(ProdutoDao obj);

	void deleteByid(Integer id);

	Produto findById(Integer id);

	List<ProdutoDao> findAll();
}
