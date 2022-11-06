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
		boolean hayDatosBDD = baseDeDatos.usuarios.hayDatos() || baseDeDatos.prestaciones.hayDatos() ||
		baseDeDatos.turnos.hayDatos() || baseDeDatos.turnosPendientes.hayDatos() || baseDeDatos.laboratorios.hayDatos() 
		|| baseDeDatos.idEntidadFinanciacion.hayDatos() ;
		Assert.assertFalse(hayDatosBDD);
	}

	// probar poner las cosas que no corresponde de forma intencional 
	Turno turno1 = new Turno(EstadoTurno.APROBADO);
	Paciente juan = new Paciente(null, null) ;
	@Test
	public void tablaPacientesTienePacientesTest1() {
		//baseDeDatos.pacientes.addDato(turno1);
		baseDeDatos.usuarios.addDato(juan);
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().allMatch(o -> o instanceof Paciente));
	}
	
	@Test
	public void tablaTurnosTieneTurnosTest1(){
		GestionTurnos.registrarTurno(turno1);
		baseDeDatos.turnos.addDato(turno1);
		Assert.assertEquals(2, baseDeDatos.turnos.cantidadDatos());
		Assert.assertTrue(baseDeDatos.turnos.getDatos().stream().allMatch(o -> o instanceof Turno));
	}

	
}
