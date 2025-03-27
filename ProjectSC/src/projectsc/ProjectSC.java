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
import javax.swing.JOptionPane;

public class ProjectSC {
    public static void main(String[] args) {
        SistemaReservas sistemaReservas = new SistemaReservas();
        SistemaRecreativo sistemaRecreativo = new SistemaRecreativo();
        boolean continuar = true;

        while (continuar) {
            String opcion = JOptionPane.showInputDialog(
                "Menú de Reservas\n" +
                "1. Reservar sala de reuniones\n" +
                "2. Cancelar reserva de sala\n" +
                "3. Mostrar salas disponibles\n" +
                "4. Reservar zona recreativa\n" +
                "5. Cancelar reserva de zona recreativa\n" +
                "6. Mostrar zonas recreativas disponibles\n" +
                "7. Salir\n" +
                "Ingrese una opción:"
            );

            if (opcion == null) break; // Si el usuario cancela, salir

            switch (opcion) {
                case "1": // Reservar Sala de Reuniones
                    String[] opciones = {"5 espacios", "10 espacios", "15 espacios", "20 espacios"};
                    String seleccion = (String) JOptionPane.showInputDialog(
                            null,
                            "Seleccione la capacidad de la sala:",
                            "Reservar Sala",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]);

                    if (seleccion != null) {
                        int capacidad = Integer.parseInt(seleccion.split(" ")[0]);
                        salaReuniones sala = sistemaReservas.buscarSalaPorCapacidad(capacidad);

                        if (sala != null) {
                            int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado:"));
                            sala.reservar(idEmpleado);
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay salas disponibles con esa capacidad.");
                        }
                    }
                    break;

                case "2": // Cancelar Reserva de Sala
                    String idSalaCancelar = JOptionPane.showInputDialog("Ingrese el ID de la sala a cancelar:");
                    if (idSalaCancelar != null && !idSalaCancelar.trim().isEmpty()) {
                        sistemaReservas.cancelarReserva(idSalaCancelar);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID de sala no válido.");
                    }
                    break;

                case "3": // Mostrar Salas Disponibles
                    sistemaReservas.mostrarSalasDisponibles();
                    break;

                case "4": // Reservar Zona Recreativa
                    sistemaRecreativo.mostrarZonasDisponibles();
                    String idZona = JOptionPane.showInputDialog("Ingrese el ID de la zona a reservar:");
                    if (idZona != null && !idZona.trim().isEmpty()) {
                        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado:"));
                        String hora = JOptionPane.showInputDialog("Ingrese la hora de la reserva (ejemplo: 14:00 - 15:00):");
                        sistemaRecreativo.reservarZona(idZona, idEmpleado, hora);
                    }
                    break;

                case "5": // Cancelar Reserva de Zona Recreativa
                    String idZonaCancelar = JOptionPane.showInputDialog("Ingrese el ID de la zona a cancelar:");
                    if (idZonaCancelar != null && !idZonaCancelar.trim().isEmpty()) {
                        sistemaRecreativo.cancelarReserva(idZonaCancelar);
                    } else {
                        JOptionPane.showMessageDialog(null, "ID de zona no válido.");
                    }
                    break;

                case "6": // Mostrar Zonas Recreativas Disponibles
                    sistemaRecreativo.mostrarZonasDisponibles();
                    break;

                case "7": // Salir
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        }
    }
}

                  
        
        
   

    