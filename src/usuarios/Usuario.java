package usuarios;

import enums.Genero;

public abstract class Usuario {
    private int id;
    public String contrasena;
    public String[] nombres;
    public String[] apellidos;
    public Genero genero;
    public String cuit;
    public int idEntidadDeFinanciacion;

    public Contacto contacto;



    public int getId() {
    	/*
 	 	 PROPOSITO: Obtiene el id del usuario.
 	 	 PRECONDICION:
 	 	 	* El id debe contener algún valor.
    	*/
        return id;
    }
}
