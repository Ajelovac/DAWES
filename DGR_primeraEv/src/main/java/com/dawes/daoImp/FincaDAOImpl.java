package com.dawes.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dawes.dao.FincaDAO;
import com.dawes.modelo.FincaVO;

public class FincaDAOImpl implements FincaDAO {

	private EntityManager em;
	
	public FincaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void save(FincaVO finca) {
		
		try {
			em.getTransaction().begin();
			
			em.persist(finca);
			
			em.getTransaction().commit();
			
			System.out.println("Se ha insertado la finca");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("Se ha producido un error insertando la finca " + e.getMessage());
		}
		
	}

	@Override
	public List<FincaVO> findAll() {
		
		TypedQuery<FincaVO> query = em.createQuery("select f from FincaVO f", FincaVO.class);
		
		return query.getResultList();
	}

	@Override
	public void remove(FincaVO finca) {
		
		try {
			em.getTransaction().begin();
			
			em.remove(finca);
			
			em.getTransaction().commit();
			
			System.out.println("Se ha borrado la finca");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("Se ha producido un error borrando la finca " + e.getMessage());
		}
		
	}

	@Override
	public FincaVO findByNombre(String nombre) {
		
		FincaVO finca;
		
		TypedQuery<FincaVO> query = em.createQuery("select f from FincaVO f where f.nombre =: nombre", FincaVO.class);
		query.setParameter("nombre", nombre);
		
		finca = query.getSingleResult();
		
		return finca;
		
	}

	@Override
	public FincaVO findById(int idfinca) {
		return em.find(FincaVO.class, idfinca);
	}


}
