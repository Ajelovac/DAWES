package com.dawes.daoImpl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.dawes.dao.CuentaDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class CuentaDAOImpl implements CuentaDAO {

	static EntityManager em;
	PreparedStatement ps;
	ResultSet rs;

	public CuentaDAOImpl(EntityManager em) {
		this.em = em;
	}

	public int save(CuentaVO cuenta) {

		try {
			em.getTransaction().begin();
			em.persist(cuenta);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			return 0;
		}
	}

	public int delete(CuentaVO cuenta) {
		try {
			em.getTransaction().begin();

			em.remove(cuenta);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
		}
		return 0;

	}

	public int update(CuentaVO cuenta) {
		try {
			em.getTransaction().begin();
			cuenta.setNumCuenta(cuenta.getNumCuenta());
            cuenta.setSaldo(cuenta.getSaldo());
            cuenta.setFecha(cuenta.getFecha());
            cuenta.setMovimientos(cuenta.getMovimientos());			
            em.merge(cuenta);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {

		}
		return 0;
	}

	public CuentaVO encontrarNumCuenta(String numCuenta) {
		CuentaVO c;
		try {
			em.getTransaction().begin();

			TypedQuery<CuentaVO> consulta = em.createQuery("select c from CuentaVO c where numcuenta=:numcuenta", CuentaVO.class);
			
			consulta.setParameter("numcuenta", numCuenta);
			
            c = consulta.getSingleResult();
            
            return c;

		} catch (PersistenceException e) {

		}
		CuentaVO c1= new CuentaVO();
		return c1;
	}

	public List<CuentaVO> findAll() {
		CuentaVO c;
		try {
			em.getTransaction().begin();
			TypedQuery<CuentaVO> consulta = em.createQuery("select c from CuentaVO c", CuentaVO.class);
            
			List<CuentaVO> lista = consulta.getResultList();
            
			return lista;
			
		} catch (PersistenceException e) {

		}
		List<CuentaVO> lista1=null;
		return lista1;
	}

	

	public void movimientos3000() {
		
	}
}