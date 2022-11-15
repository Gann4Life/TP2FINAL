package usuarios;

import database.Identificable;
import enums.Genero;

public abstract class Usuario implements Identificable {
    private int id;
    public String contrasena;
    public String[] nombres;
    public String[] apellidos;
    public Genero genero;
    public String cuit;
    public int idEntidadDeFinanciacion; 

    public Contacto contacto;

    public void mostrarMisDatos(){ 
        System.out.println("Nombre/s: " + String.join(" ", nombres) + "...\n" +
        "Apellido/s: " + String.join(" ", apellidos) + "...\n" +
        "Genero: " + genero + "...\n" +
        "CUIT: " + cuit + "...\n" + 
        "Contraseña: " + contrasena + "...\n" +
        "ID: " + id + "...\n"
        ); 
    }  

    @Override
    public int getId() {
    	/*
 	 	 PROPOSITO: Obtiene el id del usuario.
 	 	 PRECONDICION:
 	 	 	* El id debe contener algún valor.
    	*/
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
}
