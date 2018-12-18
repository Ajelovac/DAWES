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

	public void remove(TratamientoVO tratamiento) {
		// TODO Auto-generated method stub
		
	}

	public void save(TratamientoVO tratamiento) {
		// TODO Auto-generated method stub
		
	}

	public TratamientoVO findByProducto(String producto) {
		// TODO Auto-generated method stub
		return null;
	}

	public TratamientoVO findById(int idtratamiento) {
		// TODO Auto-generated method stub
		return null;
	}

}
