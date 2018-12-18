package practica_recuperacion_primeraEv;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.dawes.modelo.RecetaIngredienteVO;
import com.dawes.modelo.IngredienteVO;
import com.dawes.modelo.RecetaVO;
import com.dawes.serviceImp.ServiceIngredienteImpl;
import com.dawes.serviceImp.ServiceRecetaImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_1 {
	
	static ServiceIngredienteImpl si;
	static ServiceRecetaImpl sr;
	
	@BeforeClass
	public static void init() {
		si=new ServiceIngredienteImpl();
		sr=new ServiceRecetaImpl();
	}
	
	@Test
	public void m1insertarOK() {
		IngredienteVO i1=si.findByNombre("Zanahoria");
		IngredienteVO i2=si.findByNombre("Platano");
		Set<CantidadVO> cantidad=new HashSet();
		RecetaVO r1=new RecetaVO("Macedonia",cantidad);
		CantidadVO c1=new CantidadVO(r1,i1,300);
		CantidadVO c2=new CantidadVO(r1,i2,250);
		r1.addC(c1);
		r1.addC(c2);
		i1.addC(c1);
		i2.addC(c2);
		si.save(i1);
		si.save(i2);
		sr.save(r1);
	}

}
