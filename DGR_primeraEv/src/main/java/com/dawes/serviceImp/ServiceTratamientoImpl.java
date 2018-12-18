package com.dawes.serviceImp;

import java.time.LocalDate;
import java.util.List;

import com.dawes.daoImp.TratamientoDAOImpl;
import com.dawes.modelo.TratamientoVO;
import com.dawes.service.ServiceTratamiento;
import com.dawes.util.DAOFactory;

public class ServiceTratamientoImpl implements ServiceTratamiento {
	
	private TratamientoDAOImpl daoTratamiento;
	private DAOFactory f;
	
	public ServiceTratamientoImpl() {
		f = DAOFactory.getF();
		daoTratamiento = (TratamientoDAOImpl) f.getTratamientoDAO();
	}

	@Override
	public void remove(TratamientoVO tratamiento) {
		daoTratamiento.remove(tratamiento);
	}

	@Override
	public void save(TratamientoVO tratamiento) {
		daoTratamiento.save(tratamiento);
	}

	@Override
	public TratamientoVO findByProducto(String producto) {
		return daoTratamiento.findByProducto(producto);
	}

	@Override
	public TratamientoVO findById(int idtratamiento) {
		return daoTratamiento.findById(idtratamiento);
	}
	
	@Override
	public List<TratamientoVO> findByFecha(LocalDate fechaIni, LocalDate fechaFin) {
		return daoTratamiento.findByFecha(fechaIni, fechaFin);
	}
	
	
	
}
