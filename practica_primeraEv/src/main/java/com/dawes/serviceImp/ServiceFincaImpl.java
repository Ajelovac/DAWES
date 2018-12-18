package com.dawes.serviceImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.daoImp.FincaDAOImpl;
import com.dawes.modelo.FincaVO;
import com.dawes.service.ServiceFinca;
import com.dawes.util.DAOFactory;

public class ServiceFincaImpl implements ServiceFinca {
	
	DAOFactory f;
	FincaDAOImpl fdi;
	
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#getEmf()
	 */
	public EntityManagerFactory getEmf() {
		return f.getEmf();
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#getEm()
	 */
	public EntityManager getEm() {
		return f.getEm();
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#save(com.dawes.modelo.FincaVO)
	 */
	public void save(FincaVO finca) {
		fdi.save(finca);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findAll()
	 */
	public List<FincaVO> findAll() {
		return fdi.findAll();
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#remove(com.dawes.modelo.FincaVO)
	 */
	public void remove(FincaVO finca) {
		fdi.remove(finca);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findByNombre(java.lang.String)
	 */
	public FincaVO findByNombre(String nombre) {
		return fdi.findByNombre(nombre);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceFinca#findById(int)
	 */
	public FincaVO findById(int idfinca) {
		return fdi.findById(idfinca);
	}
	
	
	
}
