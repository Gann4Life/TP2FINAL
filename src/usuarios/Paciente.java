package usuarios;

import database.BDD;
import enums.PreferenciaContacto;
import turnos.Turno;

public class Paciente extends Usuario {
	
	
    public Paciente(String[] nombres, String[] apellidos, String email, String telefono, PreferenciaContacto preferencia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto = new Contacto(email, telefono, preferencia);
    }

    void pedirTurno(Turno turno) {
        //TODO: Peticion de turno
    }
    void verHistoriaClinica() {
        //TODO: Historia clinica
    }

    public static Paciente obtenerPacientesBDD(int id) {
        return (Paciente) BDD.getInstance().usuarios.getDato(id);
    }
}
