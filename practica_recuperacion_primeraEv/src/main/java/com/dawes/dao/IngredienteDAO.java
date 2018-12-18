package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public interface IngredienteDAO {

	void save(IngredienteVO ingrediente);
	void remove(IngredienteVO ingrediente);
	void update(IngredienteVO ingrediente);
	List<RecetaVO> listall();
	
	
}
