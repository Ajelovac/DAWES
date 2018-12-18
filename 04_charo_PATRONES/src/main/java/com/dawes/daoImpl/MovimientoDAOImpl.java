package com.dawes.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.dawes.dao.MovimientoDAO;
import com.dawes.modelo.CuentaVO;
import com.dawes.modelo.MovimientoVO;

public class MovimientoDAOImpl implements MovimientoDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	

	public MovimientoDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public int save(MovimientoVO movimiento) {
		//Inserto un movimiento en la tabla movimientos
		try {
			ps = con.prepareStatement("insert into movimientos(idMovimiento, fecha, tipo, importe, idCuenta) values(?,?,?,?,?)");
			
			ps.setInt(1, movimiento.getIdMovimiento());
			ps.setDate(2, Date.valueOf(movimiento.getFecha()));
			ps.setString(3, movimiento.getTipo());
			ps.setDouble(4, movimiento.getImporte());
			ps.setInt(5, movimiento.getCuenta().getIdCuenta());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("error al insertar movimientos " + e.getMessage());
		}
		
		return 0;
	}

	@Override
	public void delete(MovimientoVO movimiento) {
		//Borra los movimientos bancarios
		try {
			ps = con.prepareStatement("delete from movimientos where idMovimiento = ?");
			ps.setInt(1, movimiento.getIdMovimiento());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Error al eliminar "+e.getMessage());

		}

	}

	@Override
	public int update(MovimientoVO movimiento) {
		try {
			ps = con.prepareStatement("update movimientos set fecha = ?, tipo = ?, importe = ? where idMovimiento = ?");
			ps.setDate(1, Date.valueOf(movimiento.getFecha()));
			ps.setString(2,movimiento.getTipo());
			ps.setDouble(3, movimiento.getImporte());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.err.println("Error al actualizar registros de la tabla movimientos " + e.getMessage());

		}
		return 0;
	}

	
	@Override
	public List<MovimientoVO> findByIdCuenta(int idCuenta) {
		List<MovimientoVO> lista=null;
		try {
			ps = con.prepareStatement("select * from cuentas c join movimientos m  on c.idCuenta = m.idCuenta where c.idCuenta = ?");
			
			ps.setInt(1, idCuenta);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 CuentaVO c = new CuentaVO(rs.getInt("c.idCuenta"), rs.getString("c.numCuenta"), rs.getDouble("c.saldo"),
						rs.getDate("fecha").toLocalDate(), new HashSet<MovimientoVO>());
				 MovimientoVO m = new MovimientoVO(rs.getInt("m.idMovimiento"), rs.getDate("m.fecha").toLocalDate(),
							rs.getString("m.tipo"), rs.getDouble("m.importe"), c);
					
				lista.add(m);
				
			} 
			return lista;
		} catch (SQLException e) {
			System.out.println("Error al buscar movimientos por idCuenta: " + e.getErrorCode());
		}
		return lista;
	}
	
	

	@Override
	public MovimientoVO findByIdMovimiento(int idMovimiento) {
		// TODO Auto-generated method stub
		return null;
	}

}
