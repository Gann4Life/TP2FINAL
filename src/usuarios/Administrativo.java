package usuarios;

import enums.PreferenciaContacto;
import turnos.GestionTurnos;
import financiacion.GestionFinanciera;
import contacto.GestionContactos;
import contacto.Mensaje;
import database.BDD;
import turnos.Turno;

public class Administrativo extends Usuario {
	GestionContactos gesContactos = GestionContactos.getInstance();
	GestionFinanciera gesFinanciera = GestionFinanciera.getInstance();
	
    public void aprobarTurno(int id) {
        GestionTurnos.aprobarTurno(id);
    }

    public void rechazarTurno(int id) {
        GestionTurnos.cancelarTurno(id);
    }

    public void generarTurno(Turno turno) {
        GestionTurnos.registrarTurno(turno);
    }

    public void actualizarTurno(int id, Turno turno) {
        GestionTurnos.actualizarTurno(id, turno);
    }

    public void cancelarTurno(int id) {
        GestionTurnos.cancelarTurno(id);
    }

    public void generarSobreTurno(int id) {
        GestionTurnos.generarSobreTurno(id);
    }
    
    public void enviarMensajeAlUsuario(Mensaje mensaje, int idUsuario) {
        GestionContactos.enviarMensaJeAlUsuario(mensaje,idUsuario);
    }
    
    public void abonarPrestacion(int idUsuario) {
    	gesFinanciera.abonarPrestacion(idUsuario);
    }
    
}
