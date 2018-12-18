package com.dawes.daoImp;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.RecetaDAO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public class RecetaDAOImpl implements RecetaDAO{
	
	EntityManager em;

	public RecetaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void save(RecetaVO receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(RecetaVO receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RecetaVO receta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IngredienteVO> listall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
