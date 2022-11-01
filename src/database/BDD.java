package database;

public class BDD {

    public TablaDatos turnos = new TablaDatos();
    public TablaDatos turnosPendientes = new TablaDatos();

    public TablaDatos prestaciones = new TablaDatos();
    public TablaDatos pacientes = new TablaDatos();
    public TablaDatos laboratorios = new TablaDatos();
    public TablaDatos idEntidadFinanciacion = new TablaDatos();
    public TablaDatos idCBU = new TablaDatos();

    private static BDD instance;

    private BDD(){
        //TODO: Poner a prueba la base de datos
    }

    public static BDD getInstance() {
        if(instance == null)
            instance = new BDD();
        return instance;
    }
}
