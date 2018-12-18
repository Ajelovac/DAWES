package com.dawes.daoImp;

import javax.persistence.EntityManager;

import com.dawes.dao.TratamientoDAO;
import com.dawes.modelo.TratamientoVO;

public class TratamientoDAOImpl implements TratamientoDAO {
	
	EntityManager em;

	public TratamientoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void remove(TratamientoVO tratamiento) {
		em.getTransaction().begin();
		em.remove(tratamiento);
		em.getTransaction().commit();
	}

	@Override
	public void save(TratamientoVO tratamiento) {
		em.getTransaction().begin();
		em.persist(tratamiento);
		em.getTransaction().commit();	
	}

	@Override
	public TratamientoVO findByProducto(String producto) {
		return null;
	}

	@Override
	public TratamientoVO findById(int idtratamiento) {
		return null;
	}

}
