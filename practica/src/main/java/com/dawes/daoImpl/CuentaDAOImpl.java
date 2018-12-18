package com.dawes.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.CuentaDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class CuentaDAOImpl implements CuentaDAO{
	
	EntityManager em;

	public CuentaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public int save(CuentaVO cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(CuentaVO cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CuentaVO cuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CuentaVO findByNumCuenta(String numCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MovimientoVO> movimientos3000() {
		// TODO Auto-generated method stub
		return null;
	}

}
