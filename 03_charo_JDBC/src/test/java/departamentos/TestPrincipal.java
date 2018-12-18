package departamentos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import usuarios.CorreosVO;
import usuarios.UsuarioVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPrincipal {

	static public Principal p;

	@BeforeClass
	public static void inicializar() {
		p = new Principal();
		p.conectar();
		p.resetDB();
	}

	@Test
	public void m1conectarOk() {

		assertNotNull(p.getCon());
	}

	@Test
	public void m2mostrardeptNOnDameOk() {
		assertNotNull(p.mostrardeptNOdName());
	}

	@Test
	public void m3cambioDeptOk() {
		assertEquals(1, p.cambioDepartamento("Ventas", 30));
	}

	@Test
	public void m4transaccionCambioDepartamentok() {
		assertEquals(1, p.cambioDepartamento("Ventas", 30));
	}

	@Test
	public void m5Insertar() {
		assertEquals(1, p.insertar(new DeptVO(50, "INFORMATICA", "GIJON")));
	}

	@Test
	public void m6insertar() {
		assertEquals(1, p.insertarDepartamento(60, "MARKETING", "CANDAS"));
	}

	@Test
	public void m7listarOK() {
		assertEquals(6, p.listarTodo().size());
	}

	@Test
	public void m8buscarDeptNOOk() {
		assertNotNull(p.buscarporDeptNO(10));
		assertEquals("ACCOUNTING", p.buscarporDeptNO(10).getDname());
	}

	@Test
	public void m9modDeptOk() {
		assertEquals(1, p.modDept());
	}

	@Test
	public void maeliminarOK() {
		assertEquals(1, p.eliminarDept(50));
	}

	@Test
	public void mbActualizarLoc() {
		assertEquals(1, p.actualizarLocalidad(40, "OVIEDO"));
	}

	@Test
	public void mcExtraerDeptOK() {
		System.out.println(p.extraerDept(40));
		assertNotNull(p.extraerDept(40));
	}

	@Test
	public void mdactSueldoOk() {
		assertEquals(3, p.actSueldo(10, 10));
	}

	@Test
	public void meDatosBD() {
		assertEquals(1, p.datosBD());
	}

	@Test
	public void mfInsertarUsuario() {
		List<CorreosVO> suscorreos = new ArrayList();

		UsuarioVO usuario = new UsuarioVO(4, "Pepe", "700000b", 300, LocalDate.now(), null);

		suscorreos.add(new CorreosVO(5, "correo5", "hola5", LocalDateTime.now(), usuario));
		suscorreos.add(new CorreosVO(6, "correo6", "hola6", LocalDateTime.now(), usuario));
		usuario.setCorreos(suscorreos);
		assertEquals(1, p.insertarUsuario(usuario));
	}

	@Test
	public void buscarPorNIFOK() {
		assertNotNull(p.buscarPorNIF("53451245D"));
	}

	@Test
	public void insertarCorreo() {
		CorreosVO correo = new CorreosVO(7, "correo6", "hola6", LocalDateTime.now(), p.buscarPorNIF("53451245D"));
		assertEquals(1, p.insertarCorreo(correo));
	}

	@Test
	public void verUsuarios() {
		assertEquals(1, p.mostrarUsuarios());
	}

}
