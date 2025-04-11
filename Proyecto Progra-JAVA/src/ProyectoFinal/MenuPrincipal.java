package ProyectoFinal;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    
    //Llamados a las clases para usar los metodos:    
    private Auditorio auditorio;
    private Reservacion reserva;
    private Empleado empleado = new Empleado("", "", "", "");
    private MostrarReservas mostrarReservas;

    public MenuPrincipal(Auditorio auditorio, Reservacion reserva, MostrarReservas mostrarReservas) {
        this.auditorio = auditorio;
        this.reserva = reserva;
        this.mostrarReservas = mostrarReservas;
    }
    
    //Metodo para terminar el programa:
    private void salir() {
        JOptionPane.showMessageDialog(null, "⚠️Saliendo del programa...⚠️\nGracias por utilizar ReservApp 👋🏼", "\nGracias por utilizar ReservApp.", JOptionPane.QUESTION_MESSAGE);
    }

    //Mensaje de bienvenida:
    public void mensajeBienvenida() {
        JOptionPane.showMessageDialog(null, "Bienvenid@s al sistema de Reservas\n"
                + "           [  ReservApp  ]");
    }

    //Menu Principal:
    public void menuInicial() {
        int opcionMenuInicial = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Principal\n\n 1. - Reservar Amenidad.\n 2. - Cancelar Reservas.\n 3. - Mostrar Reservas.\n 4. - Usuarios Registrados.\n 5. - Salir."));

        switch (opcionMenuInicial) {
            case 1:
                reserva.reservar();//Llama al metodo para reservar. 
                menuInicial();
                break;
            case 2:
               
                menuInicial();
                break;
            case 3:
                mostrarReservas.mostrarReservas();//Llama al metodo para mostrar las reservas. 
                menuInicial();
                break;
            case 4:
                empleado.tablaEmpleados(); //Llama al metodo que muestra la lista de empleados. 
                menuInicial();
                break;
            case 5:
                salir();
                break;
            default:
                JOptionPane.showMessageDialog(null, "⚠️Opcion Incorrecta, intente nuevamente.⚠️");
                menuInicial();
                break;

        }

    }

}
