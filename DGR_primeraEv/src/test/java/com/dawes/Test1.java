package com.dawes;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.FincaTratamientoVO;
import com.dawes.modelo.FincaVO;
import com.dawes.modelo.TratamientoVO;
import com.dawes.serviceImp.ServiceFincaImpl;
import com.dawes.serviceImp.ServiceTratamientoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1 {

	static ServiceFincaImpl daoFinca;
	static ServiceTratamientoImpl daoTratamiento;
	
	@BeforeClass
	public static void inicializacion() {
		daoFinca = new ServiceFincaImpl();
		daoTratamiento = new ServiceTratamientoImpl();
	}
	
	@Test
	public void m1indByOk() {
		assertEquals(1, daoFinca.findByNombre("garcia").getIdFinca());
		assertEquals("Garcia", daoFinca.findById(1).getNombre());
		
		assertEquals(1, daoTratamiento.findByProducto("paracetamol").getIdTratamiento());
		assertEquals(7, daoTratamiento.findById(2).getDosis(), 0);
	}
	
	@Test
	public void m2insertarOk() {
		
		FincaVO finca = new FincaVO("Acebal", new ArrayList<FincaTratamientoVO>());
		TratamientoVO tratamiento = new TratamientoVO("ibuprofeno", 50, new ArrayList<FincaTratamientoVO>());
		FincaTratamientoVO fincaTrat = new FincaTratamientoVO(finca, tratamiento, LocalDate.of(2017, 8, 30));
		
		finca.getlFincaTratamiento().add(fincaTrat);
		tratamiento.getlFincaTratamiento().add(fincaTrat);
		
		daoTratamiento.save(tratamiento);
		daoFinca.save(finca);
		
	}
	
	@Test
	public void m3listarOk() {
		
		List<FincaVO> lFincas = daoFinca.findAll();
		assertEquals(4, lFincas.size());
		lFincas.forEach(x -> System.out.println(x));
		
		List<TratamientoVO> ltratamientos = daoTratamiento.findByFecha(LocalDate.of(2017, 1, 1), LocalDate.of(2018, 1, 1));
		assertEquals(1, ltratamientos.size());
		ltratamientos.forEach(x -> System.out.println(x));
	}

}
