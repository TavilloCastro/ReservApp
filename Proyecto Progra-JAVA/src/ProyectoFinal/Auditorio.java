package ProyectoFinal;

import javax.swing.JOptionPane;

public class Auditorio {

    //Info del auditorio: 
    private int cmCharla = 50; //Capacidad maxima para la sesion de charlas. 
    private int cmCapacitacion = 50; //Capacidad maxima para capacitacion.

    //Control de ocupacion por dia de la semana
    private int ocupCharlasxDia[] = new int[5];
    private int ocupCapacitacionesxDia[] = new int[5];

    //Tamanho maximo de reservas
    private int max_reservas = 100;
    private String reservas[][] = new String[max_reservas][5];
    private int contadorReservas = 0;

    public String[][] getReservas() {
        return reservas;
    }

    public int getContadorReservas() {
        return contadorReservas;
    }

    public void setContadorReservas(int contadorReservas) {
        this.contadorReservas = contadorReservas;
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
    
    //Obtener el nombre del dia
    public String nombreDia(int diaSemana) {
        switch (diaSemana) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miércoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            default:
                return "Día inválido";
        }
    }

//Menu de reservas del Auditorio:
    public void auditorio() {
        int reservaAuditorio = Integer.parseInt(JOptionPane.showInputDialog("Indique la actividad a reservar: \n 1. - Charlas (10:00am).\n 2. - Capacitacion (3:00pm).\n 3. - Regresar al menu anterior.\n "));

        switch (reservaAuditorio) {
            case 1:
                Charlas();
                auditorio();
                break;
            case 2:
                Capacitaciones();
                auditorio();
                break;
            case 3:
                return;
            default:
                JOptionPane.showConfirmDialog(null, "⚠️Opcion incorrecta.⚠️\n Por favor intentelo nuevamente. [1 - 3]", "Atencion!", JOptionPane.WARNING_MESSAGE);
                auditorio();
                break;
        }

    }

    //Metodo de reservaciones de charlas:
    public void Charlas() {
        int diaSemana;
        while (true) {
            diaSemana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de la semana para la reserva [1 - 5]: \n*1 es Lunes y 5 es Viernes:"));

            // Validación del día de la semana
            if (diaSemana < 1 || diaSemana > 5) {
                JOptionPane.showMessageDialog(null, "⚠️Error⚠️: \nEl día debe estar entre 1 (Lunes) y 5 (Viernes). \nIntente nuevamente.");
            } else {
                break;
            }
        }

        //Revision de disponibilidad:
        if (ocupCharlasxDia[diaSemana] >= cmCharla) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, actualmente no hay espacios disponibles para esta sesion el dia " + (diaSemana + 1) + ".\n Vuelva a intentar mas tarde.");
            return;
        }

        //Solicitud de asistentes a la charla:
        int cantResCharla = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de espacios a reservar: "));

        if (cantResCharla <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de espacios debe ser mayor a 0.", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (ocupCharlasxDia[diaSemana] + cantResCharla > cmCharla) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacios suficientes para efectuar la reservacion.\n Disponibilidad: " + (cmCharla - ocupCharlasxDia[diaSemana]) + " espacios.");
            return;
        }

        //Solicitud de nombre del empleado para la reserva: 
        String empleadoReserva = JOptionPane.showInputDialog("Ingrese su nombre: \n [Unicamente nombre, sin apellidos]");

        //Busca el ID segun el nombre del usuario:
        String idEmpleado = buscarID(empleadoReserva);

        if (idEmpleado == null) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el ID del usuario " + empleadoReserva + "\n Intente nuevamente.");
            return;
        }

        //Incremento de la ocupacion actual: 
        ocupCharlasxDia[diaSemana] += cantResCharla;

        //Almacenamiento de reservaciones
        if (contadorReservas < max_reservas) {
            reservas[contadorReservas][0] = idEmpleado;
            reservas[contadorReservas][1] = empleadoReserva;
            reservas[contadorReservas][2] = String.valueOf(cantResCharla);
            reservas[contadorReservas][3] = "Charlas";
            reservas[contadorReservas][4] = "Día " + (diaSemana);
            contadorReservas++;
        }

        //Mensaje de confirmacion:
        String diaNombre = nombreDia(diaSemana);
        JOptionPane.showMessageDialog(null, "Creando reserva...");
        JOptionPane.showMessageDialog(null, "Reserva realizada con exito! \n\nInformacion de la reserva: \n\n- Codigo de Reserva: " + idEmpleado + "\n- Nombre: " + empleadoReserva + "\n- Actividad: Charla (10:00am) \n- Dia: " + diaNombre + "\n- Cantidad de Espacios: " + cantResCharla + "\n\n*Espacios Ocupados: " + ocupCharlasxDia[diaSemana] + "/" + cmCharla + ".*");

    }

    public int[] getOcupCharlasxDia() {
        return ocupCharlasxDia;
    }

    public int[] getOcupCapacitacionesxDia() {
        return ocupCapacitacionesxDia;
    }

    //Metodo de reservaciones de capacitaciones:
    public void Capacitaciones() {
        int diaSemana;
        while (true) {
            diaSemana = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el día de la semana para la reserva [1 - 5]: \n1 es Lunes y 5 es Viernes:"));

            // Validación del día de la semana
            if (diaSemana < 1 || diaSemana > 5) {
                JOptionPane.showMessageDialog(null, "Error: El día debe estar entre 1 (Lunes) y 5 (Viernes). Intente nuevamente.");
            } else {
                break;
            }
        }
        //Revision de disponibilidad:
        if (ocupCapacitacionesxDia[diaSemana] >= cmCapacitacion) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, actualmente no hay espacios disponibles para esta sesion el dia " + (diaSemana + 1) + ".\n Vuelva a intentar mas tarde.");
            return;
        }

        //Solicitud de asistentes a la capacitacion:
        int cantResCapacitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de espacios a reservar: "));

        if (cantResCapacitacion <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad de espacios debe ser mayor a 0.", "Atencion!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (ocupCapacitacionesxDia[diaSemana] + cantResCapacitacion > cmCapacitacion) {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay espacios suficientes para efectuar la reservacion.\n Disponibilidad: " + (cmCapacitacion - ocupCapacitacionesxDia[diaSemana]) + " espacios.");
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
        ocupCapacitacionesxDia[diaSemana] += cantResCapacitacion;

        //Mensaje de confirmacion:
        String diaNombre = nombreDia(diaSemana);
        JOptionPane.showMessageDialog(null, "Creando reserva...");
        JOptionPane.showMessageDialog(null, "Reserva realizada con exito! \n\nInformacion de la reserva: \n\n- Codigo de Reserva: " + idEmpleado + "\n- Nombre: " + empleadoReserva + "\n- Actividad: Capacitacion (3:00pm) \n- Dia: " + diaNombre + "\n- Cantidad de Espacios: " + cantResCapacitacion + "\n\n*Espacios Ocupados: " + ocupCapacitacionesxDia[diaSemana] + "/" + cmCapacitacion + ".*");
    }

}
