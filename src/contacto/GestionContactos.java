package contacto;

public class GestionContactos {
    private static GestionContactos instance = null;

    private GestionContactos() {

    }

    public static GestionContactos getInstance() {
        if(instance == null)
            instance = new GestionContactos();
        return instance;
    }

    Turno pedirTurno(int idPaciente, Mensaje mensaje) {

    }

    /*
    {static} -instance: GestionContactos
    -GestionContactos

    +getInstance(): GestionContactos

    +pedirTurno(int idPaciente, contacto.Mensaje mensaje)
    +enviarMailAlUsuario(contacto.Mensaje mensaje, int idUsuario)
    +enviarSMSAlUsuario(StrMensajeing mensaje, int idUsuario)
    */
}
