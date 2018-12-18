package com.dawes.service;

import java.util.List;

import com.dawes.modelo.MovimientoVO;

public interface ServiceMovimientos {
	
	int save(MovimientoVO movimients);
	void delete(MovimientoVO movimients);
	int update(MovimientoVO movimiento);
	MovimientoVO findByIdMovimiento(int idMovimiento);
	List<MovimientoVO> findByIdCuenta(int idCuenta);

}