package ui;

import MenuSystem.Menu;
import sistemaLogin.SistemaLogin;
import sistemaRegistro.SistemaRegistro;

public class InterfazUsuario {

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
}
