package usuarios;

import enums.Especialidad;
import enums.Estado;
import enums.EstadoFinanciero;
import enums.PreferenciaContacto;
import interfaces.ConsultarPrecio;
import jdk.jshell.spi.ExecutionControl;
import main.Diagnostico;
import main.Estudio;
import tratamientos.Medicacion;
import tratamientos.Tratamiento;
import turnos.Turno;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import contacto.GestionContactos;
import contacto.Mensaje;
import database.BDD;

public class Medico extends Usuario {
    public int idMedicoACargo;
    public int idPaciente;
    public Diagnostico diagnostico;
    public boolean asistencia;
    public EstadoFinanciero estadoFinanciero;
    public Especialidad especialidad;
    
    public Tratamiento tratamientoActual;

    public Medico(String nombre, String apellido, String email, String telefono, PreferenciaContacto pref, Especialidad esp) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.contacto = new Contacto(email, telefono, pref);
    	this.especialidad = esp;
    	BDD.getInstance().medicos.addDato(this);
    }
    
    public double costoDePrestacion() {
    	/*
 	 	 PROPOSITO: Describe el costo de la prestación.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return tratamientoActual.getPrecio();
    }
    
    
    public void asignarTratamiento(ConsultarPrecio ...tratamiento) {
    	try {
    		this.tratamientoActual = new Tratamiento(tratamiento); 
			idPaciente = pacienteAAtender();
			asignarDeuda(costoDePrestacion());
			getPaciente().estado = Estado.ATENDIDO;
			System.out.println("Su tratamiento es: ");
			tratamientoActual.getDescripcion();
			GestionContactos.enviarMensajeAlUsuario(new Mensaje("Deuda con la clinica", "Su deuda actual es de: " + tratamientoActual.getPrecio()), idPaciente);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void asignarDeuda(double deuda) {
    	getPaciente().deuda = deuda;
    }
    
    public int pacienteAAtender() throws Exception {
    	List<Turno> turnos = BDD.getInstance().turnos.getDatos();
    	for(int i=0; i < turnos.size();i++) {
    		if(turnos.get(i).especialidad == this.especialidad && esPacienteEnEspera(turnos.get(i)));
    			return turnos.get(i).idPaciente;
    	}
    	throw new Exception("No se encontro ningun paciente a atender.");
    }
    
    public boolean esPacienteEnEspera(Turno turno) {
    	return BDD.getInstance().pacientes.getDato(turno.idPaciente).estado == Estado.ESPERA;
    }
    
    public Paciente getPaciente() {
    	return BDD.getInstance().pacientes.getDato(idPaciente);
    }
    
    public int getId() {
    	return BDD.getInstance().medicos.getDatos().indexOf(this);
    }
    
}
