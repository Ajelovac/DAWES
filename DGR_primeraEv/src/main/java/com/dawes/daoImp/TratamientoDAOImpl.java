package com.dawes.daoImp;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dawes.dao.TratamientoDAO;
import com.dawes.modelo.TratamientoVO;

public class TratamientoDAOImpl implements TratamientoDAO {

	private EntityManager em;
	
	public TratamientoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void remove(TratamientoVO tratamiento) {
		
		try {
			em.getTransaction().begin();
			
			em.remove(tratamiento);
			
			em.getTransaction().commit();
			
			System.out.println("Se ha eliminado el tratamiento");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("Se ha producido un error eliminando el tratamiento " + e.getMessage());
		}
		
	}

	@Override
	public void save(TratamientoVO tratamiento) {
		
		try {
			em.getTransaction().begin();
			
			em.persist(tratamiento);
			
			em.getTransaction().commit();
			
			System.out.println("Se ha insertado el tratamiento");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			System.out.println("Se ha producido un error insertando el tratamiento " + e.getMessage());
		}
		
	}

	@Override
	public TratamientoVO findByProducto(String producto) {
		
		TratamientoVO tratamiento;
		
		TypedQuery<TratamientoVO> query = em.createQuery("select t from TratamientoVO t where t.producto =: producto", TratamientoVO.class);
		query.setParameter("producto", producto);
		
		tratamiento = query.getSingleResult();
		
		return tratamiento;
		
	}

	@Override
	public TratamientoVO findById(int idtratamiento) {
		return em.find(TratamientoVO.class, idtratamiento);
	}
	
	@Override
	public List<TratamientoVO> findByFecha(LocalDate fechaIni, LocalDate fechaFin) {
		
		TypedQuery<TratamientoVO> query = em.createQuery("select t from TratamientoVO t, FincaTratamientoVO tf where t.idTratamiento = tf.tratamiento and tf.fecha between :fechaIni and :fechaFin", TratamientoVO.class);
		query.setParameter("fechaIni", fechaIni);
		query.setParameter("fechaFin", fechaFin);
		
		return query.getResultList();
	}

}
