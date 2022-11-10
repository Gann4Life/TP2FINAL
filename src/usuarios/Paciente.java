package usuarios;

import database.BDD;
import enums.Especialidad;
import enums.Estado;
import enums.EstadoTurno;
import enums.PreferenciaContacto;
import turnos.GestionTurnos;
import turnos.Turno;

import java.util.List;

import contacto.GestionContactos;
import contacto.Mensaje;
import tratamientos.Tratamiento;
public class Paciente extends Usuario {
	
	public Estado estado;
	public double deuda = 0;
	public List<Tratamiento> tratamientos;
    public Paciente(String nombre, String apellido, String email, String telefono, PreferenciaContacto preferencia) {
    	/*
 	 	 PROPOSITO: Instancia la clase Paciente.
 	 	 PARÁMETROS:
 	 	 	* nombres - Los nombres del paciente.
 	 	 	* apellidos - Los apellidos del paciente.
 	 	 	* email - El email del paciente.
 	 	 	* telefono - El telefono del paciente.
 	 	 	* preferencia - La preferencia de contacto del paciente.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = new Contacto(email, telefono, preferencia);
        BDD.getInstance().pacientes.addDato(this);
    }
    public void pedirTurno(Especialidad especialidad) {
        // TODO: Verificación de requerimientos para pedir turnos.
        // Un paciente no puede obtener un turno si no pagó el servicio.
        // Un paciente no puede obtener un turno si no está registrado.
        // En caso de no estar registrado, se debe pedir registro y a continuación los métodos de pago.
        // El paciente se comunicaría con alguna instancia de administrativo para pedir el turno.
    	if(GestionTurnos.esPacienteApto(this.getId(), especialidad)) {
    		Turno turno = GestionTurnos.getTurnoDisponible(especialidad);
    		turno.idPaciente = this.getId();
    		this.estado = Estado.ESPERA;
    		GestionTurnos.establecerEstado(turno.id, EstadoTurno.APROBADO);
    		Medico medico = BDD.getInstance().medicos.getDato(turno.idMedico);
    		GestionContactos.enviarMensajeAlUsuario(new Mensaje("Su turno fue aprobado.", "El día " + turno.horaInicio + " Con el doctor " + medico.nombre), this.getId());
    	}
    	else {
    		System.out.println("El paciente " + this.nombre + " no es apto para reservar un turno.");
    	}
    }
    
    public List<Tratamiento> verHistoriaClinica() {
    	/*
 	 	 PROPOSITO: Describe la historia clinica.
 	 	 PRECONDICION:
 	 	 	* Ninguna.
    	*/
        return tratamientos;
    }

    public void pagarDeuda(double cantidad) {
    	deuda -= cantidad;
    }
    
    public static Paciente obtenerPacienteBDD(int id) {
    	/*
 	 	 PROPOSITO: Obtiene el paciente con el id dado.
 	 	 PARÁMETROS:
 	 	 	* id - El id del paciente a obtener.
 	 	 PRECONDICION:
 	 	 	* El paciente con el id dado debe existir.
    	*/
        return (Paciente) BDD.getInstance().pacientes.getDato(id);
    }
    
    public int getId() {
    	return BDD.getInstance().pacientes.getDatos().indexOf(this);
    }
}
