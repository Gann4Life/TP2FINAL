package turnos;

import enums.Especialidad;
import enums.EstadoTurno;

import java.util.Date;

public class Turno {
    public int id;
    public int idGestor;
    public int idPaciente;
    public int idLaboratorio;
    public int idConsultorio;
    public Especialidad especialidad;
    public EstadoTurno estado;

    public Date horaInicio;
    public Date horaFinalizacion;

    // Generación de sobreturno
    public Turno(Turno turno) {
    	/*
 	 	 PROPOSITO: Instancia la clase turno.
 	 	 PARÁMETROS:
 	 	 	* turno - El turno con el que se generara un sobreturno.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        idGestor = turno.idGestor;
        idPaciente = turno.idPaciente;
        idLaboratorio = turno.idGestor;
        idConsultorio = turno.idConsultorio;
        especialidad = turno.especialidad;
        horaInicio = new Date();
        //TODO: Establecer hora de finalización
        horaFinalizacion = new Date();
        setEstado(EstadoTurno.PENDIENTE);
    }

    public Turno(EstadoTurno estado) {
    	/*
 	 	 PROPOSITO: Instancia la clase turno.
 	 	 PARÁMETROS:
 	 	 	* estado - El estado en el que se encontrara el turno.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        //TODO: Probablemente incompleto
        setEstado(estado);
        horaInicio = new Date();
    }

    public void setEstado(EstadoTurno estado) {
    	/*
 	 	 PROPOSITO: Cambia el estado del turno al estado dado.
 	 	 PARÁMETROS:
 	 	 	* estado - El nuevo estado del turno.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        this.estado = estado;
    }

    public void reportarAusencia() {
    	/*
 	 	 PROPOSITO: Cambia el estado del turno a Ausente.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        estado = EstadoTurno.AUSENTE;
        //TODO: Reporte de ausencias
    }

    /*
    public Turno crearTurno(Paciente usuario, Date fechaInicio, Date fechaFin) {
        return new Turno(EstadoTurno.Pendiente);
    }*/
}