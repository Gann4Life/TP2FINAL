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
        InterfazUsuario.menuBienvenida().HandleUserOption(); ;
    }

    private Usuario crearCuenta() {
        Usuario usuario = null ;
        System.out.println("crear cuenta tipo 1.Paciente 2.Administrador 3.Medico");
        
        switch(scanner.nextInt()){
            case 1 -> usuario = crearPaciente() ;
            case 2 -> usuario = crearAdministrativo();
            case 3 -> usuario = crearMedico() ; 
            default -> System.out.println("error, vuelve a repetir");
        }
        
        System.out.println("Cuit");
        usuario.cuit = scanner.next();
        usuario.genero = definiGenero() ;
        usuario.contrasena = crearContrasenna() ;

        return usuario ;
    }

    private Paciente crearPaciente(){
        System.out.println("nombres");
        String[] nombres = scanner.next().split(" ") ;
        System.out.println("apellidos");
        String[] apellidos = scanner.next().split(" ") ;
        System.out.println("email");
        String email = scanner.next() ;
        System.out.println("telefono");
        String telefono = scanner.next() ;
        System.out.println("preferencia de contacto 1.email 2.telefono");
        PreferenciaContacto preferencia = null ; 
        switch(scanner.nextInt()){
            case 1 -> preferencia = PreferenciaContacto.EMAIL;
            case 2 -> preferencia = PreferenciaContacto.TELEFONO;
        }
        return new Paciente(nombres, apellidos, email, telefono, preferencia ) ; 
    }
    
    private Administrativo crearAdministrativo(){
        Administrativo admin = new Administrativo() ;
        System.out.println("nombres");
        admin.nombres = scanner.next().split(" ") ;
        System.out.println("apellidos");
        admin.apellidos = scanner.next().split(" ") ;
        return admin ;
    }

    private Medico crearMedico(){
        Medico medico = new Medico() ;
        System.out.println("nombres");
        medico.nombres = scanner.next().split(" ") ;
        System.out.println("apellidos");
        medico.apellidos = scanner.next().split(" ") ;
        System.out.println("eliga su especialidad 1.Cardiología 2.Kinesiología 3.Neurología");
        switch(scanner.nextInt()){
            case 1 -> medico.especialidad = Especialidad.CARDIOLOGÍA ;
            case 2 -> medico.especialidad = Especialidad.KINESIOLOGÍA ;
            case 3 -> medico.especialidad = Especialidad.NEUROLOGÍA ;
        }
        return medico ;
    }

    private String crearContrasenna() {
        String contrasenna ;
        System.out.println("Introducir contraseña");
        contrasenna = scanner.next() ;
        System.out.println("volve introducir contraseña");
        String control = scanner.next();
        while(!contrasenna.equals(control)){
            System.out.println("invalido, vuelve a introducir contraseña");
            control = scanner.next() ;
        } 
        return (String) contrasenna ;
    }

    private Genero definiGenero() {
        Genero genero = null ;
        System.out.println("Genero 1.Masculino 2.Femenino 3.Trans 4.Otro");
        switch (scanner.nextInt()) {
            case 1 -> genero = Genero.MASCULINO ;
            case 2 -> genero = Genero.FEMENINO ;
            case 3 -> genero = Genero.TRANSGENERO ;
            default -> genero = Genero.OTRO ;
        }
        return genero ;
    }

}
