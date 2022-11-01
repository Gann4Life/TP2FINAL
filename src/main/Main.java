package main;

import database.BDD;
import enums.EstadoTurno;
import turnos.GestionTurnos;
import turnos.Turno;
import usuarios.Paciente;

public class Main {
    public static void main(String[] args) {

        // region [Cración de datos]
        BDD.getInstance().pacientes.addDato(
                new Paciente(
                        new String[]{"Cristiano", "Alejandro"},
                        new String[]{"Juarez"}
                )
        );

        BDD.getInstance().turnos.addDato(new Turno(EstadoTurno.Pendiente));
        GestionTurnos.cancelarTurno(0);
        // endregion

        // region [Visualización de datos]
        // endregion
    }
}
