package com.dawes.service;

import java.util.List;

import com.dawes.modelo.CuentaVO;

public interface ServiceCuentas {
	
	int save(CuentaVO cuenta);
	void delete(CuentaVO cuenta);
	int update(CuentaVO cuenta);
	CuentaVO findByNumCuenta(String numCuenta);
	void deleteAll();
	List<CuentaVO> movimientos3000();
}
