package com.dawes.serviceImp;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.daoImp.IngredienteDAOImpl;
import com.dawes.service.ServiceIngrediente;
import com.dawes.util.DAOFactory;

public class ServiceIngredienteImpl implements ServiceIngrediente {

	DAOFactory f;
	IngredienteDAOImpl idi;
	
	public ServiceIngredienteImpl() {
		f = DAOFactory.getF();
		idi = (IngredienteDAOImpl) f.getIngredienteDAO();
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
	public int hashCode() {
		return f.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		return f.equals(obj);
	}
	@Override
	public String toString() {
		return f.toString();
	}
	
	
	
}
