import enums.Especialidad;
import usuarios.Paciente;

import java.util.Date;

public class Turno {
    public int id;
    public int idPaciente;
    public Especialidad especialidad;
    public int idLaboratorio;
    public int idConsultorio;

    public Date horaInicio;
    public Date horaFinalizacion;

    public Turno crearTurno(Paciente usuario, Date fechaInicio, Date fechaFin) {
        //TODO: Creación de turno
        return new Turno();
    }
}