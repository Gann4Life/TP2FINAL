package usuarios;

import database.BDD;
import turnos.Turno;

public class Paciente extends Usuario {
	
	
    public Paciente(String[] nombres, String[] apellidos, String email, String tel, String preferencia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto = new Contacto(email, tel, preferencia);
    }

    void pedirTurno(Turno turno) {
        //TODO: Peticion de turno
    }
    void verHistoriaClinica() {
        //TODO: Historia clinica
    }

    public static Paciente obtenerPacientesBDD(int id) {
        return (Paciente) BDD.getInstance().pacientes.getDato(id);
    }
}
