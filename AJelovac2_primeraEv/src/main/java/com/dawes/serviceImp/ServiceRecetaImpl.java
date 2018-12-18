package com.dawes.serviceImp;

import java.util.List;

import com.dawes.dao.IngredienteDAO;
import com.dawes.dao.RecetaDAO;
import com.dawes.daoImp.RecetaDAOImpl;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.service.ServiceReceta;
import com.dawes.util.DAOFactory;

public class ServiceRecetaImpl implements ServiceReceta {

	DAOFactory f;
	RecetaDAOImpl rdi;
	
	public ServiceRecetaImpl() {
		f = DAOFactory.getF();
		rdi = (RecetaDAOImpl) f.getRecetaDAO();
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
	@Override
	public int save(IngredienteVO ingr) {
		return rdi.save(ingr);
	}
	@Override
	public List<RecetaVO> listIngrediente(IngredienteVO i) {
		return rdi.listIngrediente(i);
	}
	@Override
	public void remove(RecetaVO receta) {
		rdi.remove(receta);
	}
	
	
	
	
}
