package sistemaLogin;

import java.io.IOException;
import java.time.Month;
import java.util.*;

import turnos.MenuSystem.Menu;
import database.BDD;
import enums.Especialidad;
import turnos.GestionTurnos;
import ui.InterfazUsuario;

public class GestionSesiones {
	public static String token;
    
	private static HashMap<String, Integer> sesiones = new HashMap<String, Integer>();//id interger, token String
	
	public static String aleatorio() {
		return "2";
	}
	
    public static void generarToken(int id) {
    	String cuil = BDD.getInstance().usuarios.getDato(id).cuit.concat(aleatorio());
        token = Integer.toString(cuil.hashCode());
        agregarSesion(id, token);
    }
    
    public static void agregarSesion(int id, String token) {
    	sesiones.put(token, id);
    }

	public static void crearTurno() throws IOException {

        if(validarToken(token)) {
            final int diaSeleccionado;
            final int seleccionEspecialidad = InterfazUsuario.menuSeleccionEspecialidadMedico().handleOption()+1;
            final Month mesSeleccionado = Month.values()[InterfazUsuario.menuSeleccionDeMes().handleOption()];
            final Especialidad especialidadSeleccionada = Especialidad.values()[seleccionEspecialidad];

            List<Integer> days = switch (seleccionEspecialidad) {
                case 0 -> BDD.getInstance().fechasDisponiblesPorEspecialidadDelMes(Especialidad.CARDIOLOGÍA, mesSeleccionado);
                case 1 -> BDD.getInstance().fechasDisponiblesPorEspecialidadDelMes(Especialidad.NEUROLOGÍA, mesSeleccionado);
                default -> BDD.getInstance().fechasDisponiblesPorEspecialidadDelMes(Especialidad.KINESIOLOGÍA, mesSeleccionado);
            };

            // Amazing day selection menu
            Menu menu = new Menu("Selecciona un día");
            menu.setCols(4);
            for(Integer day : days)
                menu.agregarOpcion(mesSeleccionado + " del " + String.format("%02d", day), null);
            menu.agregarOpcion("Retroceder", GestionSesiones::crearTurno);
            diaSeleccionado = menu.handleOption();

            // Amazing paciente selection menu
//            InterfazUsuario.menuRequerirPaciente().handleOption();
            GestionTurnos.crearTurno(0, BDD.getInstance().cualquierMedicoDisponible(especialidadSeleccionada).getId());
        }
	}

	static Boolean validarToken(String token){
        boolean value = sesiones.containsKey(token);
        System.out.println("Valid token: " + value);
        return value;
    }

    public static void mostrarMisDatos(){ 
        BDD.getInstance().usuarios.getDato(sesiones.get(token)).mostrarMisDatos();
    }
    
}
