package com.dawes.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import com.dawes.dao.MovimientoDAO;
import com.dawes.modelo.MovimientoVO;

public class MovimientoDAOImpl implements MovimientoDAO {

	EntityManager em;
	
	
	
	public MovimientoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public int save(MovimientoVO movimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(MovimientoVO movimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MovimientoVO movimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MovimientoVO findByIdMovimiento(int idMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovimientoVO> findByIdCuenta(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

}
