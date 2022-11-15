package turnos;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;
import usuarios.Medico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GestionTurnos {
    public static List<Date> fechasDisponibles(Especialidad especialidad) {
    	/*
 	 	 PROPOSITO: Retorna las fechas disponibles para la especialidad dada.
 	 	 PARÁMETROS:
 	 	 	* especialidad - La especialidad a ver sus fechas disponibles.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return new ArrayList<Date>();
    }

    public static Turno crearTurno(int idPaciente, int idMedico) {
        Turno turno = new Turno(EstadoTurno.PENDIENTE);

        turno.especialidad = ((Medico) BDD.getInstance().usuarios.getDato(idMedico)).especialidad;

        return turno;
    }

    public static void registrarTurno(Turno nuevoTurno) {
    	/*
 	 	 PROPOSITO: Registra el turno dado en la base de datos.
 	 	 PARÁMETROS:
 	 	 	* nuevoTurno - El turno a registrar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        BDD.getInstance().turnos.addDato(nuevoTurno);
    }

    public static void actualizarTurno(int id, Turno turno) {
    	/*
 	 	 PROPOSITO: Actualiza el turno con el id dado por el turno dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a actualizar.
 	 	 	* turno - El nuevo turno.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        BDD.getInstance().turnos.reemplazar(id, turno);
    }

    public static void cancelarTurno(int id) {
    	/*
 	 	 PROPOSITO: Cancela el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a cancelar.
 	 	 PRECONDICION:
 	 	  	* El turno con el id dado debe existir.
    	*/
        establecerEstado(id, EstadoTurno.CANCELADO);
    }

    public static void aprobarTurno(int id) {
    	/*
 	 	 PROPOSITO: Aprueba el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a aprobar.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        establecerEstado(id, EstadoTurno.APROBADO);
    }

    public static void establecerEstado(int id, EstadoTurno estado) {
    	/*
 	 	 PROPOSITO: Establece el estado del turno con el id dado, por el estado dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del turno a establecer el nuevo estado.
 	 	 	* estado - El estado a establecer al turno.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        //TODO: Limpiar logs

        Turno turno = (Turno) BDD.getInstance().turnos.getDato(id);
        System.out.println("Se actualizó el estado de un turno.\n\tAntes: " + turno.estado);
        turno.setEstado(estado);
        System.out.println("\tAhora: " + turno.estado);
    }

    public static Turno obtenerTurno(int id) {
    	/*
 	 	 PROPOSITO: Obtiene el turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El turno a obtener.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        return (Turno) BDD.getInstance().turnos.getDato(id);
    }

    public static void reportarAusenciasConsecutivas(int idAdministrativo) {
    	/*
 	 	 PROPOSITO: El adiministrativo con el id dado reporta ausencias consecutivas.
 	 	 PARÁMETROS:
 	 	 	* idAdministrativo - El id del administrativo que hara el reporte.
 	 	 PRECONDICION:
 	 	 	* El administrativo con el id dado debe existir.
    	*/
        //TODO: Reportar ausencia consecutiva
    }

    public static void generarSobreTurno(int idTurno) {
    	/*
 	 	 PROPOSITO: Genera un sobre turno del Turno con el id dado.
 	 	 PARÁMETROS:
 	 	 	* idTurno - El id del turno a generar el sobre turno.
 	 	 PRECONDICION:
 	 	 	* El turno con el id dado debe existir.
    	*/
        GestionTurnos.registrarTurno(
                new Turno(GestionTurnos.obtenerTurno(idTurno))
        );
    }

    public static ArrayList<Turno> turnosConEstado(EstadoTurno estado) {
    	/*
 	 	 PROPOSITO: Devuelve los turnos que tiene el estado dado.
 	 	 PARÁMETROS:
 	 	 	* estado - El estado de los turnos a obtener.
 	 	 PRECONDICION:
 	 	 	* Ninguna. 
    	*/
        return BDD.getInstance().turnos.getDatos().stream().filter(t -> t.estado == estado).collect(Collectors.toCollection(ArrayList::new));
    }
    
    
}
