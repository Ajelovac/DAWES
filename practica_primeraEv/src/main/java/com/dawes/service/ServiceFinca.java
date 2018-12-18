package com.dawes.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.modelo.FincaVO;

public interface ServiceFinca {

	EntityManagerFactory getEmf();

	EntityManager getEm();

	void save(FincaVO finca);

	List<FincaVO> findAll();

	void remove(FincaVO finca);

	FincaVO findByNombre(String nombre);

	FincaVO findById(int idfinca);

}