package tratamientos;
import interfaces.ConsultarPrecio;

public class Ecografia implements ConsultarPrecio {

	private String tipo;
	private double precio;
	
	public Ecografia(String tipo, double precio) {
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
