package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;



public interface RecetaDAO {

	void save(RecetaVO receta);
	void remove(RecetaVO receta);
	void update(RecetaVO receta);
	List<IngredienteVO> listall();
     
}