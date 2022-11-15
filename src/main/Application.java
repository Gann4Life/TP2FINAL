package main;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;
import enums.Genero;
import enums.PreferenciaContacto;
import sistemaLogin.SistemaLogin;
import turnos.GestionTurnos;
import turnos.Turno;
import ui.InterfazUsuario;
import usuarios.Administrativo;
import usuarios.Medico;
import usuarios.Paciente;

import java.io.IOException;
import java.util.GregorianCalendar;

public class Application {
	
    BDD database = BDD.getInstance();
    SistemaLogin loginSystem = SistemaLogin.getInstance(); // Actually stands for "current session"

    public Application() throws IOException {
        System.out.println("Application was launched.");
        registrarCuentasDePrueba();
        registrarTurnosDePrueba();
        InterfazUsuario.menuBienvenida().HandleUserOption();
    }

    private void registrarCuentasDePrueba() {
        Administrativo admin = new Administrativo();
        admin.cuit = "admin";
        admin.contrasena = "admin";

        Medico medico = new Medico();
        medico.cuit = "44392982";
        medico.contrasena = "1234";

        Paciente paciente = new Paciente(new String[]{"Walter", "Hartwell"}, new String[]{"White"}, "", "", PreferenciaContacto.EMAIL);
        paciente.genero = Genero.TRANSGENERO;
        paciente.cuit = "44444444";
        paciente.contrasena = "4321";

        database.usuarios.addDatos(admin, medico, paciente);
    }
    private void registrarTurnosDePrueba() {
//        GestionTurnos.registrarTurno(GestionTurnos.crearTurno(2, 1));
        Turno turno = new Turno(EstadoTurno.APROBADO);
        turno.fecha = new GregorianCalendar();
        turno.especialidad = Especialidad.KINESIOLOGÍA;
        GestionTurnos.registrarTurno(turno);
    }
}
