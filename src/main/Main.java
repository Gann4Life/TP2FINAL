package main;

import contacto.Mensaje;
import database.BDD;
import enums.EstadoTurno;
import enums.PreferenciaContacto;
import turnos.GestionTurnos;
import turnos.Turno;
import usuarios.Administrativo;
import usuarios.Paciente;

public class Main {
    public static void main(String[] args) {

        // region [Cración de datos]
    	/*
        BDD.getInstance().usuarios.addDato(
                new Paciente(
                        new String[]{"Cristiano", "Alejandro"},
                        new String[]{"Juarez"},
                        "paciente@gmail.com",
                        "1143650312",
                        PreferenciaContacto.EMAIL
                )
        );

        GestionTurnos.registrarTurno(new Turno(EstadoTurno.PENDIENTE));
        GestionTurnos.cancelarTurno(0);
        */
        // endregion

        // region [Visualización de datos]
        // endregion
    	instanciarPacientes();
    	simulacionPedirTurno();
    }
    
    public static void simulacionPedirTurno() {
    	Paciente paciente = (Paciente)BDD.getInstance().usuarios.getDato(0);
    	Administrativo admin = paciente.pedirTurno();
    	admin.aprobarTurno(0);
    	admin.enviarMensajeAlUsuario(new Mensaje("Turno", "Su turno fue aprobado."), 0);
    	admin.cancelarTurno(0);
    	admin.enviarMensajeAlUsuario(new Mensaje("Turno", "Tuvimos que cancelar su turno"), 0);
    }
    
    public static void instanciarPacientes() {
    	instanciarPaciente(new String[] {"Luciano"},new String[] {"Garegnani"} ,"luciano@gmail.com","1165342356", PreferenciaContacto.EMAIL);
    	instanciarPaciente(new String[] {"Santiago"},new String[] {"Mansilla"},"santiago@gmail.com","1145763467", PreferenciaContacto.TELEFONO);
    	instanciarPaciente(new String[] {"Lucila"},new String[] {"Portillo"},"lucila@gmail.com","1176806733", PreferenciaContacto.TELEFONO);
    	instanciarPaciente(new String[] {"Gabriel"},new String[] {"B"},"gabriel@gmail.com","1189237843", PreferenciaContacto.EMAIL);
    	instanciarPaciente(new String[] {"Cristian"},new String[] {"Juarez"},"cristian@gmail.com","1156898005", PreferenciaContacto.EMAIL);
    }
    
    public static void instanciarPaciente(String[] nombres, String[] apellidos, String mail, String tel, PreferenciaContacto pref) {
        BDD.getInstance().usuarios.addDato(
        		new Paciente(nombres,apellidos,mail,tel,pref)
        		);
    }
    
    
}
