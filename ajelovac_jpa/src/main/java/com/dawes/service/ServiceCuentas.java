package com.dawes.service;

import java.util.List;

import com.dawes.modelo.CuentaVO;

public interface ServiceCuentas {
	
	int save(CuentaVO cuenta);
	int delete(CuentaVO cuenta);
	int update(CuentaVO cuenta);
	CuentaVO encontrarNumCuenta(String numCuenta);
	List<CuentaVO> findAll();
}
