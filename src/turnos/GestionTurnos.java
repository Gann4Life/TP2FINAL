package turnos;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionTurnos {

    private GestionTurnos(){}

    public static List<Date> fechasDisponibles(Especialidad especialidad) {
        //TODO: Retornar fechas disponibles para la especialidad dada
        return new ArrayList<Date>();
    }

    public static void registrarTurno(Turno nuevoTurno) {
        BDD.getInstance().turnos.addDato(nuevoTurno);
    }

    public static void actualizarTurno(int id, Turno turno) {
        BDD.getInstance().turnos.reemplazar(id, turno);
    }

    public static void cancelarTurno(int id) {
        establecerEstado(id, EstadoTurno.CANCELADO);
    }

    public static void aprobarTurno(int id) {
        establecerEstado(id, EstadoTurno.APROBADO);
    }

    public static void establecerEstado(int id, EstadoTurno estado) {
        //TODO: Limpiar logs

        Turno turno = (Turno) BDD.getInstance().turnos.getDato(id);
        System.out.println("Se actualizó el estado de un turno.\n\tAntes: " + turno.estado);
        turno.setEstado(estado);
        System.out.println("\tAhora: " + turno.estado);
    }

    public static Turno obtenerTurno(int id) {
        return (Turno) BDD.getInstance().turnos.getDato(id);
    }

    public static void reportarAusenciasConsecutivas(int idAdministrativo) {
        //TODO: Reportar ausencia consecutiva
    }

    public static void generarSobreTurno(int idTurno) {
        GestionTurnos.registrarTurno(
                new Turno(GestionTurnos.obtenerTurno(idTurno))
        );
    }
}
