package tratamientos;
import interfaces.ConsultarPrecio;

public class Medicacion implements ConsultarPrecio {
	private double precio;
	private String nombre;
	public Medicacion(double precio, String nombre) {
		/*
		 PROPÓSITO: Instancia la clase medicación.
		 PARÁMETROS:
		 	* nombre - El nombre de la medicación.
		 	* precio - El costo de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		/*
		 PROPÓSITO: Obtiene el nombre de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return nombre;
	}
	
	public double getPrecio() {
		/*
		 PROPÓSITO: Obtiene el preció de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return precio;
	}
	
    //TODO: Atributos y métodos de una medicación
}
