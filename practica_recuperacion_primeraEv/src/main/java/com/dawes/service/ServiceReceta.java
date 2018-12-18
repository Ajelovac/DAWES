package com.dawes.service;

import java.util.List;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public interface ServiceReceta {

	RecetaDAO getRecetaDAO();

	IngredienteDAO getIngredienteDAO();

	void save(RecetaVO receta);

	void remove(RecetaVO receta);

	void update(RecetaVO receta);

	List<IngredienteVO> listall();

}