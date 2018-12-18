package com.dawes.serviceImpl;

import java.util.List;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.daoImpl.MovimientoDAOImpl;
import com.dawes.modelo.MovimientoVO;
import com.dawes.service.ServiceMovimientos;
import com.dawes.util.DAOFactory;

public class ServiceMovimientosImpl implements ServiceMovimientos {
	
	MovimientoDAOImpl tdi;
	DAOFactory f;
	
	
	public ServiceMovimientosImpl() {
		
		f = DAOFactory.getFactoria();
		tdi = (MovimientoDAOImpl)f.getMovimientoDAO();
		
	}
	

	public int save(MovimientoVO movimiento) {
		return tdi.save(movimiento);
	}

	public void delete(MovimientoVO movimiento) {
		tdi.delete(movimiento);
	}

	public int update(MovimientoVO movimiento) {
		return tdi.update(movimiento);
	}


	public List<MovimientoVO> findByIdCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
