package ProyectoFinal;

import javax.swing.JOptionPane;

public class ReservApp {

    public static void main(String[] args) {
        MenuPrincipal menuInicio = new MenuPrincipal();
        Auditorio auditorio = new Auditorio();
        MostrarReservas mostrarReservas = new MostrarReservas(auditorio);
        menuInicio.mensajeBienvenida();
        menuInicio.menuInicial();
    }

}



/*
*************** Notas ***************
Gustavo: 
    - Puedo generar reservaciones, pero no logro mostrar la informacion de la reserva. Estoy creando / sobre escribiendo informacion? 
*/