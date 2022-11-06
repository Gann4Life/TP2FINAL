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
        //TODO: Probablemente incompleto
        setEstado(estado);
        horaInicio = new Date();
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public void reportarAusencia() {
        estado = EstadoTurno.AUSENTE;
        //TODO: Reporte de ausencias
    }

    /*
    public Turno crearTurno(Paciente usuario, Date fechaInicio, Date fechaFin) {
        return new Turno(EstadoTurno.Pendiente);
    }*/
}