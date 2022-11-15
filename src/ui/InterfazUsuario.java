package ui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

import database.BDD;
import enums.Especialidad;
import main.RandomDateOfBirth;
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
        menu.agregarOpcion("Ver historial médico", () -> {
            mostrarHistorialMédico();
            menuPaciente().HandleUserOption();
        });//ve los diagnosticos que se le hicieron
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
        menu.agregarOpcion("Ver datos de paciente: ", () -> {
            mostrarTodosLosPacientes();
            menuAdmin().HandleUserOption();
        });
        menu.agregarOpcion("Ver datos de tratamientos", null);
        menu.agregarOpcion("Cerrar sesion", SistemaLogin.getInstance()::cerrarSesion);
        return menu;
    }

    private static void mostrarTodosLosPacientes() throws IOException {
        Menu menu = new Menu("");
        for(Paciente paciente : BDD.getInstance().obtenerPacientes()) {
            menu.agregarOpcion(paciente.cuit, () -> paciente.mostrarMisDatos());
        }
        menu.HandleUserOption();
    }

    private static void mostrarHistorialMédico() throws IOException {

        Paciente paciente = BDD.getInstance().obtenerPacientes().get(RandomDateOfBirth.randBetween(0, BDD.getInstance().obtenerPacientes().size()));

        for (int i = 0; i < RandomDateOfBirth.randBetween(0, 6); i++) {
            System.out.println("--------------------------");
            RandomDateOfBirth.mostrarFechaAleatoria(22, 46);
            Random rand = new Random();
            System.out.println(paciente.cuit + " asistió a " + Especialidad.values()[rand.nextInt(Especialidad.values().length)] + "\n");
        }
    }

    public static Menu menuRequerirPaciente() {
        Menu menu = new Menu("Seleccionar paciente");
        menu.agregarOpcion("Buscar en registro", null);
        menu.agregarOpcion("Registrar paciente nuevo", SistemaRegistro.getInstance()::registrarPaciente);
        return menu;
    }

    public static Menu menuPacienteRequerido() {
        BDD database = BDD.getInstance();
        Menu menu = new Menu("SeleccionarPaciente");
        for(Paciente paciente : database.obtenerPacientes()) {
            menu.agregarOpcion(paciente.cuit, null);
        }
        return menu;
    }

    public static Month menuSeleccionDeMes() {
        Menu menu = new Menu("Mes");
        menu.setCols(2);
        for (int i = 0; i < Month.values().length; i++) {
            menu.agregarOpcion(Month.values()[i].toString(), null);
        }
        return Month.values()[menu.handleOption()];
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

    public static Especialidad menuSeleccionEspecialidadMedico() {
        Menu menu = new Menu("MenuEspecialidad");
        menu.agregarOpcion("Cardiologia", null);
        menu.agregarOpcion("Kinesiologia", null);
        menu.agregarOpcion("Neurologia", null);
        return Especialidad.values()[menu.handleOption()];
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

    public static Calendar menuFechaRequerida() {
        BDD database = BDD.getInstance();
        Month mesSeleccionado = menuSeleccionDeMes();

        Menu menu = new Menu("SeleccionarFecha");
        menu.setCols(4);
        for(Integer diaDelMes : database.fechasDisponiblesPorEspecialidadDelMes(menuSeleccionEspecialidadMedico(), mesSeleccionado)) {
            menu.agregarOpcion(diaDelMes.toString(), null);
        }

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_MONTH, menu.handleOption());
        cal.set(Calendar.AM_PM, 1);
        cal.set(Calendar.MONTH, mesSeleccionado.getValue() -1);
        cal.set(Calendar.HOUR, menuHoraSeleccionada().handleOption());
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        //System.out.println("CAL GENERATED: " + cal.getTime(sdf));

        return cal;
    }

    public static Menu menuHoraSeleccionada(){
        Menu menu = new Menu("Selecciona Horario");
        menu.setCols(4);
        for (int i = 1; i <= 24; i++) {
            menu.agregarOpcion(Integer.toString(i) + ":00hs", null);
        }
        return menu;
    }
}