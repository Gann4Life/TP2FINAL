import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import database.*;

public class BDDTest {
	
	BDD baseDeDatos = BDD.getInstance();
	private ArrayList<Object> listNull = new ArrayList<>() ;
	
	@Test
	public void singleton() {
		Assert.assertEquals(baseDeDatos, BDD.getInstance());
	}
	// Test inciailes para comprobar que todo inicia vacio (juntar los test luego en un method aparte)
	@Test
	public void test1() {
		Assert.assertEquals(listNull, baseDeDatos.pacientes.getDatos());
	}
    
	@Test
	public void test2() {
		Assert.assertEquals(listNull, baseDeDatos.prestaciones.getDatos());
	}

	@Test 
	public void test3() {
		Assert.assertEquals(listNull, baseDeDatos.turnos.getDatos());
	}

	@Test 
	public void test4() {
		Assert.assertEquals(listNull, baseDeDatos.turnosPendientes.getDatos());
	}

	@Test
	public void test5() {
		Assert.assertEquals(listNull, baseDeDatos.laboratorios.getDatos());
	}

	@Test
	public void test6() {
		Assert.assertEquals(listNull, baseDeDatos.idCBU.getDatos());
	}

	@Test
	public void test7() {
		Assert.assertEquals(listNull, baseDeDatos.idEntidadFinanciacion.getDatos());
	}
}
