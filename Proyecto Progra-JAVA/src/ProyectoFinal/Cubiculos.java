package ProyectoFinal;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class Cubiculos {
    // Atributos
    private String idCubiculo;
    private boolean disponibilidad;
    private String horaReservada;
    private String idEmpleadoReservado;

    // Creacion de constructor, inicia los cubiculos como disponibles sin reservas con el id proporcionado.
    public Cubiculos(String idCubiculo) {
        this.idCubiculo = idCubiculo;
        this.disponibilidad = true;
        this.horaReservada = "";
        this.idEmpleadoReservado = "";
    }
    
        // Horarios disponibles de 9am a 6pm (10 horas) en hora de 24 horas
         private static final String[] HORARIOS = {
        "09:00", "10:00", "11:00", "12:00", 
        "13:00", "14:00", "15:00", "16:00", 
        "17:00", "18:00"
    };

    // Metodo para reservar los cubiculos, se verifica si estan disponibles los cub, y se valida que la hora sea correcta
    public boolean reservar(String idEmpleado, String hora) {
        if (!disponibilidad) {
            JOptionPane.showMessageDialog(null, "El cubiculo " + idCubiculo + " ya esta reservado");
            return false;
        }
        
        if (!esHoraValida(hora)) {
            JOptionPane.showMessageDialog(null, "Hora no valida. Utilice el formato HH:MM (09:00 a 18:00)");
            return false;
        }
        
        disponibilidad = false;
        horaReservada = hora;
        idEmpleadoReservado = idEmpleado;
        JOptionPane.showMessageDialog(null, "Reserva exitosa:\nCubiculo: " + idCubiculo + "\nHora: " + hora + "\nEmpleado: " + idEmpleado);
        return true;
    }

    // Metodo para liberar el cub
    public void cancelarReserva() {
        disponibilidad = true;
        horaReservada = "";
        idEmpleadoReservado = "";
    }

    private boolean esHoraValida(String hora) {
        for (String h : HORARIOS) {
            if (h.equals(hora)) return true;
        }
        return false;
    }

    // Creacion de Getters
    public String getIdCubiculo() { return idCubiculo; }
    public boolean isDisponibilidad() { return disponibilidad; }
    public String getHoraReservada() { return horaReservada; }
    public String getIdEmpleadoReservado() { return idEmpleadoReservado; }
}
