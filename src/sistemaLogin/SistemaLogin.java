package sistemaLogin;

import database.BDD;
import enums.TipoCuenta;
import jdk.jshell.spi.ExecutionControl;
import ui.InterfazUsuario;
import usuarios.Administrativo;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.Usuario;

import java.io.IOException;
import java.util.Scanner;

public class SistemaLogin {

    public String token;

    private Scanner scanner = new Scanner(System.in);
    private int intentosDeSesion;

    private TipoCuenta tipoCuenta = TipoCuenta.INDEFINIDO;

    private static SistemaLogin instance = null;

    private SistemaLogin(){}

    public boolean intentosDeSesionExcedidos() {
        return intentosDeSesion >= 5;
    }

    public static SistemaLogin getInstance() {
        if(instance == null)
            instance = new SistemaLogin();
        return instance;
    }

    public void iniciarSesion() {
        Usuario usuario = null;
        boolean credencialesValidas = false;
        while(!credencialesValidas) {
            usuario = pedirCredencialesUsuario();
            credencialesValidas = usuario != null;
            if(!credencialesValidas) reportarCredencialiesInvalidas();
        }
        token = GestionSesiones.generarToken(usuario.getId());
        System.out.println("Sesión iniciada");
    }

    public void cerrarSesion() throws IOException {
        // TODO: Podría ser mejor
        InterfazUsuario.menuBienvenida().HandleUserOption();
        System.out.println("SESION CERRADA");
    }

    public TipoCuenta getTipoCuenta(){
        return tipoCuenta;
    }

    private TipoCuenta tipoCuentaDeUsuario(Usuario usuario) {
        if(usuario instanceof Paciente) return TipoCuenta.PACIENTE;
        if(usuario instanceof Medico) return TipoCuenta.MEDICO;
        if(usuario instanceof Administrativo) return TipoCuenta.ADMIN;

        System.out.println("El tipo de cuenta parece ser invalido.");
        return TipoCuenta.INDEFINIDO;
    }

    private void setTipoCuenta(Usuario usuario) {
        tipoCuenta = tipoCuentaDeUsuario(usuario);
        System.out.println("El tipo de cuenta ahora es " + tipoCuenta.toString());
    }

    private Usuario pedirCredencialesUsuario() {
        final Usuario usuario;
        final String username = pedirUsuario();
        final String password = pedirContrasena();

        usuario = BDD.getInstance().usuarios.getDatos().stream().filter(
                u -> u.cuit.equals(username) && u.contrasena.equals(password)
        ).findFirst().orElse(null);

        setTipoCuenta(usuario);

        return usuario;
    }

    private String pedirUsuario() {
        System.out.print("Enter username: ");
        return scanner.next();
    }
    private String pedirContrasena() {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    private void reportarCredencialiesInvalidas() {
        if(intentosDeSesionExcedidos()) {
            reportarExcesoDeSesionesInvalidas();
            return;
        }

        intentosDeSesion++;
        System.out.println("Credenciales inválidas, intento N°" + intentosDeSesion);
    }

    private void reportarExcesoDeSesionesInvalidas() {
        System.out.println("Se excedió el límite de inicios de sesión.");
        System.exit(1);
    }
}

