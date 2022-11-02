package contacto;
import enums.EstadoTurno;
import turnos.Turno;

public class GestionContactos {
    private static GestionContactos instance = null;
    private GestionContactos() {}

    public static GestionContactos getInstance() {
        if(instance == null)
            instance = new GestionContactos();
        return instance;
    }

    public void enviarMailAlUsuario(Mensaje mensaje, int idUsuario) {
        //TODO: Enviar mail al usuario
    }

    public void enviarSMSAlUsuario(String mensaje, int idUsuario) {
        //TODO: Envío de SMS
    }
}
