package com.dawes.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.dawes.dao.MovimientoDAO;
import com.dawes.modelo.MovimientoVO;

public class MovimientoDAOImpl implements MovimientoDAO {

	EntityManager em;

	public MovimientoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public int save(MovimientoVO movimiento) {
		try {
			em.getTransaction().begin();
			em.persist(movimiento);
			;
			em.getTransaction().commit();
			return 1;

		} catch (PersistenceException e) {
			System.err.println("Error al insertar en movimiento " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int delete(MovimientoVO movimiento) {
		try {
			em.getTransaction().begin();
			em.remove(movimiento);
			em.getTransaction().commit();
			return 1;

		} catch (Exception e) {
			System.err.println("Error al eliminar movimiento " + e.getMessage());
			return 0;
		}

	}

	@Override
	public int update(MovimientoVO movimiento) {
		try {
			em.getTransaction().begin();
			em.merge(movimiento);
			em.getTransaction().commit();
			return 1;

		} catch (Exception e) {
			System.err.println("Error al modificar movivimiento " + e.getMessage());
			return 0;
		}
	}

	@Override
	public List<MovimientoVO> findByIdCuenta(int idCuenta) {
		List<MovimientoVO> lista = null;
		try {
			em.getTransaction().begin();
			Query consulta = em.createQuery("select m from MovimientoVO m where m.cuenta.idCuenta=:idCuenta");
			consulta.setParameter("idCuenta", idCuenta);
			lista = consulta.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error al consultar los movimientos por idcuenta" + e.getMessage());
		}
		return lista;
	}

	@Override
	public MovimientoVO findByIdMovimiento(int idMovimiento) {
		MovimientoVO m = null;
		try {
			em.getTransaction().begin();
			m = em.find(MovimientoVO.class, idMovimiento);
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("error al consultar movimiento por idmovimiento" + e.getMessage());
		}
		return m;
	}

}
