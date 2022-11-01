package turnos;

import enums.Especialidad;
import enums.EstadoTurno;
import usuarios.Paciente;

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

    public Turno(EstadoTurno estado) {
        //TODO: Probablemente incompleto
        setEstado(estado);
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
        System.out.println("Nuevo estado de turno: " + estado);
    }

    /*
    public Turno crearTurno(Paciente usuario, Date fechaInicio, Date fechaFin) {
        return new Turno(EstadoTurno.Pendiente);
    }*/
}