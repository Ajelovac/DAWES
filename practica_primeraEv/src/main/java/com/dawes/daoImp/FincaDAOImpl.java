package com.dawes.daoImp;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.FincaDAO;
import com.dawes.modelo.FincaVO;

public class FincaDAOImpl implements FincaDAO{
	
	EntityManager em;

	public FincaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void save(FincaVO finca) {
		// TODO Auto-generated method stub
		
	}

	public List<FincaVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(FincaVO finca) {
		// TODO Auto-generated method stub
		
	}

	public FincaVO findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public FincaVO findById(int idfinca) {
		// TODO Auto-generated method stub
		return null;
	}

}
