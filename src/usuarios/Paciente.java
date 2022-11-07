package usuarios;

import database.BDD;
import enums.PreferenciaContacto;
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

    void pedirTurno(Turno turno) {
    	/*
 	 	 PROPOSITO: Pide el turno dado.
 	 	 PARÁMETROS:
 	 	 	* turno - El turno a pedir.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        //TODO: Peticion de turno
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
