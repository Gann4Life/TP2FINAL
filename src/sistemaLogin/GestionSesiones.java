package sistemaLogin;

import java.util.Random;

import database.BDD;
import usuarios.Usuario;

public class GestionSesiones {
    public static String generarToken(int id) {
    	Usuario usuario = BDD.getInstance().usuarios.getDato(id);
        return "#" + usuario.nombres[0] + codigoAleatorio();
    }
    
    private static String codigoAleatorio() {
    	Random random = new Random();
    	String codigo = "";
    	
    	for(int i=0; i < 5; i++) codigo += random.nextInt(5);

    	return codigo;
    }
}
