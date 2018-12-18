package com.dawes.dao;

import java.time.LocalDate;
import java.util.List;

import com.dawes.modelo.FincaVO;

public interface FincaDAO {

       void save(FincaVO finca);
       List<FincaVO> findAll();
       void remove(FincaVO finca);
       FincaVO findByNombre(String nombre);
       FincaVO findById(int idfinca);
}
