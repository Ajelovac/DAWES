package com.dawes.dao;

import java.util.List;

import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public interface CuentaDAO {
	
	int save(CuentaVO cuenta);
	int delete(CuentaVO cuenta);
	int update(CuentaVO cuenta);
	CuentaVO findByNumCuenta(String numCuenta);
	void deleteAll();
	List<MovimientoVO> movimientos3000();
}
