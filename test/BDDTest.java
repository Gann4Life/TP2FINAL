import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import database.*;
import enums.* ;
import turnos.* ;
import usuarios.Paciente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BDDTest {
	
	BDD baseDeDatos = BDD.getInstance();

	@Test 
	public void singleton() {
		Assert.assertEquals(baseDeDatos, BDD.getInstance());
	}
	
	@Test
	public void inicializacionTest() {
		Assert.assertTrue(!baseDeDatos.pacientes.hayDatos());
		Assert.assertTrue(!baseDeDatos.prestaciones.hayDatos());
		Assert.assertTrue(!baseDeDatos.turnos.hayDatos());
		Assert.assertTrue(!baseDeDatos.turnosPendientes.hayDatos());
		Assert.assertTrue(!baseDeDatos.laboratorios.hayDatos());
		Assert.assertTrue(!baseDeDatos.idEntidadFinanciacion.hayDatos());
	}

	// probar poner las cosas que no corresponde de forma intencional 
	Turno turno1 = new Turno(EstadoTurno.Aprobado);
	Paciente juan = new Paciente(null, null) ;
	@Test
	public void tablaPacientesTienePacientesTest1() {
		//baseDeDatos.pacientes.addDato(turno1);
		baseDeDatos.pacientes.addDato(juan);
		Assert.assertTrue(baseDeDatos.pacientes.getDatos().stream().allMatch(o -> o instanceof Paciente));
	}
	
	@Test
	public void tablaTurnosTieneTurnosTest1(){
		GestionTurnos.registrarTurno(turno1);
		Assert.assertTrue(baseDeDatos.turnos.getDatos().stream().allMatch(o -> o instanceof Turno));
	}
}
