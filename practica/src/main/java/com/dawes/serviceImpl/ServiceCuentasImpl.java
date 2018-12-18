package com.dawes.serviceImpl;

import java.util.List;

import com.dawes.dao.CuentaDAO;
import com.dawes.dao.MovimientoDAO;
import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.service.ServiceCuentas;
import com.dawes.util.DAOFactory;

public class ServiceCuentasImpl implements ServiceCuentas {
	
	CuentaDAOImpl cdi;
	DAOFactory f;
	
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#save(com.dawes.modelo.CuentaVO)
	 */
	@Override
	public int save(CuentaVO cuenta) {
		return cdi.save(cuenta);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#delete(com.dawes.modelo.CuentaVO)
	 */
	@Override
	public int delete(CuentaVO cuenta) {
		return cdi.delete(cuenta);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#update(com.dawes.modelo.CuentaVO)
	 */
	@Override
	public int update(CuentaVO cuenta) {
		return cdi.update(cuenta);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#findByNumCuenta(java.lang.String)
	 */
	@Override
	public CuentaVO findByNumCuenta(String numCuenta) {
		return cdi.findByNumCuenta(numCuenta);
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#deleteAll()
	 */
	@Override
	public void deleteAll() {
		cdi.deleteAll();
	}
	/* (non-Javadoc)
	 * @see com.dawes.serviceImpl.ServiceCuentas#movimientos3000()
	 */
	@Override
	public List<MovimientoVO> movimientos3000() {
		return cdi.movimientos3000();
	}
	public CuentaDAO getCuentaDAO() {
		return f.getCuentaDAO();
	}
	public MovimientoDAO getMovimientoDAO() {
		return f.getMovimientoDAO();
	}
	
	

}
