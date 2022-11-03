package usuarios;

import contacto.Mensaje;

public class Contacto extends Usuario {
    public String email;
    public String telefono;
    public void enviarAlCorreo(Mensaje mensaje) {
        //TODO
        System.out.println(nombres[0] + " recibió un correo. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }

    public void enviarSMS(Mensaje mensaje) {
        // TODO
        System.out.println(nombres[0] + " recibió un mensaje. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }
}
