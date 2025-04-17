package ProyectoFinal;

import javax.swing.JOptionPane;

public class CancelarReservas {

    private Auditorio auditorio;
    private Parqueos parqueo;
    private SistemaCubiculos sistemaCubiculos;
    
    
    public CancelarReservas(Auditorio auditorio, Parqueos parqueo, SistemaCubiculos sistemaCubiculos) {
        this.auditorio = auditorio;
        this.parqueo = parqueo;
        this.sistemaCubiculos = sistemaCubiculos;

    }

    public void cancelarModificar() {
        int caso = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique la opcion a modificar: \n 1. - Reservaciones de Parqueo. \n 2. - Reservaciones de Cubiculos.\n 3. - Reservaciones de Auditorio.\n 4. - Reservaciones de Salon Insonoro.\n 5. - Reservaciones de Zonas Recreativas.\n 6. - Regreser al menu anterior."));
        switch(caso){
            case 1:
                parqueo.mostrarDisponibilidad();
                int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel del parqueo [1-S1, 2-S2, 3-S3]:"));
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila del espacio a liberar:"));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna del espacio a liberar:"));
                parqueo.liberarParqueo(nivel, fila, columna);
                break;
            case 2: // Cubiculo
                sistemaCubiculos.cancelarReservaCubiculo(); 
                break;
            case 3:
                cancelarModificarAuditorio();
                cancelarModificar();
                break;
            case 4:
                //reservaciones de salones insonoros
                cancelarModificar();
                break;
            case 5:
                //reservaciones zonas recreativas
                cancelarModificar();
            case 6:
                return; //regresa al menu anterior
            default:
                JOptionPane.showMessageDialog(null,"Opcion incorrecta. \nPor favor intentelo de nuevo.");
                cancelarModificar();
                break;
        }
    }

    //Cancela o modifica las reservas del auditorio
    public void cancelarModificarAuditorio() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre para buscar su reserva:");
        boolean encontrada = false;
        
        //Busca la reserva por el nombre
        for (int i = 0; i < auditorio.getContadorReservas(); i++) {
            if (auditorio.getReservas()[i][1].equalsIgnoreCase(nombre)) {
                encontrada = true;
                
                
                
                //Informacion de la reserva
                String diaTexto = auditorio.getReservas()[i][4];
                int numeroDia = Integer.parseInt(diaTexto.split(" ")[1]);
                String nombreDelDia = auditorio.nombreDia(numeroDia);
                
                String detalle = "Se encontro la siguiente reserva: \n\n"
                        + "- Código: " + auditorio.getReservas()[i][0]
                        + "\n- Nombre: " + auditorio.getReservas()[i][1]
                        + "\n- Cantidad de Espacios: " + auditorio.getReservas()[i][2]
                        + "\n- Tipo: " + auditorio.getReservas()[i][3]
                        + "\n- Día: " + nombreDelDia;
                
                //Consulta si modifica o cancelar
                Object[] opciones = {"Eliminar", "Modificar", "Salir"};
                int opcion = JOptionPane.showOptionDialog(null, detalle + "\n\n¿Qué desea hacer?",
                        "Gestión de Reserva", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, opciones, opciones[2]);

                int cantidadActual = Integer.parseInt(auditorio.getReservas()[i][2]);
                int dia = Integer.parseInt(auditorio.getReservas()[i][4].split(" ")[1]) - 1;

                //Cancelar reserva
                if (opcion == 0) { 
                    if (auditorio.getReservas()[i][3].equals("Charlas")) {
                        auditorio.getOcupCharlasxDia()[dia] -= cantidadActual;
                    } else if (auditorio.getReservas()[i][3].equals("Capacitaciones")) {
                        auditorio.getOcupCapacitacionesxDia()[dia] -= cantidadActual;
                    }

                    // Actualiza informacion
                    for (int j = i; j < auditorio.getContadorReservas() - 1; j++) {
                        auditorio.getReservas()[j] = auditorio.getReservas()[j + 1];
                    }

                    auditorio.getReservas()[auditorio.getContadorReservas() - 1] = new String[5];
                    auditorio.setContadorReservas(auditorio.getContadorReservas() - 1);

                    JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente.");
                    return;
                    
                    //Modifica la reserva
                } else if (opcion == 1) {
                    String nuevaCantidadStr = JOptionPane.showInputDialog("Ingrese la nueva cantidad de espacios:");
                    int nuevaCantidad = Integer.parseInt(nuevaCantidadStr);

                    int diferencia = nuevaCantidad - cantidadActual;

                    if (auditorio.getReservas()[i][3].equals("Charlas")) {
                        if (auditorio.getOcupCharlasxDia()[dia] + diferencia <= 50 && auditorio.getOcupCharlasxDia()[dia] + diferencia >= 0) {
                            auditorio.getOcupCharlasxDia()[dia] += diferencia;
                            auditorio.getReservas()[i][2] = String.valueOf(nuevaCantidad);
                            JOptionPane.showMessageDialog(null, "Reserva modificada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay suficientes espacios disponibles para modificar la reserva.");
                        }
                    } else if (auditorio.getReservas()[i][3].equals("Capacitaciones")) {
                        if (auditorio.getOcupCapacitacionesxDia()[dia] + diferencia <= 30 && auditorio.getOcupCapacitacionesxDia()[dia] + diferencia >= 0) {
                            auditorio.getOcupCapacitacionesxDia()[dia] += diferencia;
                            auditorio.getReservas()[i][2] = String.valueOf(nuevaCantidad);
                            JOptionPane.showMessageDialog(null, "Reserva modificada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No hay suficientes espacios disponibles para modificar la reserva.");
                        }
                    }

                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "No se realizó ninguna acción.");
                    return;
                }
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva con el nombre proporcionado.");

        }
    }

}
