package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import database.BDD;
import enums.Especialidad;
import enums.EstadoTurno;
import enums.PreferenciaContacto;
import tratamientos.Ecografia;
import tratamientos.Medicacion;
import tratamientos.Tratamiento;
import turnos.GestionTurnos;
import turnos.Turno;
import usuarios.Medico;
import usuarios.Paciente;

public class Main {
	private static Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) {
    	/*
    	  Agregar turnos disponibles, al agregarlos, no se crean nuevos turnos, si no que
    	  se cambia el estado de los que ya estan.
    	 */
    	simulacionCompleta();
    }
    
    public static void simulacionCompleta() {
    		simularPedirTurno();
    		simularAtenderPaciente(Especialidad.CARDIOLOGÍA);
    }
    
    public static void simularAtenderPaciente(Especialidad especialidad) {
    	try {
			Medico medico = BDD.getInstance().medicoConEspecialidad(especialidad);
			medico.asignarTratamiento(
					new Tratamiento(
							new Medicacion(12, "Tafirol", "Debe tomar 2 veces al dia por 2 semanas."),
							new Medicacion(13, "No se", "Debe tomar 1 vez al dia por 2 semanas.")
					),
					new Tratamiento(
							new Ecografia("Corazon", 34, "Zona cubical")
					)
					);
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("Ingrese cualquier tecla para continuar la simulación.");
    	input.next();
    }
 
    
    
    public static void simularPedirTurno() {
    	Paciente paciente = instanciarPaciente("Ramiro","Alvarez","alvarez@gmail.com","1122334455",PreferenciaContacto.EMAIL);
    	instanciarMedico("Mauro","Garnes","garnes@gmail.com","1123650956",PreferenciaContacto.EMAIL, Especialidad.CARDIOLOGÍA);
    	try {
			instanciarTurno(Especialidad.CARDIOLOGÍA, BDD.getInstance().medicoConEspecialidad(Especialidad.CARDIOLOGÍA).getId());
		} catch (Exception e) {
			System.out.println("No se pudo aprobar el turno.");
		}
    	paciente.pedirTurno(Especialidad.CARDIOLOGÍA);
    	System.out.println("Ingrese cualquier tecla para continuar la simulación.");
    	input.next();
    }
    
    public static void instanciarPacientes() {
    	instanciarPaciente("Ramiro","Alvarez","alvarez@gmail.com","1122334455",PreferenciaContacto.EMAIL);
    	instanciarPaciente("Alberto", "Fernandez", "fernandez@gmail.com", "1133444545", PreferenciaContacto.EMAIL);
    	instanciarPaciente("Carlos", "Villa", "villa@gmail.com", "1156345676", PreferenciaContacto.TELEFONO);
    	instanciarPaciente("Roberto", "Campos", "campos@gmail.com", "1123784590", PreferenciaContacto.TELEFONO);
    	instanciarPaciente("Rodolfo", "Calla", "calla@gmail.com", "1100876545", PreferenciaContacto.TELEFONO);
    	instanciarPaciente("Francisco", "Angus", "angus@gmail.com", "1101230456", PreferenciaContacto.EMAIL);
    }
    
    public static void instanciarTurnos() throws Exception {
    	instanciarTurno(Especialidad.CARDIOLOGÍA, BDD.getInstance().medicoConEspecialidad(Especialidad.CARDIOLOGÍA).getId());
    	instanciarTurno(Especialidad.KINESIOLOGÍA, BDD.getInstance().medicoConEspecialidad(Especialidad.KINESIOLOGÍA).getId());
    	instanciarTurno(Especialidad.NEUROLOGÍA, BDD.getInstance().medicoConEspecialidad(Especialidad.NEUROLOGÍA).getId());
    }
    
    public static void instanciarTurno(Especialidad especialidad, int idMedico) {
    	Turno turno = new Turno(EstadoTurno.DISPONIBLE);
    	turno.especialidad = especialidad;
    	turno.idMedico = idMedico;
    	BDD.getInstance().turnos.addDato(turno);
    }
    
    public static void instanciarMedicos() {
    	instanciarMedico("Mauro","Garnes","garnes@gmail.com","1123650956",PreferenciaContacto.EMAIL, Especialidad.CARDIOLOGÍA);
    	instanciarMedico("Alvaro", "Alvarez", "alvarez@gmail.com", "1133444545", PreferenciaContacto.EMAIL, Especialidad.KINESIOLOGÍA);
    	instanciarMedico("Lucio", "Villalva", "villalva@gmail.com", "1156345676", PreferenciaContacto.TELEFONO, Especialidad.NEUROLOGÍA);
    }
    
    public static Paciente instanciarPaciente(String nombre, String apellido, String mail, String tel, PreferenciaContacto pref) {
    	return new Paciente(nombre,apellido,mail,tel,pref);
    }
    
    public static void instanciarMedico(String nombre, String apellido, String mail, String tel, PreferenciaContacto pref,Especialidad esp) {
        new Medico(nombre,apellido,mail,tel,pref,esp);
    }
}
