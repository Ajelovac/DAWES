package com.dawes.serviceImp;

import java.util.List;

import com.dawes.daoImp.FincaDAOImpl;
import com.dawes.modelo.FincaVO;
import com.dawes.service.ServiceFinca;
import com.dawes.util.DAOFactory;

public class ServiceFincaImpl implements ServiceFinca {
	
	private FincaDAOImpl daoFinca;
	private DAOFactory f;
	
	public ServiceFincaImpl() {
		f = DAOFactory.getF();
		daoFinca = (FincaDAOImpl) f.getFincaDAO();
	}

	@Override
	public void save(FincaVO finca) {
		daoFinca.save(finca);
	}
	
	@Override
	public List<FincaVO> findAll() {
		return daoFinca.findAll();
	}

	@Override
	public void remove(FincaVO finca) {
		daoFinca.remove(finca);
	}

	@Override
	public FincaVO findByNombre(String nombre) {
		return daoFinca.findByNombre(nombre);
	}
	
	@Override
	public FincaVO findById(int idfinca) {
		return daoFinca.findById(idfinca);
	}
	
	
}
