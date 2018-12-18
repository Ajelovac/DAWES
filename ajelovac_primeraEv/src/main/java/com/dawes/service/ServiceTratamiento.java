package com.dawes.service;

import com.dawes.modelo.TratamientoVO;

public interface ServiceTratamiento {

	void remove(TratamientoVO tratamiento);

	void save(TratamientoVO tratamiento);

	TratamientoVO findByProducto(String producto);

	TratamientoVO findById(int idtratamiento);

}