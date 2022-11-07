package financiacion;

public abstract class EntidadFinanciera {
    private int id;
    public int cuit;
    public int idCBU;

    public int getId() {
    	/*
 	 	 PROPOSITO: Obtiene el id de la instancia.
 	 	 PRECONDICION:
 	 	 	* El atributo id debe tener algún valor.
    	*/
        return id;
    }
}
