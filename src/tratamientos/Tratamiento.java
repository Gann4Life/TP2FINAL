package tratamientos;
import java.util.ArrayList;
import java.util.Arrays;

import interfaces.ConsultarPrecio;

public class Tratamiento implements ConsultarPrecio {
    //TODO: Atributos y métoods de un tratamiento
	private String nombre;
	private String descripcion;
	private final ArrayList<ConsultarPrecio> tratamientos = new ArrayList<>();

	public Tratamiento(String nombre, String descripcion, ConsultarPrecio ...tratamiento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		tratamientos.addAll(Arrays.asList(tratamiento));
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public double getPrecio() {
		return tratamientos.stream()
			   .mapToDouble(ConsultarPrecio::getPrecio)
			   .sum();
	}
	
}
