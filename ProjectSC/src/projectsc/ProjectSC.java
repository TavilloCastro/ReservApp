/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectsc;

import javax.swing.JOptionPane;

/**
 *
 * @author alvarados
 */
public class ProjectSC {

    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();

        String[] opciones = {"5 espacios", "10 espacios", "15 espacios", "20 espacios"};
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la capacidad de la sala:",
                "Reservar Sala",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion != null) { // Verifica que el usuario no canceló
            int capacidad = Integer.parseInt(seleccion.split(" ")[0]);
            salaReuniones sala = sistema.buscarSalaPorCapacidad(capacidad);

            if (sala != null) {
                int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado:"));
                sala.reservar(idEmpleado);
            } else {
                JOptionPane.showMessageDialog(null, "No hay salas disponibles con esa capacidad.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción.");
        }
    }
}
    
    
       
        
                  
        
        
   

    