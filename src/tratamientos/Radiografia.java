package tratamientos;
import interfaces.ConsultarPrecio;

public class Radiografia implements ConsultarPrecio {

	private String tipo;
	private double precio;
	
	public Radiografia(String tipo, double precio) {
		/*
		 PROPÓSITO: Instancia la clase radiografía.
		 PARÁMETROS:
		 	* tipo - El tipo de la radiografía.
		 	* precio - El precio de la radiografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public double getPrecio() {
		/*
		 PROPÓSITO: Obtiene el preció de la radiografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return precio;
	}
	
	public String getTipo() {
		/*
		 PROPÓSITO: Obtiene el tipo de la radiografía.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/	
		return tipo;
	}

}
