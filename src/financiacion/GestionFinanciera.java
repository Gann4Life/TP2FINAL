package financiacion;

import database.BDD;

public class GestionFinanciera {
    private static GestionFinanciera instance = null;

    private GestionFinanciera() {}

    public static GestionFinanciera getInstance() {
        if(instance == null)
            instance = new GestionFinanciera();
        return instance;
    }

    public void abonarPrestacion(int idPrestacion) {
        //TODO: Abonar prestación
        //BDD.getInstance().prestaciones.addDato();
    }
}
