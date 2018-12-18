package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;



public interface RecetaDAO {
    public List<RecetaVO> listIngrediente(IngredienteVO i);
	void remove(RecetaVO receta);
	int save(IngredienteVO ingr);
}
