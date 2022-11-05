package usuarios;

import turnos.GestionTurnos;
import financiacion.GestionFinanciera;
import contacto.GestionContactos;
import contacto.Mensaje;
import database.BDD;
import turnos.Turno;

import usuarios.Usuario;

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
    	Contacto contacto = BDD.getInstance().pacientes.getDato(idUsuario).contacto;
    	if(contacto.preferencia.toLowerCase() == "telefono")
    		gesContactos.enviarSMSAlUsuario(mensaje, idUsuario);
    	else {
    		gesContactos.enviarMailAlUsuario(mensaje, idUsuario);
    	}
    }
    
    public void abonarPrestacion(int idUsuario) {
    	gesFinanciera.abonarPrestacion(idUsuario);
    }
    
}
