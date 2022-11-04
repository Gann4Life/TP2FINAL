package contacto;
import enums.EstadoTurno;
import turnos.Turno;
import database.*;
import usuarios.*;

public class GestionContactos {
    private static GestionContactos instance = null;
    private BDD baseDeDatos = BDD.getInstance();
    
    private GestionContactos() {}

    public static GestionContactos getInstance() {
        if(instance == null)
            instance = new GestionContactos();
        return instance;
    }

    public void enviarMailAlUsuario(Mensaje mensaje, int idUsuario) {
        /*
         	PROPÓSITO: Envia un mail al usuario con la id dada.
         	PRECONDICION:
         		* Debe existir un usario con la id dada.
         	PARÁMETROS:
         		* mensaje : Mensaje - El mensaje a enviarle al usuario.
         		* idUsuario : int - La id del usuario a enviar el mensaje.
        */
    	Contacto contactoDelUsuario = baseDeDatos.usuarios.getDato(idUsuario).contacto;
    	contactoDelUsuario.enviarAlCorreo(mensaje);
    }

    public void enviarSMSAlUsuario(Mensaje mensaje, int idUsuario) {
        /*
     		PROPÓSITO: Envia un SMS al usuario con la id dada.
     		PRECONDICION:
     			* Debe existir un usario con la id dada.
     		PARÁMETROS:
     			* mensaje : Mensaje - El mensaje a enviarle al usuario.
     			* idUsuario : int - La id del usuario a enviar el mensaje.
     	*/
    	Contacto contactoDelUsuario = baseDeDatos.usuarios.getDato(idUsuario).contacto;
    	contactoDelUsuario.enviarSMS(mensaje);   	
    }
}
