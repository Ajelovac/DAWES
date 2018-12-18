package com.dawes.service;

import java.time.LocalDate;
import java.util.List;

import com.dawes.modelo.TratamientoVO;

public interface ServiceTratamiento {

	void remove(TratamientoVO tratamiento);

	void save(TratamientoVO tratamiento);

	TratamientoVO findByProducto(String producto);

	TratamientoVO findById(int idtratamiento);
	
	List<TratamientoVO> findByFecha(LocalDate fechaIni, LocalDate fechaFin);

}