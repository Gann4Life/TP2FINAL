package usuarios;

import contacto.GestionContactos;
import contacto.Mensaje;
import financiacion.GestionFinanciera;
import turnos.GestionTurnos;
import turnos.Turno;

public class Administrativo extends Usuario {
	
    public void aprobarTurno(int id) {
    	/*
 	 	 PROPOSITO: Aprueba el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a aprobar.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.aprobarTurno(id);
    }

    public void rechazarTurno(int id) {
    	/*
 	 	 PROPOSITO: Rechaza el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a rechazar.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.cancelarTurno(id);
    }

    public void generarTurno(Turno turno) {
    	/*
 	 	 PROPOSITO: Genera un nuevo turno
 	 	 PARÁMETROS:
 	 	 	* turno - El nuevo turno a generar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/

        //TODO: Verificar requerimientos de usuario/paciente al registrar el turno.

        GestionTurnos.registrarTurno(turno);
    }

    public void actualizarTurno(int id, Turno turno) {
    	/*
 	 	 PROPOSITO: Actualiza el turno con el id dado, por el turno dado.
 	 	 PARÁMETROS:
 	 	 	* id - El turno a actualizar.
 	 	 	* turno - El nuevo turno actualizado.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.actualizarTurno(id, turno);
    }

    public void cancelarTurno(int id) {
    	/*
 	 	 PROPOSITO: Cancela el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a cancelar.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.cancelarTurno(id);
    }

    public void generarSobreTurno(int id) {
    	/*
 	 	 PROPOSITO: Genera un sobre turno del turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a generar un sobreturno
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.generarSobreTurno(id);
    }
    
    public void enviarMensajeAlUsuario(Mensaje mensaje, int idUsuario) {
    	/*
 	 	 PROPOSITO: Envia el mensaje dado al usuario con el id dado.
 	 	 PARÁMETROS:
 	 	 	* mensaje - El mensaje a enviarle a usuario.
 	 	 	* idUsuario - El id del usuario a enviarle un mensaje.
 	 	 PRECONDICION:
 	 	 	* El usuario con el id dado debe existir.
    	*/
        GestionContactos.enviarMensajeAlUsuario(mensaje,idUsuario);
    }
    
    public void abonarPrestacion(int idPrestacion) {
    	/*
 	 	 PROPOSITO: Abona la prestación con el id dado.
 	 	 PARÁMETROS:
 	 	 	* idPrestacion - La id de la prestación a abonar.
 	 	 PRECONDICION:
 	 	 	* La prestación con el id dado debe existir.
    	*/
    	GestionFinanciera.abonarPrestacion(idPrestacion);
    }
    
}
