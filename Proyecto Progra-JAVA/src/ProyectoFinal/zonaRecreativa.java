package ProyectoFinal;

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

    
    public void cancelar() {
    this.disponibilidad = true;
    this.idEmpleadoReservado = 0;
    this.horaReservada = null;
}

    @Override
    public String toString() {
        return "zonaRecreativa{" + "idZona=" + idZona + ", tipo=" + tipo + ", ubicacion=" + ubicacion + ", disponibilidad=" + disponibilidad + ", horaReservada=" + horaReservada + ", idEmpleadoReservado=" + idEmpleadoReservado + '}';
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


    

