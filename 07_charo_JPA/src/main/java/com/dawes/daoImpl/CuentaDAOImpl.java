package com.dawes.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.dawes.dao.CuentaDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class CuentaDAOImpl implements CuentaDAO {

	EntityManager em;

	public CuentaDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public int save(CuentaVO cuenta) {

		try {
			em.getTransaction().begin();
			em.persist(cuenta);
			;
			em.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			System.err.println("Error al eliminar " + e.getMessage());
			return 0;
		}
	}

	@Override
	public int delete(CuentaVO cuenta) {
		try {
			em.getTransaction().begin();
			em.remove(cuenta);
			em.getTransaction().commit();
			return 1;

		} catch (PersistenceException e) {
			System.err.println("Error al eliminar " + e.getMessage());
			return 0;
		}

	}

	@Override
	public int update(CuentaVO cuenta) {
		try {

			em.getTransaction().begin();
			em.merge(cuenta);
			em.getTransaction().commit();
			return 1;

		} catch (PersistenceException e) {

			System.err.println("Error al actualizar registros de la tabla cuentas " + e.getMessage());
			return 0;
		}

	}

	@Override
	public CuentaVO findByNumCuenta(String numCuenta) {
		CuentaVO cuenta = null;
		try {
			em.getTransaction().begin();
			Query consulta = em.createQuery("select c from CuentaVO c where c.numCuenta=:numCuenta");
			consulta.setParameter("numCuenta", numCuenta);
			cuenta = (CuentaVO) consulta.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al consultar por numero cuenta " + e.getMessage());
		}

		return cuenta;
	}

	public void deleteAll() {
		try {

			em.getTransaction().begin();
			Query borrado = em.createQuery("delete from CuentaVO c");
			borrado.executeUpdate();
			em.getTransaction().commit();

		} catch (Exception e) {

			System.err.println("Error al eliminar todos los registros de la tabla cuentas " + e.getMessage());
		}

	}

	public List<MovimientoVO> movimientos3000() {
		List<MovimientoVO> listado = null;
		try {
			em.getTransaction().begin();
			Query movSup3000 = em
					.createQuery("select m from MovimientoVO m  join fetch m.cuenta c where m.importe>3000");
			// Query movSup3000=em.createQuery("select m from CuentaVO c join MovimientoVO m
			// on c.idCuenta=m.cuenta.idCuenta where m.importe>3000");
			listado = movSup3000.getResultList();
			listado.stream().forEach(x -> System.out.println("la cuenta " + x.getCuenta().getNumCuenta()
					+ " tienes un movimiento superior a 3000 � por importe " + x.getImporte()));
			em.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("Error al listar " + e.getMessage());
		}

		return listado;
	}
}