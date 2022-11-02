import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import database.*;

public class BDDTest {
	
	BDD baseDeDatos = BDD.getInstance();
	
	@Test
	public void singleton() {
		Assert.assertEquals(baseDeDatos, BDD.getInstance());
	}
	// Test inciailes para comprobar que todo inicia vacio (juntar los test luego en un method aparte)
	@Test
	public void test1() {
		Assert.assertTrue(baseDeDatos.pacientes.getDatos().isEmpty());
	}
    
	@Test
	public void test2() {
		Assert.assertTrue(baseDeDatos.prestaciones.getDatos().isEmpty());
	}

	@Test 
	public void test3() {
		Assert.assertTrue(baseDeDatos.turnos.getDatos().isEmpty());
	}

	@Test 
	public void test4() {
		Assert.assertTrue(baseDeDatos.turnosPendientes.getDatos().isEmpty());
	}

	@Test
	public void test5() {
		Assert.assertTrue(baseDeDatos.laboratorios.getDatos().isEmpty());
	}

	@Test
	public void test6() {
		Assert.assertTrue(baseDeDatos.idCBU.getDatos().isEmpty());
	}

	@Test
	public void test7() {
		Assert.assertTrue(baseDeDatos.idEntidadFinanciacion.getDatos().isEmpty());
	}
}
