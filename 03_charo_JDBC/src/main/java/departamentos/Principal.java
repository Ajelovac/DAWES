package departamentos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import usuarios.CorreosVO;
import usuarios.UsuarioVO;

public class Principal {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement cs;

	public Connection getCon() {
		return con;
	}

	public void conectar() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/tema1", "root", "temporal");
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getErrorCode());
		}
	}

	public void resetDB() {
		String path = this.getClass().getResource("/creaTablas.sql").getFile();

		BufferedReader reader = null;
		Statement st = null;

		try {
			st = con.createStatement();

			reader = new BufferedReader(new FileReader(path));

			String line;

			while ((line = reader.readLine()) != null) {
				st.execute(line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public ResultSet mostrardeptNOdName() {
		try {
			ps = con.prepareStatement("select deptNO, dname from dept");
			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + "      " + rs.getString(2));
			}
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int cambioDepartamento(String nombre, int dept) {
		try {
			ps = con.prepareStatement("update dept set dname=? where deptNO=?");

			ps.setString(1, nombre);
			ps.setInt(2, dept);
			return ps.executeUpdate();
		} catch (SQLException e) {
			return 0;
			// TODO: handle exception
		}
	}

	public int transaccionCambioDepartamento(String nombre, int dept) {
		int res = 0;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement("update dept set dname=? where deptNO=?");
			ps.setString(1, nombre);
			ps.setInt(2, dept);
			res = ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		try {
			con.setAutoCommit(true);
		} catch (SQLException e3) {
			System.out.println(e3.getMessage());
		}
		return res;
	}

	public int insertar(DeptVO dp) {
		int resultado;
		try {
			ps = con.prepareStatement("insert into dept (deptNO, dname, loc) values (?,?,?)");
			ps.setInt(1, dp.getDeptNO());
			ps.setString(2, dp.getDname());
			ps.setString(3, dp.getLoc());
			resultado = ps.executeUpdate();
		} catch (SQLException e) {
			resultado = 0;
			e.printStackTrace();
		}
		return resultado;
	}

	public int insertarDepartamento(int numero, String nombre, String localidad) {
		return insertar(new DeptVO(numero, nombre, localidad));

	}

	public List<DeptVO> listarTodo() {

		ArrayList<DeptVO> lista = new ArrayList();
		DeptVO dep;

		try {
			ps = con.prepareStatement("Select * from dept");

			rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public DeptVO buscarporDeptNO(int num) {
		DeptVO d = null;

		try {
			ps = con.prepareStatement("select * from dept where deptNO=?");

			ps.setInt(1, num);

			rs = ps.executeQuery();

			if (rs.next())
				d = new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;

	}

	public int modDept() {
		try {
			ps = con.prepareStatement("alter table dept modify dname VARCHAR(65)");
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			System.out.println("Error: " + e.getErrorCode());
			e.printStackTrace();
		}
		return 0;

	}

	public int eliminarDept(int deptNO) {
		try {
			ps = con.prepareStatement("delete from dept where deptNO=?");
			ps.setInt(1, deptNO);

			return ps.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == 1451) {
				System.out.println("No puedes eliminar este departamento porque tiene empleados");
			} else {
				System.out.println("Hay un error " + e.getMessage());
			}
		}
		return 0;

	}

	public int actualizarLocalidad(int numDept, String newLoc) {
		try {
			cs = con.prepareCall("{CALL updtLoc(?,?)}");
			cs.setInt(1, numDept);
			cs.setString(2, newLoc);

			return cs.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Hay un error " + e.getMessage());
		}

		return -1;
	}

	public DeptVO extraerDept(int numDept) {
		try {
			cs = con.prepareCall("{CALL getDept(?)}");
			cs.setInt(1, numDept);
			rs = cs.executeQuery();
			if (rs.next())
				return new DeptVO(rs.getInt(1), rs.getString(2), rs.getString(3));
			else
				return new DeptVO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int actSueldo(float cant, int dept) {
		try {
			cs = con.prepareCall("{CALL m3(?,?)}");
			cs.setFloat(1, cant);
			cs.setInt(2, dept);

			return cs.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int datosBD() {

		try {
			DatabaseMetaData metadatos = con.getMetaData();

			System.out.println("Base de datos utilizada: " + metadatos.getDatabaseProductName());
			System.out.println("Driver: " + metadatos.getDriverName());
			System.out.println("Usuario conectado: " + metadatos.getUserName());

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int insertarUsuario(UsuarioVO usuario) {
		int resultado = 0;

		try {
			con.setAutoCommit(false);

			// insertamos en la tabla usuarios
			ps = con.prepareStatement("insert into usuarios (idUsuario, nombre, nif, saldo, fecha) values (?,?,?,?,?)");
			ps.setInt(1, usuario.getIdUsuario());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getNif());
			ps.setDouble(4, usuario.getSueldo());
			ps.setDate(5, Date.valueOf(usuario.getFecha()));
			ps.executeUpdate();

			// insertar en la tabla correos
			List<CorreosVO> correos = usuario.getCorreos();
			for (CorreosVO c : correos) {
				ps = con.prepareStatement(
						"insert into correos (idCorreo, remitente, mensaje, fechaHora, idUsuario ) values (?,?,?,?,?)");
				ps.setInt(1, c.getIdcorreo());
				ps.setString(2, c.getRemitente());
				ps.setString(3, c.getMensaje());
				ps.setTimestamp(4, Timestamp.valueOf(c.getFechahora()));
				ps.setInt(5, c.getUsuario().getIdUsuario());
				ps.executeUpdate();

			}
			resultado = 1;
			con.commit();

		}

		catch (SQLException e) {
			try {
				resultado = 0;
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		try {
			con.setAutoCommit(true);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;

	}

	public UsuarioVO buscarPorNIF(String nif) {

		try {
			ps = con.prepareStatement("select * from usuarios where nif = ?");
			ps.setString(1, nif);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new UsuarioVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getDate(5).toLocalDate(), null);
			} else {
				return new UsuarioVO();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int insertarCorreo(CorreosVO correo) {

		try {
			ps = con.prepareStatement("insert into correos values (?,?,?,?,?)");
			ps.setInt(1, correo.getIdcorreo());
			ps.setString(2, correo.getRemitente());
			ps.setString(3, correo.getMensaje());
			ps.setTimestamp(4, Timestamp.valueOf(correo.getFechahora()));
			ps.setInt(5, correo.getUsuario().getIdUsuario());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int mostrarUsuarios() {
		try {
			// ps = con.prepareStatement("select u.nombre, u.nif, u.saldo, u.fecha,
			// c.mensaje, c.remitente from usuarios u,
			// correos c where c.idusuario = u.idusuario");
			ps = con.prepareStatement(
					"select u.nombre, u.nif, u.saldo, u.fecha, c.mensaje, c.remitente from usuarios u join "
							+ "correos c on u.idusuario = c.idusuario");

			rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(
						"nombre: " + rs.getString(1) + "NIF: " + rs.getString(2) + "Mensaje: " + rs.getString(5));
			}
			return 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

}
