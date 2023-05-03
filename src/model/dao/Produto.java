package model.dao;

import java.util.List;

public interface Produto {
	void insert(Produto obj);

	void update(Produto obj);

	void deleteByid(Integer id);

	Produto findById(Integer id);

	List<Produto> findAll();
}
