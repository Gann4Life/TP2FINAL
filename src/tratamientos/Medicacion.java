package tratamientos;
import interfaces.ConsultarPrecio;

public class Medicacion implements ConsultarPrecio {
	private float costo;
	private String nombre;
	public Medicacion(float costo, String nombre) {
		this.costo = costo;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getPrecio() {
		return costo;
	}
	
    //TODO: Atributos y métodos de una medicación
}
