package ProyectoFinal;

/*
Aqui se deberan efectuar las reservaciones y visibilidad de las mismas. 
 */
import javax.swing.JOptionPane;

public class Reservacion {
    
    

    //Referencias:
    Auditorio auditorio = new Auditorio();
  
    //Metodo para llamar la clase Reservacion
    public Reservacion() {
    }

    //Crea una reserva:
    public void reservar() {
        int amenidad = Integer.parseInt(JOptionPane.showInputDialog("Indique la amenidad a reservar: \n [ 1 ]- Parqueo.\n [ 2 ]- Cubiculo.\n [ 3 ]- Auditorio.\n [ 4 ]- Salon Insonoro.\n [ 5 ]- Zona Recreativa.\n [ 6 ]- Volver al menu principal."));
        switch (amenidad) { //NOTA: PODRIA HACER UN LOOP DEPENDIENDO DE LA CANTIDAD DE RESERVAS QUE QUIERA EL USUARIO EN CADA CATEGORIA. 
            /*case 1:
                metodoParqueo;
                reservar();
                break;
            case 2:
                metodoCubiculo();
                reservar();
                break;*/
            case 3:
                auditorio.auditorio();
                reservar();
                break;
            /*case 4:
                metodoSalonInsonoro();
                reservar();
                break;
            case 5:
                metodoZonaRecreativa();
                reservar();
                break;
            case 6:
                menuPrincipal.menuInicial();
                reservar();
                break;*/
            default:
                JOptionPane.showMessageDialog(null, "Opcion incorrecta. \nPor favor intentelo nuevamente [ 1 - 6 ]");
                reservar();
                break;

        }

    }

    //Cancela una reserva
    public void cancelarReservas() {

    }

    //Muestra reservas
    public void mostrarReservas() {

    }

}
