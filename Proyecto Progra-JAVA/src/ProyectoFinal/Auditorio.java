/*
Informacion del Auditorio. 
 */
package ProyectoFinal;

import javax.swing.JOptionPane;

public class Auditorio {

    //Info del auditorio: 
    private int cmCharla = 50; //Capacidad maxima para la sesion de charlas. 
    private int cmCapacitacion = 50; //Capacidad maxima para capacitacion.
    private int ocupActualCharlas = 0; //Ocupacion actual en charlas. 
    private int ocupActualCapacitacion = 0; //Ocupacion actual en capacitacion. 

//Menu de reservas del Auditorio:
    public void auditorio() {
        int reservaAuditorio = Integer.parseInt(JOptionPane.showInputDialog("Indique la actividad a reservar: \n[ 1 ]- Charlas (10:00am).\n [ 2 ]- Capacitacion (3:00pm).\n [ 3 ]- Regresar al menu anterior.\n "));

        switch (reservaAuditorio) {
            case 1:
                Charlas();
                auditorio();
                break;
            case 2:
                Capacitaciones();
                auditorio();
                break;
            /*case 3:
                regresarReservacion();
                break;*/
            default:
                JOptionPane.showConfirmDialog(null, "Opcion incorrecta.\n Por favor intentelo nuevamente. [ 1 - 3 ]", "Atencion!", JOptionPane.WARNING_MESSAGE);
                auditorio();
                break;

        }

    }

    //Metodo de reservaciones de charlas:
    public void Charlas() {
        JOptionPane.showMessageDialog(null, "Espacios disponibles: " + (cmCharla - ocupActualCharlas)); //Muestra la disponibilidad actual del auditorio. 

        //Revision de espacios disponibles:
        if (ocupActualCharlas >= cmCharla) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, actualmente no hay espacios disponibles para esta sesion.\n Vuelva a intentar mas tarde.");
            return;
        }

        //Solicitud de asistentes a la charla:
        int cantResCharla = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de espacios a reservar: "));

        if (cantResCharla <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de espacios debe ser mayor a 0.", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (ocupActualCharlas + cantResCharla > cmCharla) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacios suficientes para efectuar la reservacion.\n Disponibilidad: " + (cmCharla - ocupActualCharlas) + " espacios.");
            return;
        }

        //Solicitud de nombre del empleado para la reserva: 
        String empleadoReserva = JOptionPane.showInputDialog("Ingrese su nombre: \n [Unicamente nombre, sin apellidos]");

        //Se buca el ID segun el nombre:
        String idEmpleado = buscarID(empleadoReserva);

        if (idEmpleado == null) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el ID del usuario " + empleadoReserva + "\n Intente nuevamente.");
            return;
        }

        //Incremento de la ocupacion actual: 
        ocupActualCharlas += cantResCharla;

        //Mensaje de confirmacion:
        JOptionPane.showMessageDialog(null, "Creando reserva...");
        JOptionPane.showMessageDialog(null, "Reserva realizada con exito! \n\nInformacion de la reserva: \n-Codigo de Reserva: " + idEmpleado + "\n-Nombre: " + empleadoReserva + "\n-Cantidad de Espacios: " + cantResCharla + "\n\n*Espacios Ocupados: " + ocupActualCharlas + "/" + cmCharla + ".*");

    }

    //Metodo para buscar el ID del empleado: 
    private String buscarID(String nombre) {
        for (Empleado empleado : Empleado.empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado.getId();
            }
        }
        return null;
    }

    //Metodo de reservaciones de capacitaciones:
    public void Capacitaciones() {
        JOptionPane.showMessageDialog(null, "Espacios disponibles: " + (cmCapacitacion - ocupActualCapacitacion)); //Muestra la disponibilidad actual del auditorio. 

        //Revision de espacios disponibles:
        if (ocupActualCapacitacion >= cmCapacitacion) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, actualmente no hay espacios disponibles para esta sesion.\n Vuelva a intentar mas tarde.");
            return;
        }

        //Solicitud de asistentes a la charla:
        int cantResCapacitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de espacios a reservar: "));

        if (cantResCapacitacion <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de espacios debe ser mayor a 0.", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (ocupActualCapacitacion + cantResCapacitacion > cmCapacitacion) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacios suficientes para efectuar la reservacion.\n Disponibilidad: " + (cmCapacitacion - ocupActualCapacitacion) + " espacios.");
            return;
        }

        //Solicitud de nombre del empleado para la reserva: 
        String empleadoReserva = JOptionPane.showInputDialog("Ingrese su nombre: \n [Unicamente nombre, sin apellidos]");

        //Se buca el ID segun el nombre:
        String idEmpleado = buscarID(empleadoReserva);

        if (idEmpleado == null) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el ID del usuario " + empleadoReserva + "\n Intente nuevamente.");
            return;
        }

        //Incremento de la ocupacion actual: 
        ocupActualCapacitacion += cantResCapacitacion;

        //Mensaje de confirmacion:
        JOptionPane.showMessageDialog(null, "Creando reserva...");
        JOptionPane.showMessageDialog(null, "Reserva realizada con exito! \n\nInformacion de la reserva: \n-Codigo de Reserva: " + idEmpleado + "\n-Nombre: " + empleadoReserva + "\n-Cantidad de Espacios: " + cantResCapacitacion + "\n\n*Espacios Ocupados: " + ocupActualCapacitacion + "/" + cmCapacitacion + ".*");

    }
    
}

//aquiestuvobryan