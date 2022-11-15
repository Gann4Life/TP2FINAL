package main;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;
import enums.Genero;
import enums.PreferenciaContacto;
import sistemaLogin.GestionSesiones;
import sistemaLogin.SistemaLogin;
import turnos.GestionTurnos;
import turnos.Turno;
import ui.InterfazUsuario;
import usuarios.Administrativo;
import usuarios.Medico;
import usuarios.Paciente;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.GregorianCalendar;

public class Application {
	
    BDD database = BDD.getInstance();
    SistemaLogin loginSystem = SistemaLogin.getInstance(); // Actually stands for "current session"

    public Application() throws IOException {
        System.out.println("Application was launched.");
        registrarCuentasDePrueba();
        registrarTurnosDePrueba();
        GestionSesiones.agregarSesion(30, "123");
        InterfazUsuario.menuPaciente().HandleUserOption();
        //InterfazUsuario.menuBienvenida().HandleUserOption();
    }

    private void registrarCuentasDePrueba() {
        Administrativo admin = new Administrativo();
        admin.cuit = "admin\";\n" +
                "        admin.contrasena = \"admin";

        Medico medico = new Medico();
        medico.cuit = "44392982";
        medico.contrasena = "1234";

        registarPacientes();

        database.usuarios.addDatos(admin, medico);
    }

    private void registarPacientes() {
        for (int i = 0; i < 32; i++) {
            Paciente paciente = new Paciente(new String[]{"Walter", "Hartwell"}, new String[]{"White"}, "", "", PreferenciaContacto.EMAIL);
            paciente.genero = Genero.TRANSGENERO;
            paciente.cuit = "4423482" + i;
            paciente.contrasena = Base64.getEncoder().encode(paciente.cuit.getBytes(StandardCharsets.UTF_8)).toString();
            database.usuarios.addDatos(paciente);
        }
    }

    private void registrarTurnosDePrueba() {
//        GestionTurnos.registrarTurno(GestionTurnos.crearTurno(2, 1));
        Turno turno = new Turno(EstadoTurno.APROBADO);
        turno.fecha = new GregorianCalendar();
        turno.especialidad = Especialidad.KINESIOLOGÍA;
        GestionTurnos.registrarTurno(turno);
    }


}
