

import org.junit.Test;
import org.junit.Assert;
import database.TablaDatos;
import turnos.Turno;
import enums.EstadoTurno;


public class TablaDeDatosTest {
	
	TablaDatos tabla = new TablaDatos();
	Turno turno1 = new Turno(EstadoTurno.Aprobado);
	Turno turno2 = new Turno(EstadoTurno.Ausente);
	
	@Test
	public void pruebaAddDatoYGetDato() {
		tabla.addDato(turno1);
		Assert.assertEquals(turno1,tabla.getDato(0));
	}
	
	@Test
	public void pruebaReemplazarDato() {
		tabla.addDato(turno1);
		tabla.reemplazar(0, turno2);
		Assert.assertEquals(turno2, tabla.getDato(0));
	}

}
