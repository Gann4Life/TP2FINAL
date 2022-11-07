package contacto;

import database.*;
import usuarios.*;

public class GestionContactos {

    public static void enviarMensajeAlUsuario(Mensaje mensaje, int id) {
    	/*
   	 	 PROPOSITO: Envia un mensaje dado al usuario con el id dado.
   	 	 PARÁMETROS:
   	 	 	* mensaje - El mensaje a enviarle al usuario.
   	 	 	* id - El id del usuario a enviar el mensaje.
   	 	 PRECONDICION:
   	 	 	* El usuario con el id dado debe existir.
    	*/
        Usuario usuario = BDD.getInstance().usuarios.getDato(id);
        usuario.contacto.enviarMensaje(mensaje);
    }
}
