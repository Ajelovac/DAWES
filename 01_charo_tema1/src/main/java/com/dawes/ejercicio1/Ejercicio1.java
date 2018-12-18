package com.dawes.ejercicio1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
	
	private Connection con=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private CallableStatement cs = null;
	
	
	public Connection getCon() {
		return con;
	}



	public void setCon(Connection con) {
		this.con = con;
	}



	public void conectar() {
		
		String url="jdbc:mysql://localhost/usuario";
		try {
			con=DriverManager.getConnection(url, "root", "temporal");
		} catch (SQLException e) {
			System.out.println("Se ha producido un error al conectar"+e.getMessage());
		}
		
	}
	
	public int insertar() {
		try {
			
			// creo un objeto statement para poder realizar la insercion posteriormente
			st=con.createStatement();
			
			// utilizo el objeto statemente para realizar la insercion
			return (st.executeUpdate("insert into usuario (nombre,edad) values ('ana',20)"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int insertarPS(String nombre, int edad) {
		try {
			System.out.println("la conexion esta en modo "+con.getAutoCommit());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Creo el objeto preparedstatement a través de la conexion
		try {
			ps=con.prepareStatement("insert into usuario (nombre,edad) values (?,?)");
			
			// asignar valores a los parametros
			ps.setString(1, nombre);
			ps.setInt(2, edad);
			
			// ejecuto la sentencia sql
			return ps.executeUpdate();
		} catch (SQLException e) {
//			if (e.getErrorCode()==1062)
//				System.out.println("la clave es duplicada");
			System.out.println("error al insertar ");
		}
		return 0;
	}
	
	public int eliminarTodo() {
		try {
			ps=con.prepareStatement("delete from usuario");
			return (ps.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int actualizar(String nombre, int edad) {
		
		try {
			ps=con.prepareStatement("update usuario set edad=? where nombre = ?");
			
			// asigno valores a los parametros de la ps
			ps.setInt(1, edad);
			ps.setString(2, nombre);
			
			// ejecuto la sentencia
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return 0;
		
	}

	public List<Usuario> leerTodos(){
		
		// preparo las variables que voy a necesitar
		Usuario u=null;
		List<Usuario> lista=new ArrayList();
		
		
		// creo una sentencia preparada con la consulta a la base de datos
		try {
			ps=con.prepareStatement("select * from usuario");
			rs=ps.executeQuery();
			
			// recorro el cursos con los registros de la tabla
			
			// itero por el cursor
			while (rs.next()) {
				
				// recupero las columnas del registro y construyo un objeto usuario
				u=new Usuario(rs.getString(1),rs.getInt(2));
				lista.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
		
	}
	
	public Usuario leerIgual(String kk) {
		
		try {
			ps=con.prepareStatement("select * from usuario where nombre=?");
			ps.setString(1, kk);
			rs=ps.executeQuery();
			rs.next();
			return new Usuario(rs.getString("nombre"),rs.getInt("edad"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	public void transaccion() {
		try {
			// desactivo el commit automatico
			
			// realizamos las operaciones que incluyen la transacción
			con.setAutoCommit(false);
			ps=con.prepareStatement("insert into usuario (nombre,edad) values ('tomasa',24)");
			ps.executeUpdate();
			ps=con.prepareStatement("insert into usuario (nombre,edad) values ('alejandro',20)");
			ps.executeUpdate();		
			
			// en caso de que no haya error, realizamos el commit
			con.commit();
		} catch (SQLException e) {
			try {
				
				// en caso de error hacemos un rollback
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(" error al realizar el rollback "+e1.getMessage());
			}
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("error al activar el commit automático "+e.getMessage());
		}
	}
	
	public ResultSet procedimientoAlmacenado(int edadLimite) {
		try {
			cs=con.prepareCall("{CALL pa1(?)}");
			cs.setInt(1, edadLimite);
			return cs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public PreparedStatement  insertarTransaccion(String nombre, int edad) throws SQLException {
		ps=con.prepareStatement("insert into usuario(nombre,edad) values (?,?)");
		ps.setString(1, nombre);
		ps.setInt(2, edad);
		return ps;
	}
	public void pruebaTransaccion() {
	try {
		// comienzo de transaccion
		con.setAutoCommit(false);
		
		// operaciones
		insertarTransaccion("tomasa", 20).executeUpdate();
		insertarTransaccion("javier", 20).executeUpdate();

		// final de transaccion ok
		con.commit();
	} catch (SQLException b) {
		try {
			// final de transaccion con error
		 con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// activo el autocommit de la base de datos
	try {
		con.setAutoCommit(true);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
