package com.dawes.serviceImp;

import java.util.List;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.daoImp.IngredienteDAOImpl;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.service.ServiceIngrediente;
import com.dawes.util.DAOFactory;

public class ServiceIngredienteImpl implements ServiceIngrediente {
	
	DAOFactory f;
	IngredienteDAOImpl idi;
	
	public ServiceIngredienteImpl() {
		f=DAOFactory.getF();
		idi=(IngredienteDAOImpl) f.getIngredienteDAO();
	}

	@Override
	public RecetaDAO getRecetaDAO() {
		return f.getRecetaDAO();
	}

	@Override
	public IngredienteDAO getIngredienteDAO() {
		return f.getIngredienteDAO();
	}

	@Override
	public void save(IngredienteVO ingrediente) {
		idi.save(ingrediente);
	}

	@Override
	public void remove(IngredienteVO ingrediente) {
		idi.remove(ingrediente);
	}

	@Override
	public void update(IngredienteVO ingrediente) {
		idi.update(ingrediente);
	}

	@Override
	public List<RecetaVO> listall() {
		return idi.listall();
	}
	
	

}
