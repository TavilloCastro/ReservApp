package ProyectoFinal;


public class ReservApp {

    public static void main(String[] args) {
        Auditorio auditorio = new Auditorio();
        Parqueos parqueo = new Parqueos(); 
        SistemaCubiculos sistemaCubiculos = new SistemaCubiculos();      
        Reservacion reserva = new Reservacion(auditorio,parqueo, sistemaCubiculos);
        MostrarReservas mostrarReservas = new MostrarReservas(auditorio,parqueo, sistemaCubiculos);
        CancelarReservas cancelarReservas = new CancelarReservas(auditorio,parqueo, sistemaCubiculos);
        MenuPrincipal menuInicio = new MenuPrincipal(auditorio, reserva, mostrarReservas, cancelarReservas);
        menuInicio.mensajeBienvenida();
        menuInicio.menuInicial();
    }

}
