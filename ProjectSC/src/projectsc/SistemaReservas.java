/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectsc;

import javax.swing.JOptionPane;

/**
 *
 * @author alvarados
 */
public class SistemaReservas {
    private salaReuniones[] salas; // Arreglo

    public SistemaReservas() {
        salas = new salaReuniones[4]; // 4 salas fijas
        salas[0] = new salaReuniones("S001", "Piso 1", true, 5);
        salas[1] = new salaReuniones("S002", "Piso 2", true, 10);
        salas[2] = new salaReuniones("S003", "Piso 3", true, 15);
        salas[3] = new salaReuniones("S004", "Piso 4", true, 20);
    }

    public salaReuniones buscarSalaPorCapacidad(int capacidad) {
        for (int i = 0; i < salas.length; i++) {
            if (salas[i].getCapacidad() == capacidad && salas[i].isDisponibilidad()) {
                return salas[i];
            }
        }
        return null; // No hay salas disponibles con esa capacidad
    }
    
    // Método para cancelar una reserva por ID de sala
    public void cancelarReserva(String idSala) {
        for (salaReuniones sala : salas) {
            if (sala.getIdSala().equals(idSala)) {
                sala.cancelarReserva();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró la sala con ID: " + idSala, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar salas disponibles
    public void mostrarSalasDisponibles() {
        StringBuilder mensaje = new StringBuilder("Salas disponibles:\n");

        for (salaReuniones sala : salas) {
            if (sala.isDisponibilidad()) {
                mensaje.append("ID: ").append(sala.getIdSala())
                       .append(" | Capacidad: ").append(sala.getCapacidad())
                       .append(" | Ubicación: ").append(sala.getUbicacion()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Salas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }
}












    


