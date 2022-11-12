package usuarios;

import database.BDD;
import enums.EstadoTurno;
import enums.PreferenciaContacto;
import turnos.GestionTurnos;
import turnos.Turno;

public class Paciente extends Usuario {
	
	
    public Paciente(String[] nombres, String[] apellidos, String email, String telefono, PreferenciaContacto preferencia) {
    	/*
 	 	 PROPOSITO: Instancia la clase Paciente.
 	 	 PARÁMETROS:
 	 	 	* nombres - Los nombres del paciente.
 	 	 	* apellidos - Los apellidos del paciente.
 	 	 	* email - El email del paciente.
 	 	 	* telefono - El telefono del paciente.
 	 	 	* preferencia - La preferencia de contacto del paciente.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto = new Contacto(email, telefono, preferencia);
    }
    public void pedirTurno() {
        // TODO: Verificación de requerimientos para pedir turnos.
        // Un paciente no puede obtener un turno si no pagó el servicio.
        // Un paciente no puede obtener un turno si no está registrado.
        // En caso de no estar registrado, se debe pedir registro y a continuación los métodos de pago.
        // El paciente se comunicaría con alguna instancia de administrativo para pedir el turno.

//        GestionTurnos.registrarTurno(GestionTurnos.crearTurno(
//                BDD.getInstance().usuarios.idDeDato(this),
//
//        ));
    }
    void verHistoriaClinica() {
    	/*
 	 	 PROPOSITO: Describe la historia clinica.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        //TODO: Historia clinica
    }

    public static Paciente obtenerPacienteBDD(int id) {
    	/*
 	 	 PROPOSITO: Obtiene el paciente con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del paciente a obtener.
 	 	 PRECONDICION:
 	 	 	* El paciente con el id dado debe existir.
    	*/
        return (Paciente) BDD.getInstance().usuarios.getDato(id);
    }
}
