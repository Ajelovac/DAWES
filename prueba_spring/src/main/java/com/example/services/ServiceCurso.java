package com.example.services;

import java.util.Optional;

import com.example.modelo.CursoVO;
import com.example.repositorio.CursoRepository;

public interface ServiceCurso {

	<S extends CursoVO> S save(S entity);

	Optional<CursoVO> findById(Integer id);

	Iterable<CursoVO> findAll();

	void deleteById(Integer id);

	void delete(CursoVO entity);

	CursoRepository getCr();

	void setCr(CursoRepository cr);

}