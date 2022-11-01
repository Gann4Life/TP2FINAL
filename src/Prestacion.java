import enums.EstadoFinanciero;

import java.util.List;

public class Prestacion {
    public int idMedicoACargo;
    public int idPaciente;
    public Diagnostico diagnostico;
    public boolean asistencia;
    public EstadoFinanciero estado;
    public List<Tratamiento> tratamientosAsignados;
    public List<Medicacion> medicacionAsignada;
    public List<Estudio> estudiosRealizados;

    public float costoDePrestacion() {
        //TODO: Establecer precio de prestación
        return 0;
    }
}
