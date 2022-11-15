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

    public void mostrarMisDatos(){ 
        System.out.println("Nombre/s: " + nombres + "...\n" + 
        "Apellido/s: " + apellidos + "...\n" +
        "Genero: " + genero + "...\n" +
        "CUIT: " + cuit + "...\n" + 
        "Contraseña: " + contrasena + "...\n" +
        "Apellido/s: " + apellidos + "...\n" +
        "ID: " + id + "...\n"
        ); 
    }  

    public int getId() {
    	/*
 	 	 PROPOSITO: Obtiene el id del usuario.
 	 	 PRECONDICION:
 	 	 	* El id debe contener algún valor.
    	*/
        return id;
    }

}
