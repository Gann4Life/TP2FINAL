import org.junit.Test;

import database.BDD;
import enums.PreferenciaContacto;
import turnos.Turno;
import usuarios.Paciente;

import org.junit.Assert;

public class PedidosDeTurnosTest {
    @Test
    public void UsuarioCreaTurno(){
        String[] nombreDeMarta = new String[] {"Marta", "Susana"};
        String[] apellidoDeMarta = new String[] {"Gimenez", "Escobar"};
        Paciente Marta = new Paciente(nombreDeMarta, apellidoDeMarta, "martita@hotmail.com", "1163345976", PreferenciaContacto.TELEFONO);
        Marta.pedirTurno();
        Assert.assertEquals(true, BDD.getInstance().turnos.hayDatos());
    }
}