package ProyectoFinal;

import javax.swing.JOptionPane;

public class Parqueos {

    private char[][][] parqueo; // P = ocupado, O = libre, D = directores, E = discapacitados
    private static final int NUM_NIVELES = 3;
    
    private static final int[] FILAS_POR_NIVEL = {4, 5, 6};
    private static final int[] COLUMNAS_POR_NIVEL = {5, 5, 6};

    private static final int ESPACIOS_DISCAPACITADOS = 3;
    private static final int ESPACIOS_DIRECTORES = 3;

    public Parqueos() {
        parqueo = new char[NUM_NIVELES][][];

        for (int nivel = 0; nivel < NUM_NIVELES; nivel++) {
            int filas = FILAS_POR_NIVEL[nivel];
            int columnas = COLUMNAS_POR_NIVEL[nivel];
            parqueo[nivel] = new char[filas][columnas];

            int discapacitadosAsignados = 0;
            int directoresAsignados = 0;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (discapacitadosAsignados < ESPACIOS_DISCAPACITADOS) {
                        parqueo[nivel][i][j] = 'E';
                        discapacitadosAsignados++;
                    } else if (directoresAsignados < ESPACIOS_DIRECTORES) {
                        parqueo[nivel][i][j] = 'D';
                        directoresAsignados++;
                    } else {
                        parqueo[nivel][i][j] = 'O';
                    }
                }
            }
        }
    }

    public void reservarParqueo(int nivel, int fila, int columna) {
        if (!validarPosicion(nivel, fila, columna)) return;

        char espacio = parqueo[nivel - 1][fila - 1][columna - 1];

        if (espacio == 'P') {
            JOptionPane.showMessageDialog(null, "Este espacio ya está ocupado.");
        } else {
            parqueo[nivel - 1][fila - 1][columna - 1] = 'P';
            JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.");
        }
    }

    public void liberarParqueo(int nivel, int fila, int columna) {
        if (!validarPosicion(nivel, fila, columna)) return;

        char espacio = parqueo[nivel - 1][fila - 1][columna - 1];

        if (espacio != 'P') {
            JOptionPane.showMessageDialog(null, "Este espacio no está ocupado.");
        } else {
            // Restaurar a tipo original si estaba reservado (lo buscamos basado en posición)
            int indexNivel = nivel - 1;
            int pos = fila * COLUMNAS_POR_NIVEL[indexNivel] + columna;

            if (esDiscapacitadoInicial(indexNivel, fila - 1, columna - 1)) {
                parqueo[indexNivel][fila - 1][columna - 1] = 'E';
            } else if (esDirectorInicial(indexNivel, fila - 1, columna - 1)) {
                parqueo[indexNivel][fila - 1][columna - 1] = 'D';
            } else {
                parqueo[indexNivel][fila - 1][columna - 1] = 'O';
            }

            JOptionPane.showMessageDialog(null, "Reserva cancelada con éxito.");
        }
    }

    public void mostrarDisponibilidad() {
        StringBuilder disponibilidad = new StringBuilder("Disponibilidad de Parqueo:\n\n");

        for (int nivel = 0; nivel < NUM_NIVELES; nivel++) {
            disponibilidad.append("Nivel ").append(nivel + 1).append(":\n");
            for (int i = 0; i < FILAS_POR_NIVEL[nivel]; i++) {
                for (int j = 0; j < COLUMNAS_POR_NIVEL[nivel]; j++) {
                    disponibilidad.append(parqueo[nivel][i][j]).append(" ");
                }
                disponibilidad.append("\n");
            }
            disponibilidad.append("\n");
        }

        JOptionPane.showMessageDialog(null, disponibilidad.toString());
    }

    private boolean validarPosicion(int nivel, int fila, int columna) {
        if (nivel < 1 || nivel > NUM_NIVELES || 
            fila < 1 || fila > FILAS_POR_NIVEL[nivel - 1] || 
            columna < 1 || columna > COLUMNAS_POR_NIVEL[nivel - 1]) {
            JOptionPane.showMessageDialog(null, "Posición inválida.");
            return false;
        }
        return true;
    }

    private boolean esDiscapacitadoInicial(int nivel, int fila, int columna) {
        int contador = 0;
        for (int i = 0; i < FILAS_POR_NIVEL[nivel]; i++) {
            for (int j = 0; j < COLUMNAS_POR_NIVEL[nivel]; j++) {
                if (contador < ESPACIOS_DISCAPACITADOS) {
                    if (i == fila && j == columna) return true;
                    contador++;
                }
            }
        }
        return false;
    }

    private boolean esDirectorInicial(int nivel, int fila, int columna) {
        int contador = 0;
        boolean discapacitadosListos = false;
        for (int i = 0; i < FILAS_POR_NIVEL[nivel]; i++) {
            for (int j = 0; j < COLUMNAS_POR_NIVEL[nivel]; j++) {
                if (!discapacitadosListos && contador >= ESPACIOS_DISCAPACITADOS) {
                    discapacitadosListos = true;
                    contador = 0;
                }

                if (discapacitadosListos && contador < ESPACIOS_DIRECTORES) {
                    if (i == fila && j == columna) return true;
                    contador++;
                } else if (!discapacitadosListos) {
                    contador++;
                }
            }
        }
        return false;
    }
}