package ProyectoFinal;

import javax.swing.JOptionPane;

public class CancelarReservas {

    private Auditorio auditorio;

    public CancelarReservas(Auditorio auditorio) {
        this.auditorio = auditorio;
    }

    public void cancelar() {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre para buscar su reserva:");

        boolean encontrada = false;

        for (int i = 0; i < auditorio.getContadorReservas(); i++) {
            if (auditorio.getReservas()[i][1].equalsIgnoreCase(nombre)) {
                encontrada = true;

                String detalle = "¿Desea cancelar esta reserva?\n\n"
                        + "Código: " + auditorio.getReservas()[i][0]
                        + "\nNombre: " + auditorio.getReservas()[i][1]
                        + "\nCantidad de espacios: " + auditorio.getReservas()[i][2]
                        + "\nTipo: " + auditorio.getReservas()[i][3]
                        + "\nDía: " + auditorio.getReservas()[i][4];

                int confirmacion = JOptionPane.showConfirmDialog(null, detalle, "Confirmar Cancelación", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    int cantidad = Integer.parseInt(auditorio.getReservas()[i][2]);
                    int dia = Integer.parseInt(auditorio.getReservas()[i][4].split(" ")[1]) - 1;

                    if (auditorio.getReservas()[i][3].equals("Charlas")) {
                        auditorio.getOcupCharlasxDia()[dia] -= cantidad;
                    } else if (auditorio.getReservas()[i][3].equals("Capacitacion")) {
                        auditorio.getOcupCapacitacionesxDia()[dia] -= cantidad;
                    }

                    // Reacomodar las reservas
                    for (int j = i; j < auditorio.getContadorReservas() - 1; j++) {
                        auditorio.getReservas()[j] = auditorio.getReservas()[j + 1];
                    }

                    auditorio.getReservas()[auditorio.getContadorReservas() - 1] = new String[5];
                    auditorio.setContadorReservas(auditorio.getContadorReservas() -1);

                    JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente.");
                    return;
                }
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva con el nombre proporcionado.");
        }
    }
}

