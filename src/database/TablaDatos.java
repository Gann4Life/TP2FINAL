package database;

import java.util.ArrayList;

public class TablaDatos<T> {

    private ArrayList<T> datos = new ArrayList<>();

    public void addDatos(T... obj) {
        // Agrega datos a la tabla a través de una cantidad indefinida de argumentos
        for(T o : obj)
            addDato(o);
    }

    public void addDato(T obj) {
    	/*
 	 	 PROPOSITO: Agrega un dato dado al atributo datos.
 	 	 PARÁMETROS:
 	 	 	* obj - El dato a agregar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        if(obj == null) throw new RuntimeException("No se puede agregar un elemento nulo como dato.");

        try {
            asignarID((Identificable) obj);
        } catch (ClassCastException e) {
            System.out.println("El objeto no es identificable.");
        }

        datos.add(obj);
    }

    private void asignarID(Identificable identificable) {
        identificable.setId(datos.size());
        System.out.println("El ID " + identificable.getId() + " FUE ASIGNADO EN LA TABLA");
    }

    public ArrayList<T> getDatos() {
    	/*
 	 	 PROPOSITO: Obtiene los datos del atributo datos.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return datos;
    }

    public T getDato(int id) {
    	/*
 	 	 PROPOSITO: Obtiene el dato con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del dato a obtener.
 	 	 PRECONDICION:
 	 	 	* El dato con el id dado debe existir.
    	*/
        return datos.get(id);
    }

    public void reemplazar(int id, T dato) {
    	/*
 	 	 PROPOSITO: Reemplaza el dato con el id dado por el dato dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del dato a ser reemplazado.
 	 	 	* dato - El dato nuevo a reemplazar.
 	 	 PRECONDICION:
 	 	 	* El dato con el id dado debe existir.
    	*/
        datos.set(id, dato);
    }

    public int cantidadDatos() {
    	/*
 	 	 PROPOSITO: Describe la cantidad de datos que contiene el atributo datos.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return datos.size();
    }

    public boolean hayDatos() {
    	/*
 	 	 PROPOSITO: Indica si hay datos en el atributos dattos.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return !datos.isEmpty();
    }
    public int idDeDato(T dato) {
        return datos.indexOf(dato);
    }
    public boolean existeDato(T dato) {
        return datos.contains(dato);
    }
}

