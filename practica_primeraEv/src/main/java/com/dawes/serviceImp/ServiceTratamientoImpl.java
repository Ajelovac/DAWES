package com.dawes.serviceImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.daoImp.TratamientoDAOImpl;
import com.dawes.modelo.TratamientoVO;
import com.dawes.service.ServiceTratamiento;
import com.dawes.util.DAOFactory;

public class ServiceTratamientoImpl implements ServiceTratamiento {

	DAOFactory f;
	TratamientoDAOImpl tdi;
	public EntityManagerFactory getEmf() {
		return f.getEmf();
	}
	public EntityManager getEm() {
		return f.getEm();
	}
	public void remove(TratamientoVO tratamiento) {
		tdi.remove(tratamiento);
	}
	public void save(TratamientoVO tratamiento) {
		tdi.save(tratamiento);
	}
	public TratamientoVO findByProducto(String producto) {
		return tdi.findByProducto(producto);
	}
	public TratamientoVO findById(int idtratamiento) {
		return tdi.findById(idtratamiento);
	}
	
	
}
