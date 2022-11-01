package turnos;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionTurnos {
    private static GestionTurnos instance;

    private GestionTurnos(){}

    public static GestionTurnos getInstance() {
        if(instance == null)
            instance = new GestionTurnos();
        return instance;
    }

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

    public static void cancelarTurno(int idTurno) {
        //TODO: Cancelar el turno con ID
        Turno turno = (Turno) BDD.getInstance().turnos.getDato(idTurno);
        turno.setEstado(EstadoTurno.Cancelado);

        System.out.println("Se actualizó el estado del dato: " + ((Turno)BDD.getInstance().turnos.getDato(idTurno)).estado);
    }

    public static void reportarAusenciasConsecutivas(int idAdministrativo) {
        //TODO: Reportar ausencia consecutiva
    }

    public static Turno generarSobreTurno(int idTurno, Turno sobreTurno) {
        //TODO: Definir sobreturno generado
        return new Turno(EstadoTurno.Pendiente);
    }
}
