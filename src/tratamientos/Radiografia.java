package tratamientos;
import interfaces.ConsultarPrecio;

public class Radiografia implements ConsultarPrecio {

	private String tipo;
	private double precio;
	private String descripcion;
	
	public Radiografia(String tipo, double precio, String descripcion) {
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
		this.descripcion = descripcion;
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
	
	public void getDescripcion() {
		System.out.println("***");
		System.out.println("TIPO: "+ tipo);
		System.out.println("DESCRIPCION: " + descripcion);
		System.out.println("***");
		
	}

}
