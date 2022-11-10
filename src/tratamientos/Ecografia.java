package tratamientos;
import interfaces.ConsultarPrecio;

public class Ecografia implements ConsultarPrecio {

	private String tipo = "";
	private double precio;
	private String descripcion = "";
	
	public Ecografia(String tipo, double precio, String descripcion) {
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
		this.descripcion = descripcion;
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
	

	@Override
	public void getDescripcion() {
		System.out.println("***");
		System.out.println("TIPO: "+ tipo);
		System.out.println("DESCRIPCION: " + descripcion);
		System.out.println("***");
		
	}
	
}
