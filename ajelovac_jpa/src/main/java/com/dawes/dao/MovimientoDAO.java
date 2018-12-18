package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public interface MovimientoDAO {
	
	int save(MovimientoVO movimiento);
	int delete(MovimientoVO movimiento);
	int update(MovimientoVO movimiento);
	List<MovimientoVO> findByIdCuenta(CuentaVO cuenta);
	
	

}
