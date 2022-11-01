package main;

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

    private float costoPrestacion;

    public Prestacion(float costo) {
        costoPrestacion = costo;
    }


    public float getCostoPrestacion() {
        return costoPrestacion;
    }
}
