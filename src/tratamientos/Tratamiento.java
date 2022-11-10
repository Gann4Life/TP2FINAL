package tratamientos;
import java.util.ArrayList;
import java.util.Arrays;

import interfaces.ConsultarPrecio;

public class Tratamiento implements ConsultarPrecio {
    //TODO: Atributos y métoods de un tratamiento
	private String nombre;
	private String descripcion;
	private final ArrayList<ConsultarPrecio> tratamientos = new ArrayList<>();

	public Tratamiento(ConsultarPrecio ...tratamiento) {
		/*
		 PROPÓSITO: Instancia la clase radiografía.
		 PARÁMETROS:
		 	* nombre - El nombre del tratamiento.
		 	* descripcion - La descripción del tratamiento.
		 	* tratamiento - Los tratamientos diagnosticados.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		tratamientos.addAll(Arrays.asList(tratamiento));
	}
	
	public String getNombre() {
		/*
		 PROPÓSITO: Obtiene el nombre del tratamiento.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return nombre;
	}
	
	public void getDescripcion() {
		/*
		 PROPÓSITO: Obtiene la descripción del tratamiento.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		for(int i=0; i < tratamientos.size(); i++) {
			tratamientos.get(i).getDescripcion();
		}
	}
	
	public double getPrecio() {
		/*
		 PROPÓSITO: Obtiene el preció del tratamiento.
		 PRECONDICIÓN:
		 	* Ninguna.
		*/
		return tratamientos.stream()
			   .mapToDouble(ConsultarPrecio::getPrecio)
			   .sum();
	}
	
}
