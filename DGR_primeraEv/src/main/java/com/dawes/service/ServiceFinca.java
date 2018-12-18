package com.dawes.service;

import java.util.List;

import com.dawes.modelo.FincaVO;

public interface ServiceFinca {

	void save(FincaVO finca);

	List<FincaVO> findAll();

	void remove(FincaVO finca);

	FincaVO findByNombre(String nombre);

	FincaVO findById(int idfinca);

}