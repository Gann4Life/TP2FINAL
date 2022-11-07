package tratamientos;
import interfaces.ConsultarPrecio;

public class Radiografia implements ConsultarPrecio {

	private String tipo;
	private double precio;
	
	public Radiografia(String tipo, double precio) {
		this.tipo = tipo;
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getTipo() {
		return tipo;
	}

}
