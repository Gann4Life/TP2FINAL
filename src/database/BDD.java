package database;

import enums.Especialidad;
import enums.EstadoTurno;
import financiacion.EntidadFinanciera;
import main.Laboratorio;
import main.Prestacion;
import turnos.Turno;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.Usuario;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;

public class BDD {

    public TablaDatos<Turno> turnos = new TablaDatos();
    public TablaDatos<Prestacion> prestaciones = new TablaDatos();
    public TablaDatos<Medico> medicos = new TablaDatos();
    public TablaDatos<Paciente> pacientes = new TablaDatos();
    public TablaDatos<Laboratorio> laboratorios = new TablaDatos();
    public TablaDatos<EntidadFinanciera> idEntidadFinanciacion = new TablaDatos();

    private static BDD instance;

    private BDD() {
    }

    public static BDD getInstance() {
    	/*
 	 	 PROPOSITO: Instancia la clase BDD si no fue instanciada, y luego la devuelve.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        if(instance == null)
            instance = new BDD();
        return instance;
    }
    /*
	public List<Medico> obtenerMedicos() {
    	
        return (List<Medico>) usuarios.getDatos().stream().filter(o -> o instanceof Medico);
        
		ArrayList<Medico> medicos = new ArrayList<>();
		
		for(int i=0; i < medicos.getDatos().size(); i++) {
			if(usuarios.getDatos().get(i) instanceof Medico) {
				medicos.add((Medico) usuarios.getDatos().get(i));
			}
		}
		return medicos;
    }*/

    @SuppressWarnings("unchecked")
	private List<Turno> turnosOcupadosPorEspecialidad(Especialidad especialidad) {
        return (List<Turno>) turnos.getDatos().stream().filter(turno -> turno.especialidad == especialidad && turno.estado == EstadoTurno.APROBADO);
    }

    private List<Calendar> diasDelMes(Calendar fecha) {
        ArrayList<Calendar> result = new ArrayList<>();
        for (int i = 0; i < fecha.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            result.add(new GregorianCalendar(
                    fecha.get(Calendar.YEAR),
                    fecha.get(Calendar.MONTH),
                    i
            ));
        }
        return result;
    }
    @SuppressWarnings("unchecked")
    public List<Calendar> fechasDisponiblesPorEspecialidadDelMes(Especialidad especialidad, Calendar fecha) {


		List<Calendar> fechasOcupadas = (List<Calendar>) turnosOcupadosPorEspecialidad(especialidad).stream()
                .filter(turno -> turno.fecha.get(Calendar.MONTH) == fecha.get(Calendar.MONTH) &&
                        turno.fecha.get(Calendar.YEAR) == fecha.get(Calendar.YEAR));



        return (List<Calendar>) diasDelMes(fecha).stream().filter(calendar -> !fechasOcupadas.contains(calendar));
    }
    
    public Medico medicoConEspecialidad(Especialidad especialidad) throws Exception {
    	for(int i=0; i < medicos.getDatos().size(); i++) {
    		if(medicos.getDatos().get(i).especialidad == especialidad) {
    			return medicos.getDatos().get(i);
    		}
    	}
    	throw new Exception("No se encontro un medico con esa especialidad.");
    }
}
