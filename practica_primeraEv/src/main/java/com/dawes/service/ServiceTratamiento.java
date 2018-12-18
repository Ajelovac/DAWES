package com.dawes.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.modelo.TratamientoVO;

public interface ServiceTratamiento {

	EntityManagerFactory getEmf();

	EntityManager getEm();

	void remove(TratamientoVO tratamiento);

	void save(TratamientoVO tratamiento);

	TratamientoVO findByProducto(String producto);

	TratamientoVO findById(int idtratamiento);

}