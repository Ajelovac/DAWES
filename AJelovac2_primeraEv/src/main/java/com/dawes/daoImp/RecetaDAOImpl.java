package com.dawes.daoImp;

import java.util.List;


import javax.persistence.EntityManager;

import com.dawes.dao.RecetaDAO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;

public class RecetaDAOImpl implements RecetaDAO  {

	EntityManager em;

	public RecetaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public int save(IngredienteVO ingr) {
		try {
			em.getTransaction().begin();
			
			em.merge(ingr);
			
			em.getTransaction().commit();
			
			return 1;
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
		} return 0;
	}

	@Override
	public List<RecetaVO> listIngrediente(IngredienteVO i) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void remove(RecetaVO receta) {
		try {
			em.getTransaction().begin();
			
			em.remove(receta);
			
			em.getTransaction().commit();
			
			System.out.println("Receta Borrada");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("Error al eliminar" + e.getMessage());
		}		
	}

	
	
	
}
