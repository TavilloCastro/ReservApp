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
public class zonaRecreativa {

    private String idZona;
    private String tipo;
    private String ubicacion;
    private boolean disponibilidad;
    private String horaReservada;
    private int idEmpleadoReservado;

    public zonaRecreativa(String idZona, String tipo, String ubicacion) {
        this.idZona = idZona;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.disponibilidad = true; // Disponible por defecto
        this.horaReservada = "";
        this.idEmpleadoReservado = 0;

    }

    // Método para reservar
    public boolean reservar(int idEmpleado, String hora) {
        if (disponibilidad) {
            disponibilidad = false;
            this.horaReservada = hora;
            this.idEmpleadoReservado = idEmpleado;
            JOptionPane.showMessageDialog(null, "Zona " + tipo + " (" + idZona + ") reservada para el empleado con ID: " + idEmpleado + " en el horario: " + hora);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La zona " + tipo + " (" + idZona + ") no está disponible.", "Reserva Fallida", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    // Método para cancelar reserva
    public void cancelarReserva() {
        if (!disponibilidad) {
            JOptionPane.showMessageDialog(null, "La reserva de la zona " + tipo + " (" + idZona + ") ha sido cancelada. Estaba reservada por el empleado con ID: " + idEmpleadoReservado);
            disponibilidad = true;
            horaReservada = "";
            idEmpleadoReservado = 0;
        } else {
            JOptionPane.showMessageDialog(null, "La zona " + tipo + " (" + idZona + ") no estaba reservada.", "Cancelación Fallida", JOptionPane.WARNING_MESSAGE);
        }
    }


    public String getIdZona() {
        return idZona;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public String getHoraReservada() {
        return horaReservada;
    }

    public int getIdEmpleadoReservado() {
        return idEmpleadoReservado;
    }

    public void setHoraReservada(String horaReservada) {
        this.horaReservada = horaReservada;
    }

    public void setIdEmpleadoReservado(int idEmpleadoReservado) {
        this.idEmpleadoReservado = idEmpleadoReservado;
    }

}

