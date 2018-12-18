package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.CursoVO;
import com.example.repositorio.CursoRepository;

@Service
public class ServiceCursoImpl implements ServiceCurso {
	
	@Autowired
	CursoRepository cr;

	@Override
	public <S extends CursoVO> S save(S entity) {
		return cr.save(entity);
	}

	@Override
	public Optional<CursoVO> findById(Integer id) {
		return cr.findById(id);
	}

	@Override
	public Iterable<CursoVO> findAll() {
		return cr.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public void delete(CursoVO entity) {
		cr.delete(entity);
	}

	@Override
	public CursoRepository getCr() {
		return cr;
	}

	@Override
	public void setCr(CursoRepository cr) {
		this.cr = cr;
	}
	
	
}
