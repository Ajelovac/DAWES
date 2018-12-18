package com.dawes.serviceImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.daoImp.FincaDAOImpl;
import com.dawes.modelo.FincaVO;
import com.dawes.service.ServiceFinca;
import com.dawes.util.DAOFactory;

public class ServiceFincaImpl implements ServiceFinca {

	FincaDAOImpl fdi;
	DAOFactory f;
	
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#save(com.dawes.modelo.FincaVO)
	 */
	@Override
	public void save(FincaVO finca) {
		fdi.save(finca);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findAll()
	 */
	@Override
	public List<FincaVO> findAll() {
		return fdi.findAll();
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#remove(com.dawes.modelo.FincaVO)
	 */
	@Override
	public void remove(FincaVO finca) {
		fdi.remove(finca);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findByNombre(java.lang.String)
	 */
	@Override
	public FincaVO findByNombre(String nombre) {
		return fdi.findByNombre(nombre);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findById(int)
	 */
	@Override
	public FincaVO findById(int idfinca) {
		return fdi.findById(idfinca);
	}
	public EntityManagerFactory getEmf() {
		return f.getEmf();
	}
	public EntityManager getEm() {
		return f.getEm();
	}
	
	
}
