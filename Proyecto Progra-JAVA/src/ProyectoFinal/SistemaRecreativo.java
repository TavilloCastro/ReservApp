/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoFinal;

import javax.swing.JOptionPane;

/**
 *
 * @author alvarados
 */
public class SistemaRecreativo {
    private zonaRecreativa[] zonas;
    private int totalZonas;

    public SistemaRecreativo() {
        this.zonas = new zonaRecreativa[9]; // 9 zonas recreativas
        this.totalZonas = 0;
        inicializarZonas();
    }

    private void inicializarZonas() {
        // Inicializar las zonas recreativas de acuerdo al número total que tenemos (9 en este caso)
        if (totalZonas < 9) {
            zonas[totalZonas++] = new zonaRecreativa("ACB1", "Billar", "Area comun");
            zonas[totalZonas++] = new zonaRecreativa("ACB2", "Billar", "Area comun");
            zonas[totalZonas++] = new zonaRecreativa("CPP1", "Ping-Pong", "Comedor");
            zonas[totalZonas++] = new zonaRecreativa("ACF1", "Futbolin", "Area comun");
            zonas[totalZonas++] = new zonaRecreativa("ACF2", "Futbolin", "Area comun");
            zonas[totalZonas++] = new zonaRecreativa("CF1", "Futbolin", "Comedor");
            zonas[totalZonas++] = new zonaRecreativa("ET1", "Tenis", "Exterior");
            zonas[totalZonas++] = new zonaRecreativa("EF1", "Fútbol 5", "Exterior");
            zonas[totalZonas++] = new zonaRecreativa("TR1", "Rancho", "Terraza");
            
        }
    }

    
    public void mostrarZonasDisponibles() {
        StringBuilder mensaje = new StringBuilder("Zonas Disponibles:\n");
        for (int i = 0; i < totalZonas; i++) {
            if (zonas[i].isDisponibilidad()) {
                mensaje.append(zonas[i].getIdZona()).append(" - ").append(zonas[i].getTipo()).append(" en ").append(zonas[i].getUbicacion()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Zonas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }
    

    
    public boolean reservarZona(String idZona, int idEmpleado, String hora) {
        for (int i = 0; i < totalZonas; i++) {
            if (zonas[i].getIdZona().equals(idZona)) {
                return zonas[i].reservar(idEmpleado, hora);
            }
        }
        JOptionPane.showMessageDialog(null, "Zona no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    public void zonaReservas(){
        String mensaje = "Zonas Reservadas: \n";
        boolean hayReservas = false;
        for(int i=0; i < totalZonas; i++){
            if(!zonas[i].isDisponibilidad()){
                mensaje += "ID: " + zonas[i].getIdZona()
                        + " | Tipo: " + zonas[i].getTipo()
                        + " | Numero: " + zonas[i].getUbicacion()
                        + " | Hora: " + zonas[i].getHoraReservada()
                        + " | ID Empleado: " + zonas[i].getIdEmpleadoReservado()
                        + " \n";
                hayReservas = true;
                       
            }
        }
    }
}

    

    

