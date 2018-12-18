package com.dawes.service;

import java.util.List;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public interface ServiceReceta {

	RecetaDAO getRecetaDAO();

	IngredienteDAO getIngredienteDAO();

	int hashCode();

	boolean equals(Object obj);

	String toString();

	int save(IngredienteVO ingr);

	List<RecetaVO> listIngrediente(IngredienteVO i);

	void remove(RecetaVO receta);

}