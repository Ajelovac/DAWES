package com.dawes.serviceImpl;

import java.util.List;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.service.ServiceCuentas;
import com.dawes.util.MySqlDAOFactory;

public class ServiceCuentasImpl implements ServiceCuentas {
	
	CuentaDAOImpl tci;
	MySqlDAOFactory f;
	
	

	public ServiceCuentasImpl() {
		
		f = MySqlDAOFactory.getFactoria();
		tci = (CuentaDAOImpl)f.getCuentaDAO();
	}

	@Override
	public int save(CuentaVO cuentas) {
		
		return tci.save(cuentas);
	}

	@Override
	public void delete(CuentaVO cuenta) {
		
		tci.delete(cuenta);
	}

	@Override
	public int update(CuentaVO cuenta) {
		
		return tci.update(cuenta);
	}

	@Override
	public CuentaVO findByNumCuenta(String numCuenta) {
		
		return tci.findByNumCuenta(numCuenta);
	}

	
	@Override
	public void deleteAll() {
		tci.deleteAll();
		
	}

	@Override
	public List<CuentaVO> movimientos3000() {
		
		return tci.movimientos3000();
	}

}
