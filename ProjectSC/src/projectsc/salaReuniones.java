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
public class salaReuniones {
    public String idSala;
    public String ubicacion;
    public boolean disponibilidad;
    public int capacidad;
    private int idEmpleadoReservado;
    
    public boolean reservar(int idEmpleado) {
    if (disponibilidad) {
        disponibilidad = false;
        this.idEmpleadoReservado = idEmpleado;
        JOptionPane.showMessageDialog(null, "Sala " + idSala + " reservada para el empleado con ID: " + idEmpleado);
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "La sala " + idSala + " no está disponible.", "Reserva Fallida", JOptionPane.WARNING_MESSAGE);
        return false;
    }
    
   
}
    
    public void cancelarReserva() {
    if (!disponibilidad) {
        JOptionPane.showMessageDialog(null, "La reserva de la sala " + idSala + " ha sido cancelada. Estaba reservada por el empleado con ID: " + idEmpleadoReservado);
        disponibilidad = true;
        idEmpleadoReservado = 0; // Reiniciar el ID del empleado
    } else {
        JOptionPane.showMessageDialog(null, "La sala " + idSala + " no estaba reservada.", "Cancelación Fallida", JOptionPane.WARNING_MESSAGE);
    }
}

    public salaReuniones(String idSala, String ubicacion, boolean disponibilidad, int capacidad) {
        this.idSala = idSala;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
        this.capacidad = capacidad;
    }

    public salaReuniones() {
    }

    public String getIdSala() {
        return idSala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "salaReuniones{" + "idSala=" + idSala + ", ubicacion=" + ubicacion + ", disponibilidad=" + disponibilidad + ", capacidad=" + capacidad + '}';
    }
    
    
            
}
