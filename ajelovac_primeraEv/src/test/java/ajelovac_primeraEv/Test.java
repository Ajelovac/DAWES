package ajelovac_primeraEv;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.dawes.serviceImp.ServiceFincaImpl;
import com.dawes.serviceImp.ServiceTratamientoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test {

	static ServiceFincaImpl sf;
	static ServiceTratamientoImpl st;
	

	@BeforeClass
	public static void antesDeLaClase() {
		
		sf = new ServiceFincaImpl();
		st = new ServiceTratamientoImpl();	
	}
	
	
	@Test
	public void m1ConOk() {
		
	}
}