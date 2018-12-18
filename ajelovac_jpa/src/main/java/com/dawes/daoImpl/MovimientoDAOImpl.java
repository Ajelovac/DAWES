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

import com.dawes.dao.MovimientoDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class MovimientoDAOImpl implements MovimientoDAO {
	
	static EntityManager em;
	PreparedStatement ps;
	ResultSet rs;
	
	

	public MovimientoDAOImpl(EntityManager em) {
		this.em = em;
	}

	public int save(MovimientoVO movimiento) {

		try {
			em.getTransaction().begin();
			em.persist(movimiento);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			return 0;
		}
	}

	public int delete(MovimientoVO movimiento) {
		try {
			em.getTransaction().begin();

			em.remove(movimiento);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
		}
		return 0;

	}

	public int update(MovimientoVO movimiento) {
		try {
			em.getTransaction().begin();
			movimiento.setFecha(movimiento.getFecha());
			movimiento.setImporte(movimiento.getImporte());
			movimiento.setTipo(movimiento.getTipo());
            em.merge(movimiento);
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {

		}
		return 0;
	}

	
	public List<MovimientoVO> findByIdCuenta(CuentaVO cuenta) {
        
        List<MovimientoVO> lista = new ArrayList();
        
        try {
        TypedQuery<MovimientoVO> consulta = em.createQuery("select m from MovimientoVO m where cuenta:=cuenta", MovimientoVO.class);
        consulta.setParameter("cuenta", cuenta);
        lista = consulta.getResultList();
        return lista;
        } catch (PersistenceException e) {
            System.out.println("Error al buscar por id cuenta un movimiento: " + e.getMessage());
        }
        
        return lista;
    }

	

}
