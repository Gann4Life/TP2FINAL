package contacto;

import java.util.Date;

public class Mensaje {
    private String titulo;
    private String descripcion;
    private Date fechaEnvio;

    public Mensaje(String titulo, String description) {
    	/*
  	 	 PROPOSITO: Instancia la clase mensaje.
  	 	 PARÁMETROS:
  	 	 	* titulo - El titulo del mensaje.
  	 	 	* description - La descripción del mensaje.
  	 	 PRECONDICION:
  	 	 	* Ninguna.
    	*/
        this.titulo = titulo;
        this.descripcion = description;
        fechaEnvio = new Date();
    }

    public String getTitulo() {
    	/*
 	 	 PROPOSITO:
 	 	 PRECONDICION:
    	*/
        return titulo;
    }

    public String getDescripcion() {
    	/*
 	 	 PROPOSITO:
 	 	 PRECONDICION:
    	*/
        return descripcion;
    }

    public Date getFechaEnvio() {
    	/*
 	 	 PROPOSITO:
 	 	 PRECONDICION:
    	*/
        return fechaEnvio;
    }
}
