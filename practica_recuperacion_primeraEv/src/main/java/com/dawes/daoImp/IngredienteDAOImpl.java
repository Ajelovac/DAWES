package com.dawes.daoImp;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.IngredienteDAO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public class IngredienteDAOImpl implements IngredienteDAO{
	
	EntityManager em;

	public IngredienteDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void save(IngredienteVO ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(IngredienteVO ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(IngredienteVO ingrediente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecetaVO> listall() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
