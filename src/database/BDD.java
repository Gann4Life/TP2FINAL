package database;

import financiacion.EntidadFinanciera;
import main.Laboratorio;
import main.Prestacion;
import turnos.Turno;
import usuarios.Paciente;
import usuarios.Usuario;

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
}
