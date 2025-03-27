/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectsc;

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
}
    


