package usuarios;

import contacto.Mensaje;

public class Contacto {
    public String email;
    public String telefono;
    public String preferencia;
    
    public Contacto(String email, String telefono, String preferencia) {
    	/*
    	 La preferencia es donde el usuario prefiere que se comuniquen con el.
    	 */
    	this.email = email;
    	this.telefono = telefono;
    	this.preferencia = preferencia;
    }
    
    public void enviarAlCorreo(Mensaje mensaje) {
        //TODO
        System.out.println(" recibió un correo. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }

    public void enviarSMS(Mensaje mensaje) {
        // TODO
        System.out.println(" recibió un mensaje. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }
}
