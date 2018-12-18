package com.dawes.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.daoImpl.CuentaDAOImpl;
import com.dawes.daoImpl.MovimientoDAOImpl;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;
import com.dawes.service.ServiceCuentas;
import com.dawes.service.ServiceMovimientos;
import com.dawes.serviceImpl.ServiceCuentasImpl;
import com.dawes.serviceImpl.ServiceMovimientosImpl;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJPA {

	static ServiceCuentasImpl sc;
	static ServiceMovimientos sm;
	

	@BeforeClass
	public static void antesDeLaClase() {
		
		sc = new ServiceCuentasImpl();
		sm = new ServiceMovimientosImpl();	
	}
	
	@Test
	public void m1saveOK() {
		assertEquals(1,sc.save(new CuentaVO("3",100, LocalDate.now(),null)));
		assertEquals(1,sc.save(new CuentaVO("4",200, LocalDate.now(),null)));
	}

	
	@Test
	public void m3InsertaMovimientoOK() {
		sm.save(new MovimientoVO(LocalDate.now(),"D",10,sc.findByNumCuenta("1")));
		sm.save(new MovimientoVO(LocalDate.now(),"D",3010,sc.findByNumCuenta("1")));
		sm.save(new MovimientoVO(LocalDate.now(),"D",3020,sc.findByNumCuenta("1")));
		sm.save(new MovimientoVO(LocalDate.now(),"D",5000,sc.findByNumCuenta("2")));
		assertEquals(4,sm.findByIdCuenta(sc.findByNumCuenta("1").getIdCuenta()).size());
	}

		
	@Test
	public void m4ListadoOk() {
		assertEquals(3,sc.movimientos3000().size());
	}
	
	@Test
	public void m5UpdateOK() {
		CuentaVO c=sc.findByNumCuenta("2");
		c.setFecha(LocalDate.of(2015, 10, 1));
		sc.update(c);
		assertEquals(LocalDate.of(2015, 10, 1),sc.findByNumCuenta("2").getFecha());
	}
	
}
