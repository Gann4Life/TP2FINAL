package sistemaLogin;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import database.BDD;

public class GestionSesiones {
	public static String token;
    
	private static HashMap<String, Integer> sesiones = new HashMap<String, Integer>();//id interger, token String
	
	public static String aleatorio() {
		return "2";
	}
	
    public static String generarToken(int id) {
    	String cuil = BDD.getInstance().usuarios.getDato(id).cuit.concat(aleatorio());
        return Integer.toString(cuil.hashCode());
    }
    
    public static void agregarSesion(int id, String token) {
    	sesiones.put(token, id);
    }

    public Boolean validarToken(String token){ 
        return(sesiones.containsKey(token));
    }

    public static void mostrarMisDatos(){ 
        BDD.getInstance().usuarios.getDato(sesiones.get(token)).mostrarMisDatos();
    }
    
}
