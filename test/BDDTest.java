import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import database.*;
import enums.* ;
import financiacion.EntidadFinanciera;
import main.Laboratorio;
import main.Prestacion;
import turnos.* ;
import usuarios.Administrativo;
import usuarios.Paciente;
import usuarios.Usuario;

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
		baseDeDatos.turnos.hayDatos() || baseDeDatos.laboratorios.hayDatos() || baseDeDatos.idEntidadFinanciacion.hayDatos() ;
		Assert.assertFalse(hayDatosBDD);
	}

	@Test(expected = RuntimeException.class) 
	public void tablaUsuarioTieneUsuarioTest1() {
		String[] nombre1 = {"Juan"};
		String[] apellido1 = {"Lopez", "Maria"} ;
		Paciente juan = new Paciente( nombre1, apellido1, "juan@gmail.com", "21379218370", PreferenciaContacto.EMAIL) ;
		Usuario user1 = new Usuario() {} ;
		Administrativo admin = new Administrativo() ;
		baseDeDatos.usuarios.addDato(admin);
		baseDeDatos.usuarios.addDato(user1);
		baseDeDatos.usuarios.addDato(null);
		baseDeDatos.usuarios.addDato(juan);
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().anyMatch(o -> o instanceof Administrativo));
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().anyMatch(o -> o instanceof Paciente));
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().allMatch(o -> o instanceof Usuario));
	}
	
	@Test(expected = RuntimeException.class) 
	public void tablaTurnosTieneTurnosTest1(){
		Turno turno1 = new Turno(EstadoTurno.APROBADO);
		GestionTurnos.registrarTurno(turno1);
		baseDeDatos.turnos.addDato(turno1);
		baseDeDatos.turnos.addDato(null);
		Assert.assertEquals(2, baseDeDatos.turnos.cantidadDatos());
		Assert.assertTrue(baseDeDatos.turnos.getDatos().stream().allMatch(o -> o instanceof Turno));
	}

	@Test(expected = RuntimeException.class) 
	public void tablaprestacionesTienePrestacionTest1(){
		Prestacion prestacion = new Prestacion(0) ;
		baseDeDatos.prestaciones.addDato(null);
		baseDeDatos.prestaciones.addDato(prestacion);
		Assert.assertTrue(baseDeDatos.prestaciones.getDatos().stream().allMatch(o -> o instanceof Prestacion));
	}

	@Test(expected = RuntimeException.class) 
	public void tablaLaboratoriosTieneLaboratorioTest1(){
		Laboratorio laboratorio = new Laboratorio() ;
		baseDeDatos.laboratorios.addDato(laboratorio);
		baseDeDatos.laboratorios.addDato(null);
		Assert.assertTrue(baseDeDatos.laboratorios.getDatos().stream().allMatch(o -> o instanceof Laboratorio));
	}

	@Test(expected = RuntimeException.class) 
	public void tablaIdEntidadFinanciacionTieneIdEntidadFinanciacion(){
		EntidadFinanciera entidadFinanciera = new EntidadFinanciera() {};
		baseDeDatos.idEntidadFinanciacion.addDato(entidadFinanciera);
		baseDeDatos.idEntidadFinanciacion.addDato(null);
		Assert.assertTrue(baseDeDatos.idEntidadFinanciacion.getDatos().stream().allMatch(o -> o instanceof EntidadFinanciera));
	}

}
