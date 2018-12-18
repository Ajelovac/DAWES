package com.dawes.serviceImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.dawes.daoImp.TratamientoDAOImpl;
import com.dawes.modelo.TratamientoVO;
import com.dawes.service.ServiceTratamiento;
import com.dawes.util.DAOFactory;

public class ServiceTratamientoImpl implements ServiceTratamiento {

	TratamientoDAOImpl tdi;
	DAOFactory f;
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceTratamiento#remove(com.dawes.modelo.TratamientoVO)
	 */
	@Override
	public void remove(TratamientoVO tratamiento) {
		tdi.remove(tratamiento);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceTratamiento#save(com.dawes.modelo.TratamientoVO)
	 */
	@Override
	public void save(TratamientoVO tratamiento) {
		tdi.save(tratamiento);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceTratamiento#findByProducto(java.lang.String)
	 */
	@Override
	public TratamientoVO findByProducto(String producto) {
		return tdi.findByProducto(producto);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImp.ServiceTratamiento#findById(int)
	 */
	@Override
	public TratamientoVO findById(int idtratamiento) {
		return tdi.findById(idtratamiento);
	}
	public EntityManagerFactory getEmf() {
		return f.getEmf();
	}
	public EntityManager getEm() {
		return f.getEm();
	}
	
	
}
