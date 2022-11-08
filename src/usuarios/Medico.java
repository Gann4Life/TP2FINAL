package usuarios;

import enums.Especialidad;
import enums.EstadoFinanciero;
import jdk.jshell.spi.ExecutionControl;
import main.Diagnostico;
import main.Estudio;
import tratamientos.Medicacion;
import tratamientos.Tratamiento;

import java.util.List;

public class Medico extends Usuario {
    public int idMedicoACargo;
    public int idPaciente;
    public Diagnostico diagnostico;
    public boolean asistencia;
    public EstadoFinanciero estadoFinanciero;
    public Especialidad especialidad;

    public List<Tratamiento> tratamientosAsignados;
    public List<Medicacion> medicacionAsignada;
    public List<Estudio> estudiosRealizados;

    public float costoDePrestacion() throws ExecutionControl.NotImplementedException {
    	/*
 	 	 PROPOSITO: Describe el costo de la prestación.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        //TODO: Definir costo de prestación
        throw new ExecutionControl.NotImplementedException("La función todavía no fue implementada.");
    }
}
