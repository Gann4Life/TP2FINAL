package usuarios;

import turnos.GestionTurnos;
import turnos.Turno;

public class Administrativo extends Usuario {
    public void aprobarTurno(int id) {
        GestionTurnos.aprobarTurno(id);
    }

    public void rechazarTurno(int id) {
        GestionTurnos.cancelarTurno(id);
    }

    void generarTurno(Turno turno) {
        GestionTurnos.registrarTurno(turno);
    }

    void actualizarTurno(int id, Turno turno) {
        GestionTurnos.actualizarTurno(id, turno);
    }

    void cancelarTurno(int id) {
        GestionTurnos.cancelarTurno(id);
    }

    void generarSobreTurno(int id) {
        GestionTurnos.generarSobreTurno(id);
    }
}
