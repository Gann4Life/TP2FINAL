package tratamientos;
import interfaces.ConsultarPrecio;

public class Medicacion implements ConsultarPrecio {
	private double precio;
	private String tipo;
	private String descripcion;
	public Medicacion(double precio, String tipo, String descripcion) {
		/*
		 PROPÓSITO: Instancia la clase medicación.
		 PARÁMETROS:
		 	* nombre - El nombre de la medicación.
		 	* precio - El costo de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	public String getTipo() {
		/*
		 PROPÓSITO: Obtiene el nombre de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return tipo;
	}
	
	public double getPrecio() {
		/*
		 PROPÓSITO: Obtiene el preció de la medicación.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return precio;
	}
	
	public void getDescripcion() {
		System.out.println("***");
		System.out.println("TIPO: "+ tipo);
		System.out.println("DESCRIPCION: " + descripcion);
		System.out.println("***");
		
	}
	
    //TODO: Atributos y métodos de una medicación
}
