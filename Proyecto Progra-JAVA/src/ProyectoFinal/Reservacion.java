package ProyectoFinal;

import javax.swing.JOptionPane;

public class Reservacion {

    //Referencias:
    private Auditorio auditorio;
    private Parqueos parqueo;
    private SistemaCubiculos sistemaCubiculos;
    salaReuniones salaDeReuniones = new salaReuniones();
    SistemaReservas sistemaReservas = new SistemaReservas();
    SistemaRecreativo sistemaRecreativo = new SistemaRecreativo();

   public Reservacion(Auditorio auditorio, Parqueos parqueo, SistemaCubiculos sistemaCubiculos){
       this.auditorio = auditorio;
       this.parqueo = parqueo;
       this.sistemaCubiculos = sistemaCubiculos;

       
   }
    //Crea una reserva:
    public void reservar() {
        int amenidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la amenidad a reservar: \n 1. - Parqueo.\n 2. - Cubiculo.\n 3. - Auditorio.\n 4. - Salon Insonoro.\n 5. - Zona Recreativa.\n 6. - Volver al menu principal."));
        switch (amenidad) {
            case 1:
                parqueo.mostrarDisponibilidad();
                int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel [1-S1, 2-S2, 3-S3]:"));
                int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila del espacio:"));
                int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna del espacio:"));
                parqueo.reservarParqueo(nivel, fila, columna);
                break;
            case 2: // Cubiculo
                this.sistemaCubiculos.reservarCubiculo(); //Llama a sistemaCubiculos.reservarCubiculo.. para iniciar el proceso de reserva.
                break;
            case 3:
                auditorio.auditorio();
                break;
            case 4:
                sistemaReservas.mostrarSalasDisponibles();
                int capacidadDeseada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de la sala que desea reservar (5, 10, 15, 20):"));
                 int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado:"));

                salaReuniones salaSeleccionada = sistemaReservas.buscarSalaPorCapacidad(capacidadDeseada);

                if (salaSeleccionada != null) {
                    salaSeleccionada.reservar(idEmpleado);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay salas disponibles con esa capacidad en este momento.", "Reserva Fallida", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 5:
                sistemaRecreativo.mostrarZonasDisponibles();
                String idZona = JOptionPane.showInputDialog("Ingrese el ID de la zona que desea reservar:");
                int idEmpleadoZona = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de empleado:"));
                String hora = JOptionPane.showInputDialog("Ingrese la hora de la reserva (por ejemplo: 14:00):");

                boolean reservado = sistemaRecreativo.reservarZona(idZona, idEmpleadoZona, hora);
                if (!reservado) {
                    JOptionPane.showMessageDialog(null, "No fue posible realizar la reserva.", "Error", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 6:
                return; //vuelve al menu principal.
            default:
                JOptionPane.showMessageDialog(null, "⚠️Opcion incorrecta.⚠️ \nPor favor intentelo nuevamente [ 1 - 6 ]");
                reservar();
                break;

        }

    }

}
