package primeraEv;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dawes.service.ServiceIngrediente;
import com.dawes.service.ServiceReceta;
import com.dawes.serviceImp.ServiceIngredienteImpl;
import com.dawes.serviceImp.ServiceRecetaImpl;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1 {

	static ServiceReceta dReceta;
	static ServiceIngrediente dIngrediente;

	@BeforeClass
	public static void antesDelTest() {
		dReceta = new ServiceRecetaImpl();
		dIngrediente = new ServiceIngredienteImpl();
	}
	
	@Test
	public void m1save(){
		//IngredienteVO ingrediente = new IngredienteVO();
		assertEquals(1, 1);

	}
}
