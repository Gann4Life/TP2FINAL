package ui;

import java.time.Month;
import java.util.Scanner;

import database.BDD;
import turnos.MenuSystem.Menu;
import sistemaLogin.SistemaLogin;
import sistemaRegistro.SistemaRegistro;
import sistemaLogin.GestionSesiones;
import usuarios.Paciente;

public class InterfazUsuario {

    public static Scanner scanner = new Scanner(System.in);

    public static Menu menuBienvenida() {
        Menu menu = new Menu("MenuBienvenida");

        menu.agregarOpcion("Iniciar Sesión", SistemaLogin.getInstance()::iniciarSesion);
//        menu.agregarOpcion("Registrarse", SistemaRegistro.getInstance()::registrar);
        menu.agregarOpcion("Cerrar", () -> System.exit(1));
        
        return menu; 
    } 

    public static Menu menuPaciente() { 
        Menu menu = new Menu("MenuPaciente");
        menu.agregarOpcion("Pedir turno", () -> { ;}); //solicita un turno nuevo
        menu.agregarOpcion("Mis datos", () -> GestionSesiones.mostrarMisDatos());
        menu.agregarOpcion("Ver historial médico", null);//ve los diagnosticos que se le hicieron
        menu.agregarOpcion("Ver historial de turnos", null);//ve una lista de turnos los cuales indican su estado e información(se puede utilizar idealmente para ver si hay un turno en estado pendiente)
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);//cierra la sesión actual de usuario.
        return menu; 
    }

    public static Menu menuMedico() { 
        Menu menu = new Menu("MenuMedico");
        menu.agregarOpcion("Mis datos", () -> GestionSesiones.mostrarMisDatos());  
        menu.agregarOpcion("Ver historial de pacientes", null); 
        menu.agregarOpcion("", null); 
        menu.agregarOpcion("Recetar", null); 
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu; 
    }

    public static Menu menuAdmin() {
        Menu menu = new Menu("MenuAdmin"); 
        menu.agregarOpcion("Mis datos", () -> GestionSesiones.mostrarMisDatos()); 
        menu.agregarOpcion("Crear turno", () -> GestionSesiones.crearTurno());
        menu.agregarOpcion("Actualizar un turno", null);
        menu.agregarOpcion("Eliminar un turno", null);
        menu.agregarOpcion("Ver historial de turnos", null);
        menu.agregarOpcion("Enviar aviso de ausencias consecutivas", null);
        menu.agregarOpcion("Crear Sobreturno", null);
        menu.agregarOpcion("Ver datos de paciente: ", null);
        menu.agregarOpcion("Ver datos de tratamientos", null);
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu;
    }

    public static Menu menuRequerirPaciente() {
        Menu menu = new Menu("Seleccionar paciente");
        menu.agregarOpcion("Buscar en registro", null);
        menu.agregarOpcion("Registrar paciente nuevo", SistemaRegistro.getInstance()::registrarPaciente);
        return menu;
    }

    public static int menuPacienteRequerido() {
        Menu menu = new Menu("SeleccionarPaciente");
        for(Paciente paciente : BDD.getInstance().obtenerPacientes()) {
            menu.agregarOpcion(paciente.nombres[0], () -> System.out.println("Me llamo " + paciente.nombres[0]));
        }
        return menu.handleOption();
    }

    public static Menu menuSeleccionDeMes() {
        Menu menu = new Menu("Mes");
        for (int i = 0; i < Month.values().length; i++) {
            menu.agregarOpcion(Month.values()[i].toString(), null);
        }
        return menu;
    }

    public static Menu menuCrearTurno() {
        Menu menu = new Menu("Crear turno");
        menu.agregarOpcion("", null);
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