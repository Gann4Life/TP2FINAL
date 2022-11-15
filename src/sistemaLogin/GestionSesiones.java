package sistemaLogin;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import database.BDD;

public class GestionSesiones {
	
	private static HashMap<Integer, String> sesiones = new HashMap<Integer, String>();
	
	public static String aleatorio() {
		return "2";
	}
	
    public static String generarToken(int id) {
    	String cuil = BDD.getInstance().usuarios.getDato(id).cuit.concat(aleatorio());
        return Integer.toString(cuil.hashCode());
    }
    
    public static void agregarSesion(int id, String token) {
    	sesiones.put(id, token);
    }
    
}
