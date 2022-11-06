import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import database.*;
import enums.* ;
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
		baseDeDatos.turnos.hayDatos() || baseDeDatos.turnosPendientes.hayDatos() || baseDeDatos.laboratorios.hayDatos() 
		|| baseDeDatos.idEntidadFinanciacion.hayDatos() ;
		Assert.assertFalse(hayDatosBDD);
	}

	Turno turno1 = new Turno(EstadoTurno.APROBADO);
	String[] nombre1 = {"Juan"};
	String[] apellido1 = {"Lopez", "Maria"} ;
	Paciente juan = new Paciente( nombre1, apellido1, "juan@gmail.com", "21379218370", PreferenciaContacto.EMAIL) ;
	Usuario user1 = new Usuario() {} ;
	Administrativo admin = new Administrativo() ;
	@Test
	public void tablaUsuarioTieneUsuarioTest1() {
		baseDeDatos.usuarios.addDato(admin);
		baseDeDatos.usuarios.addDato(user1);
		baseDeDatos.usuarios.addDato(juan);
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().anyMatch(o -> o instanceof Administrativo));
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().anyMatch(o -> o instanceof Paciente));
		Assert.assertTrue(baseDeDatos.usuarios.getDatos().stream().allMatch(o -> o instanceof Usuario));
	}
	
	@Test
	public void tablaTurnosTieneTurnosTest1(){
		GestionTurnos.registrarTurno(turno1);
		baseDeDatos.turnos.addDato(turno1);
		Assert.assertEquals(2, baseDeDatos.turnos.cantidadDatos());
		Assert.assertTrue(baseDeDatos.turnos.getDatos().stream().allMatch(o -> o instanceof Turno));
	}

	
}
