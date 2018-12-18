package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.AlumnoVO;
import com.example.repositorio.AlumnoRepository;

@Service
public class ServiceAlumnoImpl implements ServiceAlumno {

	@Autowired
	AlumnoRepository ar;

	@Override
	public AlumnoVO findByNombre(String nombre) {
		return ar.findByNombre(nombre);
	}

	@Override
	public <S extends AlumnoVO> S save(S entity) {
		return ar.save(entity);
	}

	@Override
	public Iterable<AlumnoVO> findAll() {
		return ar.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

	@Override
	public void delete(AlumnoVO entity) {
		ar.delete(entity);
	}

	@Override
	public AlumnoRepository getAr() {
		return ar;
	}

	@Override
	public void setAr(AlumnoRepository ar) {
		this.ar = ar;
	}
	
	
	
	
}
