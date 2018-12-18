package com.dawes.service;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;

public interface ServiceIngrediente {

	RecetaDAO getRecetaDAO();

	IngredienteDAO getIngredienteDAO();

	int hashCode();

	boolean equals(Object obj);

	String toString();

}