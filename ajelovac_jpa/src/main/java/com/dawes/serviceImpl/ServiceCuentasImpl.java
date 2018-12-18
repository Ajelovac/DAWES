package com.dawes.serviceImpl;

import java.util.List;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.service.ServiceCuentas;
import com.dawes.util.DAOFactory;

public class ServiceCuentasImpl implements ServiceCuentas {
	
	CuentaDAOImpl tci;
	DAOFactory f;
	
	

	public ServiceCuentasImpl() {
		
		f = DAOFactory.getFactoria();
		tci = (CuentaDAOImpl)f.getCuentaDAO();
	}

	public int save(CuentaVO cuentas) {
		
		return tci.save(cuentas);
	}

	public int delete(CuentaVO cuenta) {
		
		tci.delete(cuenta);
		return 0;
	}

	public int update(CuentaVO cuenta) {
		
		return tci.update(cuenta);
	}

	public CuentaVO encontrarNumCuenta(String numCuenta) {
		
		return tci.encontrarNumCuenta(numCuenta);
	}

	
	public List<CuentaVO> findAll() {
		
		return tci.findAll();
	}



}
