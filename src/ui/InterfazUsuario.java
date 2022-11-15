package ui;

import java.util.Scanner;

import MenuSystem.Menu;
import sistemaLogin.SistemaLogin;
import sistemaRegistro.SistemaRegistro;

public class InterfazUsuario {

    public static Scanner scanner = new Scanner(System.in);

    public static Menu menuBienvenida() {
        Menu menu = new Menu("MenuBienvenida");

        menu.agregarOpcion("Iniciar Sesión", SistemaLogin.getInstance()::iniciarSesion);
        menu.agregarOpcion("Registrarse", SistemaRegistro.getInstance()::registrar);
        menu.agregarOpcion("Cerrar", () -> System.exit(1));
        

        return menu;
    }

    public static Menu menuPaciente() {
        Menu menu = new Menu("MenuPaciente");
        menu.agregarOpcion("Pedir turno", null);
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu;
    }

    public static Menu menuMedico() {
        Menu menu = new Menu("MenuMedico");
        menu.agregarOpcion("Recetar", null);
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu;
    }

    public static Menu menuAdmin() {
        Menu menu = new Menu("MenuAdmin");
        menu.agregarOpcion("Banear otaku", null);
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu;
    }

    public static Menu menuSeleccionGeneroUsuario() {
        Menu menu = new Menu("MenuGenero");
        menu.agregarOpcion("Hombre", null);
        menu.agregarOpcion("Mujer", null);
        menu.agregarOpcion("Trasgenero", null);
        menu.agregarOpcion("Otro", null);
        return menu;
    }

    public static Menu menuSeleccionEspecialidadMedico() {
        Menu menu = new Menu("MenuEspecialidad");
        menu.agregarOpcion("Cardiologia", null);
        menu.agregarOpcion("Kinesiologia", null);
        menu.agregarOpcion("Neurologia", null);
        return menu;
    }

    public static Menu menuPreferenciaContactoPaciente() {
        Menu menu = new Menu("menuPreferencia");
        menu.agregarOpcion("Email", null);
        menu.agregarOpcion("Telefono", null);
        return menu ;
    }

    public static Menu menuRegistroTipoUsuario() {
        Menu menu = new Menu("TipoUsuario") ;
        menu.agregarOpcion("medico", null);
        menu.agregarOpcion("Administrativo", null);
        menu.agregarOpcion("Paciente", null);
        return menu ;
    }

    public static String entradaDeUsuarioString(String titulo) {
        System.out.print(titulo.concat(": "));
        return scanner.next();
    }

    public static int entradaDeUsuarioInt(String titulo) {
        System.out.print(titulo.concat(": "));
        return scanner.nextInt();
    }
}
