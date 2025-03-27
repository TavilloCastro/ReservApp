/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectsc;

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
            zonas[totalZonas++] = new zonaRecreativa("B001", "Billar", "Piso 1");
            zonas[totalZonas++] = new zonaRecreativa("B002", "Billar", "Piso 1");
            zonas[totalZonas++] = new zonaRecreativa("PP01", "Ping-Pong", "Piso 2");
            zonas[totalZonas++] = new zonaRecreativa("F001", "Futbolín", "Piso 2");
            zonas[totalZonas++] = new zonaRecreativa("F002", "Futbolín", "Piso 2");
            zonas[totalZonas++] = new zonaRecreativa("F003", "Futbolín", "Piso 2");
            zonas[totalZonas++] = new zonaRecreativa("T001", "Tenis", "Área Deportiva");
            zonas[totalZonas++] = new zonaRecreativa("F5001", "Fútbol 5", "Cancha Exterior");
            zonas[totalZonas++] = new zonaRecreativa("R001", "Rancho", "Jardín");
            
        }
    }

    // Método para mostrar las zonas disponibles
    public void mostrarZonasDisponibles() {
        StringBuilder mensaje = new StringBuilder("Zonas Disponibles:\n");
        for (int i = 0; i < totalZonas; i++) {
            if (zonas[i].isDisponibilidad()) {
                mensaje.append(zonas[i].getIdZona()).append(" - ").append(zonas[i].getTipo()).append(" en ").append(zonas[i].getUbicacion()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Zonas Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para reservar una zona recreativa
    public boolean reservarZona(String idZona, int idEmpleado, String hora) {
        for (int i = 0; i < totalZonas; i++) {
            if (zonas[i].getIdZona().equals(idZona)) {
                return zonas[i].reservar(idEmpleado, hora);
            }
        }
        JOptionPane.showMessageDialog(null, "Zona no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Método para cancelar la reserva de una zona recreativa
    public void cancelarReserva(String idZona) {
        for (int i = 0; i < totalZonas; i++) {
            if (zonas[i].getIdZona().equals(idZona)) {
                zonas[i].cancelarReserva();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Zona no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}