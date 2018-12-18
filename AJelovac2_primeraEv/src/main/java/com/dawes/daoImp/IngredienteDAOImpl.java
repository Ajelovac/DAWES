package com.dawes.daoImp;

import javax.persistence.EntityManager;

import com.dawes.dao.IngredienteDAO;

public class IngredienteDAOImpl implements IngredienteDAO{

	EntityManager em;

	public IngredienteDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	
}
