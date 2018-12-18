package com.dawes.daoImp;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.FincaDAO;
import com.dawes.modelo.FincaVO;

public class FincaDAOImpl implements FincaDAO {

	EntityManager em;

	public FincaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void save(FincaVO finca) {
		em.getTransaction().begin();
		em.persist(finca);
		em.getTransaction().commit();
	}

	@Override
	public List<FincaVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(FincaVO finca) {
		em.getTransaction().begin();
		em.remove(finca);
		em.getTransaction().commit();
	}

	@Override
	public FincaVO findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FincaVO findById(int idfinca) {
		// TODO Auto-generated method stub
		return null;
	}

}
