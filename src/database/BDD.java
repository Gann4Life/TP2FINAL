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

import java.security.MessageDigest;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class BDD {

    public TablaDatos<Turno> turnos = new TablaDatos();
    public TablaDatos<Prestacion> prestaciones = new TablaDatos();
    public TablaDatos<Usuario> usuarios = new TablaDatos();
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

    public List<Medico> obtenerMedicos() {
        return (List<Medico>) usuarios.getDatos().stream().filter(o -> o instanceof Medico);
    }

    public List<Paciente> obtenerPacientes() {
        return (List<Paciente>) usuarios.getDatos().stream().filter(o -> o instanceof Paciente);
    }

    public List<Turno> turnosOcupadosPorEspecialidad(Especialidad especialidad) {
        return (List<Turno>) turnos.getDatos().stream().filter(turno -> turno.especialidad == especialidad && turno.estado == EstadoTurno.APROBADO);
    }

    public List<Integer> diasDelMes(Month mes) {

        Calendar fecha = new GregorianCalendar();
        fecha.set(fecha.get(Calendar.YEAR), mes.getValue(), fecha.get(Calendar.DATE));

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < fecha.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            result.add(i);
        }
        return result;
    }

    // 1. De una lista de turnos, filtrar por especialidad
    public List<Turno> obtenerTurnosDeEspecialidad(List<Turno> listaTurnos, Especialidad especialidad) {
        List<Turno> val = listaTurnos.stream().filter(turno -> turno.especialidad.equals(especialidad)).collect(Collectors.toList());
        return val;
    }
    // 2. De una lista de turnos, filtrar por estado (disponible/ .. )
    public List<Turno> obtenerTurnosConEstado(List<Turno> listaTurnos, EstadoTurno estado) {
        List<Turno> val = listaTurnos.stream().filter(turno -> turno.estado == estado).collect(Collectors.toList());
        return val;
    }

    // 3. De un mes, devolver la lista de turnos correspondiente
    public List<Turno> obtenerTurnosDelMes(Month mes) {
        List<Turno> val = turnos.getDatos().stream().filter(turno -> turno.obtenerValorMes() == mes.getValue()).collect(Collectors.toList());
        return val;
    }

    public List<Integer> fechasDisponiblesPorEspecialidadDelMes(Especialidad especialidad, Month mes) {
        List<Turno> filtroDeTurnos = obtenerTurnosConEstado(obtenerTurnosDeEspecialidad(obtenerTurnosDelMes(mes), especialidad), EstadoTurno.APROBADO);
        List<Integer> fechasOcupadas = filtroDeTurnos.stream().map(turno -> turno.fecha.get(Calendar.DAY_OF_MONTH)).collect(Collectors.toList());
        return diasDelMes(mes).stream().filter(d -> !fechasOcupadas.contains(d)).collect(Collectors.toList());
    }
    public List<Medico> medicosConEspecialidad(Especialidad especialidad) {
        return obtenerMedicos().stream().filter(m -> m.especialidad.equals(especialidad)).collect(Collectors.toList());
    }

    public Medico cualquierMedicoDisponible(Especialidad especialidad) {
        Random rand = new Random();
        List<Medico> medicos = medicosConEspecialidad(especialidad);
        return medicos.get(rand.nextInt(medicos.size()));
    }
}
