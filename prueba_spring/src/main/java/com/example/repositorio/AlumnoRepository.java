package com.example.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.AlumnoVO;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoVO, Integer>{

	public AlumnoVO findByNombre(String nombre);
	
}
