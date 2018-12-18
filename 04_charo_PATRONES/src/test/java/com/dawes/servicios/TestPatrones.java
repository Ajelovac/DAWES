package com.dawes.servicios;

import static org.junit.Assert.assertEquals;

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
public class TestPatrones {

	static ServiceCuentasImpl sc;
	static ServiceMovimientos sm;
	

	@BeforeClass
	public static void antesDeLaClase() {
		
		sc = new ServiceCuentasImpl();
		sm = new ServiceMovimientosImpl();
		sc.deleteAll();
	}
	
	@Test
	public void m1saveOK() {
		assertEquals(1,sc.save(new CuentaVO("1",100, LocalDate.now(),null)));
		assertEquals(1,sc.save(new CuentaVO("2",200, LocalDate.now(),null)));
	}
	
	@Test
	public void m2findByNumCuentaOK() {
		
		assertEquals(100, sc.findByNumCuenta("1").getSaldo(),0);
		
	}
	
	@Test
	public void m3InsertaMovimientoOK() {
		assertEquals(1,sm.save(new MovimientoVO(LocalDate.now(),"D",10,sc.findByNumCuenta("1"))));
		assertEquals(1,sm.save(new MovimientoVO(LocalDate.now(),"D",3010,sc.findByNumCuenta("1"))));
		assertEquals(1,sm.save(new MovimientoVO(LocalDate.now(),"D",3020,sc.findByNumCuenta("1"))));
		assertEquals(1,sm.save(new MovimientoVO(LocalDate.now(),"D",5000,sc.findByNumCuenta("2"))));
	}

		
	@Test
	public void m4ListadoOk() {
		assertEquals(2,sc.movimientos3000().size());
	}
	
	@Test
	public void m5UpdateOK() {
		CuentaVO c=sc.findByNumCuenta("2");
		c.setFecha(LocalDate.of(2015, 10, 1));
		assertEquals(1,sc.update(c));
	}
	
}
