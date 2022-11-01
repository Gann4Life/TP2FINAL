package database;

import java.util.ArrayList;

public class TablaDatos {

    private ArrayList<Object> datos = new ArrayList<>();

    public void addDato(Object obj) {
        datos.add(obj);
    }

    public ArrayList<Object> getDatos() {
        return datos;
    }

    public Object getDato(int id) {
        return datos.get(id);
    }

    public void reemplazar(int id, Object dato) {
        datos.set(id, dato);
    }
}

