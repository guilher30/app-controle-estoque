package model.dao;

import java.util.List;

public interface ProdutoDao {
	
	void insert(ProdutoDao obj);

	void update(ProdutoDao obj);

	void deleteByid(Integer id);

	ProdutoDao findById(Integer id);

	List<ProdutoDao> findAll();
}
