package com.dawes.dao;

import com.dawes.modelo.TratamientoVO;

public interface TratamientoDAO {

	void remove(TratamientoVO tratamiento);
	void save(TratamientoVO tratamiento);
	TratamientoVO findByProducto(String producto);
	TratamientoVO findById(int idtratamiento);
}
