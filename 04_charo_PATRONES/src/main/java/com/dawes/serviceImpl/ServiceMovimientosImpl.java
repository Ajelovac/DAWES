package com.dawes.serviceImpl;

import java.util.List;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.daoImpl.MovimientoDAOImpl;
import com.dawes.modelo.MovimientoVO;
import com.dawes.service.ServiceMovimientos;
import com.dawes.util.MySqlDAOFactory;

public class ServiceMovimientosImpl implements ServiceMovimientos {
	
	MovimientoDAOImpl tdi;
	MySqlDAOFactory f;
	
	
	public ServiceMovimientosImpl() {
		
		f = MySqlDAOFactory.getFactoria();
		tdi = (MovimientoDAOImpl)f.getMovimientoDAO();
		
	}
	

	@Override
	public int save(MovimientoVO movimiento) {
		return tdi.save(movimiento);
	}

	@Override
	public void delete(MovimientoVO movimiento) {
		tdi.delete(movimiento);
	}

	@Override
	public int update(MovimientoVO movimiento) {
		return tdi.update(movimiento);
	}

	@Override
	public MovimientoVO findByIdMovimiento(int idMovimiento) {
		return tdi.findByIdMovimiento(idMovimiento);
	}


	@Override
	public List<MovimientoVO> findByIdCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return tdi.findByIdCuenta(idCuenta);
	}

	
}
