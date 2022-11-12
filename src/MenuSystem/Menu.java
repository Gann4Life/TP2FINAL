package MenuSystem;
import sistemaLogin.SistemaLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public String nombreMenu;
    List<ICallable> opciones = new ArrayList<>();

    public Menu(String nombreMenu){
        this.nombreMenu = nombreMenu;
    }

    public void agregarOpcion(String optionName, ICallable callback){
        // PRE: I need a valid string optionName, and a callback using the ICallable interface
        // POS: I add the new option to the options list
        opciones.add(callback);
        System.out.println(label(opciones.size()) + optionName); // Displays the added option to the user
    }

    public int handleOption(){ // Returns the index of the chosen option
        // PRE: User inputs a valid number
        // POS: I return the parsed integer
        int input = -1;

        while (input < 0 || input >= opciones.size()) {
            System.out.print("user@" + nombreMenu +"# ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Reads user input

            try {
                input = Integer.parseInt(reader.readLine()) - 1;
            } catch (NumberFormatException | IOException nfe) {
                input = -1;
            }
        }

        return input;
    }
    public void HandleUserOption() throws IOException { Select(handleOption()); } // Delega la opción a ser seleccionada
    private void Select(int index) throws IOException { opciones.get(index).doCallback(); } // Hace una llamada al callback designado con el índice dado
    private String label(int i) { return "[" + i + "] "; }; // Retorna un string estilizado a partir de un número entero -> [X]
}