package ProyectoFinal;


public class ReservApp {

    public static void main(String[] args) {
        Auditorio auditorio = new Auditorio();
        Parqueos parqueo = new Parqueos(); 
        Reservacion reserva = new Reservacion(auditorio,parqueo);
        MostrarReservas mostrarReservas = new MostrarReservas(auditorio,parqueo);
        CancelarReservas cancelarReservas = new CancelarReservas(auditorio,parqueo);
        MenuPrincipal menuInicio = new MenuPrincipal(auditorio, reserva, mostrarReservas, cancelarReservas);
        menuInicio.mensajeBienvenida();
        menuInicio.menuInicial();
    }

}