package sistemaRegistro;

import database.BDD;
import enums.Especialidad;
import enums.Genero;
import enums.PreferenciaContacto;
import enums.TipoCuenta;
import jdk.jshell.spi.ExecutionControl;
import ui.InterfazUsuario;
import usuarios.*;

import java.io.IOException;
import java.util.Scanner;


public class SistemaRegistro {
    private Scanner scanner = new Scanner(System.in) ;

    private static SistemaRegistro instance = null ;
    private SistemaRegistro(){}

    public static SistemaRegistro getInstance() {
        if(instance == null)
            instance = new SistemaRegistro();
        return instance;
    }
    
    public void registrar() throws IOException{
        Usuario usuario = crearCuenta() ;
        BDD.getInstance().usuarios.addDato(usuario); 
        System.out.println("Registrado con exito");
        InterfazUsuario.menuBienvenida().HandleUserOption(); 
    }

    private Usuario crearCuenta() throws IOException {
        Usuario usuario = null ;
        String cuit = null ;
        try {
            cuit = ingresoCuit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            InterfazUsuario.menuBienvenida().HandleUserOption();
        } 
        usuario = switch(InterfazUsuario.menuTipoUsuario().handleOption()){
            case 0 -> crearMedico() ;
            case 1 -> crearAdministrativo();
            default -> crearPaciente() ; 
        } ;
        usuario.cuit = cuit ;
        usuario.genero = definiGenero() ;
        usuario.contrasena = crearContrasenna() ;

        return usuario ;
    }

    private Paciente crearPaciente(){
        String nombres = InterfazUsuario.userInput("nombre") ;
        String apellidos = InterfazUsuario.userInput("Apellido") ;
        String email = InterfazUsuario.userInput("Mail") ;
        String telefono = InterfazUsuario.userInput("Telefono") ;
        PreferenciaContacto preferencia = switch(InterfazUsuario.menuPreferencia().handleOption()){
            case 0 -> PreferenciaContacto.EMAIL;
            default -> PreferenciaContacto.TELEFONO;
        } ;
        return new Paciente(nombres.split(" "), apellidos.split(" "), email, telefono, preferencia) ; 
    }
    
    private Administrativo crearAdministrativo(){
        Administrativo admin = new Administrativo() ;
        admin.nombres = InterfazUsuario.userInput("Nombre").split(" ") ;
        admin.apellidos = InterfazUsuario.userInput("Apellido").split(" ") ;
        return admin ;
    }

    private Medico crearMedico(){
        Medico medico = new Medico() ;
        medico.nombres = InterfazUsuario.userInput("Nombre").split(" ") ;
        medico.apellidos = InterfazUsuario.userInput("Apellido").split(" ") ;
        medico.especialidad = switch(InterfazUsuario.menuEspecialidad().handleOption()){
            case 0 -> Especialidad.CARDIOLOGÍA ;
            case 1 ->  Especialidad.KINESIOLOGÍA ;
            default ->  Especialidad.NEUROLOGÍA ;
        } ;
        return medico ;
    }

    private String crearContrasenna() {
        String contrasenna = InterfazUsuario.userInput("Introducir Contraseña") ;
        String control = InterfazUsuario.userInput("volver introducir Contraseña");
        if(!contrasenna.equals(control)){
            System.out.println("invalido, Reintentar contraseña");
            return crearContrasenna() ;
        } 
        return (String) contrasenna ;
    }

    private Genero definiGenero() {
        return switch (InterfazUsuario.menuGenero().handleOption()) {
            case 0 -> Genero.MASCULINO ;
            case 1 -> Genero.FEMENINO ;
            case 2 -> Genero.TRANSGENERO ;
            default -> Genero.OTRO ;
        } ;
    }

    private boolean existeCuit(String cuit){
        return BDD.getInstance().usuarios.getDatos().stream().anyMatch(u -> u.cuit.equals(cuit)) ;
    }

    private String ingresoCuit() throws IOException{
        System.out.println("Cuit");
        String cuit = String.valueOf(scanner.nextInt());
        System.out.println(existeCuit(cuit));
        if(existeCuit(cuit)) throw new IOException("Ya existe usuario") ;
        return cuit ;
    }
}
