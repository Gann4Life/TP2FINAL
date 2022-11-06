package usuarios;

import contacto.Mensaje;
import enums.PreferenciaContacto;

public class Contacto {
    public String email;
    public String telefono;
    public PreferenciaContacto preferenciaContacto;
    
    public Contacto(String email, String telefono, PreferenciaContacto preferenciaContacto) {
    	/*
    	 La preferencia es donde el usuario prefiere que se comuniquen con el.
    	 */
    	this.email = email;
    	this.telefono = telefono;
    	this.preferenciaContacto = preferenciaContacto;
    }

    // Envía un mensaje al usuario (desde fuera), delegando el "canal" basado en la preferencia de contacto del usuario
    public void enviarMensaje(Mensaje mensaje) {
        switch(preferenciaContacto){
            case EMAIL -> enviarAlCorreo(mensaje);
            case TELEFONO -> enviarSMS(mensaje);
        }
    }

    private void enviarAlCorreo(Mensaje mensaje) {
        // TODO: Podría extenderse a algo más
        System.out.println(" recibió un correo. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }

    private void enviarSMS(Mensaje mensaje) {
        // TODO: Podría extenderse a algo más
        System.out.println(" recibió un mensaje. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }
}
