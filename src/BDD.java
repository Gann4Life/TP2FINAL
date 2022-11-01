import financiación.EntidadFinanciera;
import usuarios.Paciente;

import java.util.HashMap;
import java.util.Map;

public class BDD {
    public Map<Integer, Turno> turnos = new HashMap<>();
    public Map<Integer, Turno> turnosPendientes = new HashMap<>();

    public Map<Integer, Prestacion> prestaciones = new HashMap<>();
    public Map<Integer, Paciente> pacientes = new HashMap<>();
    public Map<Integer, Laboratorio> laboratorios = new HashMap<>();
    public Map<Integer, EntidadFinanciera> idEntidadDeFinanciacion = new HashMap<>();
    public Map<Integer, String> idCBU = new HashMap<>();

    public BDD(){
        //TODO: Poner a prueba la base de datos
    }
}
