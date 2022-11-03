package database;

import java.util.ArrayList;

public class TablaDatos<T> {

    private ArrayList<T> datos = new ArrayList<>();

    public void addDato(T obj) {
        datos.add(obj);
    }

    public ArrayList<T> getDatos() {
        return datos;
    }

    public T getDato(int id) {
        return datos.get(id);
    }

    public void reemplazar(int id, T dato) {
        datos.set(id, dato);
    }

    public int cantidadDatos() {
        return datos.size();
    }

    public boolean hayDatos() {
        return !datos.isEmpty();
    }
}

