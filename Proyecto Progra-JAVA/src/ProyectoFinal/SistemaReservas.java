/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import javax.swing.JOptionPane;

/**
 *
 * @author alvarados
 */
public class SistemaReservas {
    private salaReuniones[] salas; // Arreglo

    public SistemaReservas() {
        salas = new salaReuniones[4]; // 4 salas fijas
        salas[0] = new salaReuniones("Tamarindo", "1", true, 5);
        salas[1] = new salaReuniones("Uvita", "2", true, 10);
        salas[2] = new salaReuniones("MonteVerde", "3", true, 15);
        salas[3] = new salaReuniones("Puerto Viejo", "4", true, 20);
    }

    public salaReuniones buscarSalaPorCapacidad(int capacidad) {
        for (int i = 0; i < salas.length; i++) {
            if (salas[i].getCapacidad() == capacidad && salas[i].isDisponibilidad()) {
                return salas[i];
            }
        }
        return null; 
    }
    public void salonReservas() {
    StringBuilder mensaje = new StringBuilder("Salas reservadas:\n");
    boolean hayReservas = false;

    for (salaReuniones sala : salas) {
        if (!sala.isDisponibilidad()) {
            mensaje.append("Nombre: ").append(sala.getIdSala())
                   .append(" | Capacidad: ").append(sala.getCapacidad())
                   .append(" | Ubicación: ").append(sala.getUbicacion()).append("\n");
            hayReservas = true;
        }
    }
    
    }

    @Override
    public String toString() {
        return "SistemaReservas{" + "salas=" + salas + '}';
    }
    
    
    

    
    public void mostrarSalasDisponibles() {
        StringBuilder mensaje = new StringBuilder("Salas disponibles:\n");

        for (salaReuniones sala : salas) {
            if (sala.isDisponibilidad()) {
                mensaje.append("Nombre: ").append(sala.getIdSala())
                       .append(" | Capacidad: ").append(sala.getCapacidad())
                       .append(" | Numero de salon: ").append(sala.getUbicacion()).append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Salas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }
}



    

