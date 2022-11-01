package financiacion;

public class GestionFinanciera {
    private static GestionFinanciera instance;

    private GestionFinanciera() {}

    public static GestionFinanciera getInstance() {
        if(instance == null)
            instance = new GestionFinanciera();
        return instance;
    }

    public void abonarPrestacion(int idPrestacion) {
        //TODO: Abonar prestación
    }
}
