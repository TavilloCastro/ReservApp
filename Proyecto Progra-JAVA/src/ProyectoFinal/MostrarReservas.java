package ProyectoFinal;

import javax.swing.JOptionPane;

public class MostrarReservas {
    private Auditorio auditorio;
    private Parqueos parqueo;
    private SistemaCubiculos sistemaCubiculos;
    private SistemaReservas sala;
    private SistemaRecreativo zonas;
     

    public MostrarReservas(Auditorio auditorio,Parqueos parqueo, SistemaCubiculos sistemaCubiculos, SistemaReservas sistemaReservas, SistemaRecreativo sistemaRecreativo){
        this.auditorio = auditorio;
        this.parqueo = parqueo;
        this.sistemaCubiculos = sistemaCubiculos;
        this.sala = sistemaReservas;
        this.zonas = sistemaRecreativo;
      

    }

       //Menu para mostrar reservas
    public void mostrarReservas() {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea consultar: \n 1. - Reservaciones de Parqueo. \n 2. - Reservaciones de Cubiculos.\n 3. - Reservaciones de Auditorio.\n 4. - Reservaciones de Salon Insonoro.\n 5. - Reservaciones de Zonas Recreativas.\n 6. - Regreser al menu anterior."));
        switch (opcion) {
            case 1:
                parqueo.mostrarDisponibilidad();
                break;
            case 2: // Cubiculo
                sistemaCubiculos.mostrarReservasCubiculos();
                break;
            case 3:
                reservasAuditorio(auditorio);
                mostrarReservas();
                break;
            case 4:
                sala.salonReservas();
                mostrarReservas();
                break;
            case 5:
                zonas.zonaReservas();
                mostrarReservas();
                break;
            case 6:
                return;
            default:
                JOptionPane.showMessageDialog(null, "⚠️Opcion incorrecta. Por favor intentelo nuevamente.⚠️ \nDebe seleccionar una opcion del 1 al 6.");
                mostrarReservas();
                break;
        }
    }

    //Metodo para mostrar reservas de Auditorio
    public void reservasAuditorio(Auditorio auditorio) {
        String idEmpleado = JOptionPane.showInputDialog("Ingrese el codigo de la reservacion: ");

        //Busca la reserva correspondiente
        boolean reservaEncontrada = false;
        String infoReserva = "";

        for (int i = 0; i < auditorio.getContadorReservas(); i++) {
            if (auditorio.getReservas()[i][0].equals(idEmpleado)) {
                reservaEncontrada = true;
                
                String diaTexto = auditorio.getReservas()[i][4];
                int numeroDia = Integer.parseInt(diaTexto.split(" ")[1]);
                String nombreDelDia = auditorio.nombreDia(numeroDia);
                
                infoReserva = "Informacion de la reserva " + idEmpleado + ":"
                        + "\n- Nombre: " + auditorio.getReservas()[i][1]
                        + "\n- Actividad: " + auditorio.getReservas()[i][3]
                        + "\n- Dia: " + nombreDelDia
                        + "\n- Cantidad de Espacios: " + auditorio.getReservas()[i][2];
                        
            }
        }
        //Mensaje de reserva
        if (reservaEncontrada) {
            JOptionPane.showMessageDialog(null, infoReserva, "Reservas Encontradas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva con el código de reserva: " + idEmpleado, "Reserva No Encontrada", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Metodo para mostrar reservas de parqueo
    public void reservasParqueo() {

    }

    //Metodo para mostrar reservas de cubiculo
    public void reservasCubiculo() {

    }

    //Metodo para mostrar reservas de salon insonoro
    public void reservasSalon() {

    }

    //Metodo para mostrar reservas de zonas recreativas
    public void reservasZonasRecreativas() {

    }
}
