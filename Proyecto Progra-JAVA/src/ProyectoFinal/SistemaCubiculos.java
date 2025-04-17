package ProyectoFinal;

import javax.swing.JOptionPane;

/**
 *
 * @author bryan
 */
public class SistemaCubiculos {
    private Cubiculos[] cubiculos; //Arreglo para almacenar todos los cubículos disponibles en el sistema

    public SistemaCubiculos() {
        cubiculos = new Cubiculos[10]; //crea un arreglo de 10 posiciones para almacenar
        for (int i = 0; i < 10; i++) {  // Inicia bucle y crea una nueva instancia para cada posicion y asigna ID unico
            cubiculos[i] = new Cubiculos("CUB-" + (i+1));
        }
    }

    // Este metodo es llamado desde Reservacion
    // Aca se ve la lista de los cubículos con su estado. Pide al usuario: ID del cubiculo, ID del empleado y hora.
    // Busca el cubiculo y llama a su metodo reservar(), Si no encuentra el cubiculo, muestra que no se ha encontrado.
    public void reservarCubiculo() {
        String lista = "CUBICULOS DISPONIBLES:\n";
        for (Cubiculos c : cubiculos) {
            lista += c.getIdCubiculo() + ": " + (c.isDisponibilidad() ? "DISPONIBLE" : "OCUPADO") + "\n";
        }
        
        String idCubiculo = JOptionPane.showInputDialog(lista + "\nIngrese el ID del cubiculo (ej: CUB-1):");
        String idEmpleado = JOptionPane.showInputDialog("Ingrese el ID de empleado (ej: t03975):");
        String hora = JOptionPane.showInputDialog("Horas validas: 09:00 a 18:00\nIngrese hora:");
        for (Cubiculos c : cubiculos) {
            if (c.getIdCubiculo().equalsIgnoreCase(idCubiculo)) {
                c.reservar(idEmpleado, hora);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El cubiculo no se ha encontrado");
    }

    // Este metodo es llamado desde CancelarReservas
    // Pide el ID del cubiculo a cancelar
    public void cancelarReservaCubiculo() {
        String idCubiculo = JOptionPane.showInputDialog("Ingrese el ID del cubiculo que desea cancelar (ej: CUB-1):");        
        for (Cubiculos c : cubiculos) {
            if (c.getIdCubiculo().equalsIgnoreCase(idCubiculo)) {
                if (c.isDisponibilidad()) {
                    JOptionPane.showMessageDialog(null, "Este cubiculo no tiene reservas activas");
                } else {
                    c.cancelarReserva();
                    JOptionPane.showMessageDialog(null, "La reserva ha sido cancelada con exito");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "El cubiculo no se ha encontrado");
    }

    // Este metodo es llamado desde MostrarReservas
    // Recorre todos los cubiculos, Para cada cubiculo ocupado, muestra id cub, empleado y hora
    public void mostrarReservasCubiculos() {
        String reservas = "RESERVAS ACTIVAS DE CUBICULOS:\n\n";
        boolean hayReservas = false;       
        for (Cubiculos c : cubiculos) {
            if (!c.isDisponibilidad()) {
                reservas += c.getIdCubiculo() + " - Empleado: " + c.getIdEmpleadoReservado() + " - Hora: " + c.getHoraReservada() + "\n";
                hayReservas = true;
            }
        }
    // Si no hay reservas, muestra el mensaje
        if (!hayReservas) {
            reservas += "No hay reservas activas";
        }
        
        JOptionPane.showMessageDialog(null, reservas);
    }
}
