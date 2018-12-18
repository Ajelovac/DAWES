package com.example.services;

import com.example.modelo.AlumnoVO;
import com.example.repositorio.AlumnoRepository;

public interface ServiceAlumno {

	AlumnoVO findByNombre(String nombre);

	<S extends AlumnoVO> S save(S entity);

	Iterable<AlumnoVO> findAll();

	void deleteById(Integer id);

	void delete(AlumnoVO entity);

	AlumnoRepository getAr();

	void setAr(AlumnoRepository ar);

}