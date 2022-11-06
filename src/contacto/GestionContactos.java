package contacto;

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

    public static void enviarMensaJeAlUsuario(Mensaje mensaje, int id) {
        Usuario usuario = BDD.getInstance().usuarios.getDato(id);
        usuario.contacto.enviarMensaje(mensaje);
    }
}
