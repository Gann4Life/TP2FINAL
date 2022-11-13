package main;

import database.BDD;
import enums.PreferenciaContacto;
import sistemaLogin.SistemaLogin;
import ui.InterfazUsuario;
import usuarios.Administrativo;
import usuarios.Medico;
import usuarios.Paciente;

import java.io.IOException;

public class Application {
	
    BDD database = BDD.getInstance();
    SistemaLogin loginSystem = SistemaLogin.getInstance(); // Actually stands for "current session"

    public Application() throws IOException {
        System.out.println("Application was launched.");
        registrarCuentasDePrueba();
        InterfazUsuario.menuBienvenida().HandleUserOption();
    }

    private void registrarCuentasDePrueba() {
        Administrativo admin = new Administrativo();
        admin.cuit = "admin";
        admin.contrasena = "admin";

        Medico medico = new Medico();
        medico.cuit = "44392982";
        medico.contrasena = "1234";

        Paciente paciente = new Paciente(new String[]{""}, new String[]{""}, "", "", PreferenciaContacto.EMAIL);
        paciente.cuit = "44444444";
        paciente.contrasena = "4321";

        database.usuarios.addDatos(admin, medico, paciente);
    }
}
