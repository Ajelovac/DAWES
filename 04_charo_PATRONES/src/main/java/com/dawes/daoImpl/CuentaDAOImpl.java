package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.dawes.dao.CuentaDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class CuentaDAOImpl implements CuentaDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public CuentaDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public int save(CuentaVO cuenta) {

		try {
			ps = con.prepareStatement("insert into cuentas(numCuenta,saldo,fecha) values(?,?,?)");

			ps.setString(1, cuenta.getNumCuenta());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setDate(3, Date.valueOf(cuenta.getFecha()));

			return ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("error al insertar " + e.getMessage());
		}
		return 0;
	}

	@Override
	public void delete(CuentaVO cuenta) {
		try {
			// Borra registros según número de Cuenta (idCuentas clave primaria)
			ps = con.prepareStatement("delete from cuentas where idCuentas = ?");
			ps.setInt(1, cuenta.getIdCuenta());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Error al eliminar " + e.getMessage());
		}

	}

	@Override
	public int update(CuentaVO cuenta) {
		try {
			ps = con.prepareStatement("update cuentas set numCuenta = ?, saldo = ?, fecha = ? where idCuenta = ?");
			ps.setString(1, cuenta.getNumCuenta());
			ps.setDouble(2, cuenta.getSaldo());
			ps.setDate(3, Date.valueOf(cuenta.getFecha()));
			ps.setInt(4, cuenta.getIdCuenta());
			return ps.executeUpdate();

		} catch (SQLException e) {

			System.err.println("Error al actualizar registros de la tabla cuentas " + e.getMessage());
		}
		return 0;
	}

	@Override
	public CuentaVO findByNumCuenta(String numCuenta) {
		CuentaVO c = null;
		
		// hago una consulta con una combinacion externa por la izquierda para que tenga en cuenta las cuentas que no tienen movimientos
		try {
			ps = con.prepareStatement(
					"select * from cuentas c left outer join movimientos m on c.idCuenta = m.idCuenta where numCuenta = ?");

			ps.setString(1, numCuenta);
			rs = ps.executeQuery();
			if (rs.next()) {
				
				// construyo el objeto cuenta
				c = new CuentaVO(rs.getInt("c.idCuenta"), rs.getString("c.numCuenta"), rs.getDouble("c.saldo"),
						rs.getDate("fecha").toLocalDate(), new HashSet<MovimientoVO>());
				
				// completo la cuenta con sus movimientos
				while (rs.next()) {
					MovimientoVO m = new MovimientoVO(rs.getInt("m.idMovimiento"), rs.getDate("m.fecha").toLocalDate(),
							rs.getString("m.tipo"), rs.getDouble("m.importe"), c);
					c.addMovimiento(m);
				} 

				return c;
			} else
				return new CuentaVO();
		} catch (SQLException e) {
			System.out.println("Error al buscar cuenta por numero de cuenta: " + e.getMessage());
		}
		return c;

	}


	public void deleteAll() {
		try {
			ps=con.prepareStatement("delete from cuentas");
			ps.executeUpdate();
			ps=con.prepareStatement("alter table cuentas auto_increment=1");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<CuentaVO> movimientos3000(){
		List<CuentaVO> lista = new ArrayList();
		CuentaVO c=new CuentaVO();
		
		// tengo que controlar el tratamiento de la última fila del cursor
		boolean hayDatos=false;
		
		try {
			
			// construyo la consulta que devuelve las cuentas con sus movimientos superiores a 3000 euros al debe
			ps = con.prepareStatement("select * from cuentas c join movimientos m on c.idCuenta = m.idCuenta where m.importe>3000 and tipo='D'");
			rs = ps.executeQuery();
			hayDatos=rs.next();
			
			while (hayDatos) {
				
				// si hay varias cuentas que tienen movimientos que cumplen la condición, tengo que controlar cuando cambia de cuenta
				if (c.getIdCuenta()!=rs.getInt("c.idCuenta"))
						c = new CuentaVO(rs.getInt("c.idCuenta"), rs.getString("c.numCuenta"), rs.getDouble("c.saldo"),
						rs.getDate("fecha").toLocalDate(), new HashSet<MovimientoVO>());
				
				// recupero los movimientos de la cuenta
				do {
					MovimientoVO m = new MovimientoVO(rs.getInt("m.idMovimiento"), rs.getDate("m.fecha").toLocalDate(),
							rs.getString("m.tipo"), rs.getDouble("m.importe"), c);
					c.addMovimiento(m);
					hayDatos=rs.next();
				} while (hayDatos && c.getIdCuenta()==rs.getInt("c.idCuenta"));

				lista.add(c);
				
			} 
			
			return lista;
		} catch (SQLException e) {
			System.out.println("Error al consultar listado movimientos superiores 3000 " + e.getErrorCode());
		}
		return lista;
	}
}