
import org.junit.Assert;
import org.junit.Test;
import database.*;
import enums.* ;
import turnos.* ;
import usuarios.Paciente;

public class BDDTest {
	
	BDD baseDeDatos = BDD.getInstance();

	@Test
	public void singleton() {
		Assert.assertEquals(baseDeDatos, BDD.getInstance());
	}
	// Test inciailes para comprobar que todo inicia vacio (juntar los test luego en un method aparte)
	
	@Test
	public void inicializacionTest1() {
		Assert.assertTrue(baseDeDatos.pacientes.getDatos().isEmpty());
	}
    
	@Test
	public void inicializacionTest2() {
		Assert.assertTrue(baseDeDatos.prestaciones.getDatos().isEmpty());
	}

	@Test 
	public void inicializacionTest3() {
		Assert.assertTrue(baseDeDatos.turnos.getDatos().isEmpty());
	}

	@Test 
	public void inicializacionTest4() {
		Assert.assertTrue(baseDeDatos.turnosPendientes.getDatos().isEmpty());
	}

	@Test
	public void inicializacionTest5() {
		Assert.assertTrue(baseDeDatos.laboratorios.getDatos().isEmpty());
	}

	@Test
	public void inicializacionTest6() {
		Assert.assertTrue(baseDeDatos.idCBU.getDatos().isEmpty());
	}

	@Test
	public void inicializacionTest7() {
		Assert.assertTrue(baseDeDatos.idEntidadFinanciacion.getDatos().isEmpty());
	}

	// probar poner las cosas que no corresponde de forma intencional 
	Turno turno1 = new Turno(EstadoTurno.Aprobado);
	Paciente juan = new Paciente(null, null) ;
	@Test
	public void tablaPacientesTienePacienteTest1() {
		//baseDeDatos.pacientes.addDato(turno1);
		baseDeDatos.pacientes.addDato(juan);
		Assert.assertTrue(baseDeDatos.pacientes.getDatos().stream().allMatch(o -> o instanceof Paciente));
	}
	
}
