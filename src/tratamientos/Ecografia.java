package tratamientos;
import interfaces.ConsultarPrecio;

public class Ecografia implements ConsultarPrecio {

	private String tipo;
	private double precio;
	
	public Ecografia(String tipo, double precio) {
		/*
		 PROPÓSITO: Instancia la clase ecografía.
		 PARÁMETROS:
		 	* tipo - El tipo de la ecografía.
		 	* precio - El precio de la ecografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public double getPrecio() {
		/*
		 PROPÓSITO: Obtiene el preció de la ecografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return precio;
	}
	
	public String getTipo() {
		/*
		 PROPÓSITO: Obtiene el tipo de la ecografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/		
		return tipo;
	}
	
}
