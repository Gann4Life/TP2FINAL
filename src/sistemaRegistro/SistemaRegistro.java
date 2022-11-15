package sistemaRegistro;

import database.BDD;
import enums.Especialidad;
import enums.Genero;
import enums.PreferenciaContacto;
import ui.InterfazUsuario;
import usuarios.Administrativo;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.Usuario;

import java.io.IOException;


public class SistemaRegistro {
    private static SistemaRegistro instance = null ;
    private SistemaRegistro(){}

    public static SistemaRegistro getInstance() {
        if(instance == null)
            instance = new SistemaRegistro();
        return instance;
    }
    
//    public void registrar() throws IOException{
//        Usuario usuario = crearCuenta() ;
//        BDD.getInstance().usuarios.addDato(usuario);
//        System.out.println("Registrado con exito");
//        InterfazUsuario.menuBienvenida().HandleUserOption();
//    }

//    private Usuario crearCuenta() throws IOException {
//        Usuario usuario = null ;
//        String cuit = null ;
//        try {
//            cuit = ingresoCuit();
//        } catch(Exception e) {
//            System.out.println(e.getMessage());
//            InterfazUsuario.menuBienvenida().HandleUserOption();
//        }
//        usuario = switch(InterfazUsuario.menuRegistroTipoUsuario().handleOption()){
//            case 0 -> crearMedico() ;
//            case 1 -> crearAdministrativo();
//            default -> crearPaciente() ;
//        } ;
//        usuario.cuit = cuit ;
//        usuario.genero = definiGenero() ;
//        usuario.contrasena = crearContrasenna() ;
//
//        return usuario ;
//    }

    public void registrarPaciente() {
        String cuit = InterfazUsuario.entradaDeUsuarioString("CUIT");
//        String apellidos = InterfazUsuario.entradaDeUsuarioString("Apellido") ;
        String email = InterfazUsuario.entradaDeUsuarioString("Mail") ;
//        String telefono = InterfazUsuario.entradaDeUsuarioString("Telefono") ;
        PreferenciaContacto preferencia = switch(InterfazUsuario.menuPreferenciaContactoPaciente().handleOption()){
            case 0 -> PreferenciaContacto.EMAIL;
            default -> PreferenciaContacto.TELEFONO;
        } ;
        Paciente paciente = new Paciente(cuit.split(" "), "".split(" "), email, "", preferencia) ;
        BDD.getInstance().usuarios.addDato(paciente);
        System.out.println("Paciente registrado");
    }
    
    private Administrativo crearAdministrativo(){
        Administrativo admin = new Administrativo() ;
        admin.nombres = InterfazUsuario.entradaDeUsuarioString("Nombre").split(" ") ;
        admin.apellidos = InterfazUsuario.entradaDeUsuarioString("Apellido").split(" ") ;
        return admin ;
    }

    private Medico crearMedico(){
        Medico medico = new Medico() ;
        medico.nombres = InterfazUsuario.entradaDeUsuarioString("Nombre").split(" ") ;
        medico.apellidos = InterfazUsuario.entradaDeUsuarioString("Apellido").split(" ") ;
        medico.especialidad = switch(InterfazUsuario.menuSeleccionEspecialidadMedico().handleOption()){
            case 0 -> Especialidad.CARDIOLOGÍA ;
            case 1 ->  Especialidad.KINESIOLOGÍA ;
            default ->  Especialidad.NEUROLOGÍA ;
        } ;
        return medico ;
    }

    private String crearContrasenna() {
        String contrasenna = InterfazUsuario.entradaDeUsuarioString("Introducir Contraseña") ;
        String control = InterfazUsuario.entradaDeUsuarioString("volver introducir Contraseña");
        if(!contrasenna.equals(control)){
            System.out.println("invalido, Reintentar contraseña");
            return crearContrasenna() ;
        } 
        return (String) contrasenna ;
    }

    private Genero definiGenero() {
        return switch (InterfazUsuario.menuSeleccionGeneroUsuario().handleOption()) {
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
        String cuit = String.valueOf(InterfazUsuario.entradaDeUsuarioInt("Cuit"));
        if(existeCuit(cuit)) throw new IOException("Ya existe usuario") ;
        return cuit ;
    }
}
