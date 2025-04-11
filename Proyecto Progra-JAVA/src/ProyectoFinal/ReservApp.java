package ProyectoFinal;

import javax.swing.JOptionPane;

public class ReservApp {

    public static void main(String[] args) {
        Auditorio auditorio = new Auditorio();
        Reservacion reserva = new Reservacion(auditorio);
        MostrarReservas mostrarReservas = new MostrarReservas(auditorio);
        CancelarReservas cancelarReservas = new CancelarReservas(auditorio);
        MenuPrincipal menuInicio = new MenuPrincipal(auditorio, reserva, mostrarReservas, cancelarReservas);
        menuInicio.mensajeBienvenida();
        menuInicio.menuInicial();
    }

}