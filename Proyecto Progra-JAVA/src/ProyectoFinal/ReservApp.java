package ProyectoFinal;


public class ReservApp {

    public static void main(String[] args) {
        Auditorio auditorio = new Auditorio();
        Parqueos parqueo = new Parqueos(); 
        SistemaReservas sistemaReservas = new SistemaReservas();
        salaReuniones salaReuniones = new salaReuniones();
        SistemaRecreativo sistemaRecreativo = new SistemaRecreativo();
        
        SistemaCubiculos sistemaCubiculos = new SistemaCubiculos();      
        Reservacion reserva = new Reservacion(auditorio,parqueo, sistemaCubiculos);
        MostrarReservas mostrarReservas = new MostrarReservas(auditorio,parqueo, sistemaCubiculos, sistemaReservas, sistemaRecreativo);
        CancelarReservas cancelarReservas = new CancelarReservas(auditorio,parqueo, sistemaCubiculos, salaReuniones, sistemaRecreativo);
        MenuPrincipal menuInicio = new MenuPrincipal(auditorio, reserva, mostrarReservas, cancelarReservas);
        menuInicio.mensajeBienvenida();
        menuInicio.menuInicial();
    }

}
