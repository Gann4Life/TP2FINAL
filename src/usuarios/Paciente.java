package usuarios;

import database.BDD;
import turnos.Turno;

public class Paciente extends Usuario {

    public Paciente(String[] nombres, String[] apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
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
