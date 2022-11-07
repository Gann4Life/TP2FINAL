package usuarios;

import contacto.Mensaje;
import enums.PreferenciaContacto;

public class Contacto {
    public String email;
    public String telefono;
    public PreferenciaContacto preferenciaContacto;
    
    public Contacto(String email, String telefono, PreferenciaContacto preferenciaContacto) {
    	/*
 	 	 PROPOSITO: Instancia la clase contacto.
 	 	 PARÁMETROS:
 	 	 	* email - El email de contacto.
 	 	 	* telefono - El telefono de contacto.
 	 	 	* preferencia - La preferencia de contacto.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
    	this.email = email;
    	this.telefono = telefono;
    	this.preferenciaContacto = preferenciaContacto;
    }

    // 
    public void enviarMensaje(Mensaje mensaje) {
    	/*
 	 	 PROPOSITO: Envía un mensaje al usuario (desde fuera), delegando el 
 	 	 			"canal" basado en la preferencia de contacto del usuario
 	 	 PARÁMETROS:
 	 	 	* mensaje - Mensaje a enviar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        switch(preferenciaContacto){
            case EMAIL -> enviarAlCorreo(mensaje);
            case TELEFONO -> enviarSMS(mensaje);
        }
    }

    private void enviarAlCorreo(Mensaje mensaje) {
    	/*
 	 	 PROPOSITO: Envia un correo con el mensaje dado.
 	 	 PARÁMETROS:
 	 	 	* mensaje - El mensaje a enviar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        // TODO: Podría extenderse a algo más
        System.out.println(" recibió un correo. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }

    private void enviarSMS(Mensaje mensaje) {
    	/*
 	 	 PROPOSITO: Envia un sms con el mensaje dado.
 	 	 PARÁMETROS:
 	 	 	* mensaje - El mensaje a enviar.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        // TODO: Podría extenderse a algo más
        System.out.println(" recibió un mensaje. \nTITULO: " + mensaje.getTitulo() + "\nDESCRIPCION: " + mensaje.getDescripcion());
    }
}
