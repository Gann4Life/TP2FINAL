import org.junit.Assert;
import org.junit.Test;
import turnos.*;
import database.*;
import enums.EstadoTurno;

public class GestionTurnosTest {

	/*
	  -Gestion es singleton y son todos los metodos estaticos
	  -Los turnos pendientes se deberían de agregar a *turnosPendientes* en la base de datos
	*/
	BDD baseDeDatos = BDD.getInstance();
	Turno turno1 = new Turno(EstadoTurno.APROBADO);
	Turno turno2 = new Turno(EstadoTurno.APROBADO);
	Turno turno3 = new Turno(EstadoTurno.APROBADO);
	
	public void registrarTurnos() {
		GestionTurnos.registrarTurno(turno1);
		GestionTurnos.registrarTurno(turno2);
		GestionTurnos.registrarTurno(turno3);
	}
	
	@Test
	public void pruebaRegistrarTurno() {	
		registrarTurnos();
		Assert.assertEquals(turno1,baseDeDatos.turnos.getDato(0));
		Assert.assertEquals(turno2,baseDeDatos.turnos.getDato(1));
		Assert.assertEquals(turno3,baseDeDatos.turnos.getDato(2));
	}
	
	@Test
	public void pruebaActualizarTurno() {
		registrarTurnos();
		GestionTurnos.actualizarTurno(0, turno3);
		Assert.assertEquals(turno3, baseDeDatos.turnos.getDato(0));
		GestionTurnos.actualizarTurno(2, turno1);
		Assert.assertEquals(turno1, baseDeDatos.turnos.getDato(2));
	}
	
	@Test
	public void pruebaEstablecerEstado() {
		registrarTurnos();
		Turno turnoTest1 = (Turno)baseDeDatos.turnos.getDato(0);
		Turno turnoTest2 = (Turno)baseDeDatos.turnos.getDato(1);
		Turno turnoTest3 = (Turno)baseDeDatos.turnos.getDato(2);
		GestionTurnos.establecerEstado(0, EstadoTurno.CANCELADO);
		GestionTurnos.establecerEstado(1, EstadoTurno.AUSENTE);
		GestionTurnos.establecerEstado(2, EstadoTurno.APROBADO);
		Assert.assertEquals(EstadoTurno.CANCELADO, turnoTest1.estado);
		Assert.assertEquals(EstadoTurno.AUSENTE, turnoTest2.estado);
		Assert.assertEquals(EstadoTurno.APROBADO, turnoTest3.estado);
	}
	
	@Test
	public void pruebaCancelarTurno() {
		registrarTurnos();
		Turno turnoTest1 = (Turno)baseDeDatos.turnos.getDato(0);
		GestionTurnos.cancelarTurno(0);
		Assert.assertEquals(EstadoTurno.CANCELADO, turnoTest1.estado);
	}
	


}
