import javax.swing.JOptionPane;

public class Parqueos {
    static char[][] S1 = new char[4][5]; // Nivel S1
    static char[][] S2 = new char[5][5]; // Nivel S2
    static char[][] S3 = new char[6][5]; // Nivel S3

    public static void main(String[] args) {
        inicializarParqueo(S1);
        inicializarParqueo(S2);
        inicializarParqueo(S3);

        int opcion;

        do {
            String input = JOptionPane.showInputDialog(
                null,
                "Sistema de Parqueo\n" +
                "1. Ver parqueo\n" +
                "2. Ocupar espacio\n" +
                "3. Liberar espacio\n" +
                "4. Salir\n\n" +
                "Seleccione una opción:"
            );

            if (input == null) break; // Si se cierra el diálogo

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                continue; // Si la opción no es un número
            }

            switch (opcion) {
                case 1:
                    mostrarParqueo(); // Mostrar estado del parqueo
                    break;
                case 2:
                    cambiarEstado('P'); // Ocupar espacio
                    break;
                case 3:
                    cambiarEstado('O'); // Liberar espacio
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema..."); // Mensaje de salida
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida."); // Opción no válida
            }

        } while (true); // Ciclo infinito hasta salir
    }

    // Inicializa los niveles del parqueo con espacios libres, discapacitados y ejecutivos
    static void inicializarParqueo(char[][] nivel) {
        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[i].length; j++) {
                if (i == 0) {
                    nivel[i][j] = 'D'; // Fila 0 para discapacitados
                } else if (i == nivel.length - 1) {
                    nivel[i][j] = 'E'; // Última fila para ejecutivos
                } else {
                    nivel[i][j] = 'O'; // O = libre
                }
            }
        }
    }

    // Muestra el estado de todos los niveles
    static void mostrarParqueo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nivel S1:\n").append(imprimirNivel(S1));
        sb.append("\nNivel S2:\n").append(imprimirNivel(S2));
        sb.append("\nNivel S3:\n").append(imprimirNivel(S3));
        JOptionPane.showMessageDialog(null, sb.toString()); // Mostrar el estado del parqueo
    }

    // Convierte un nivel en una cadena de texto
    static String imprimirNivel(char[][] nivel) {
        StringBuilder sb = new StringBuilder();
        for (char[] fila : nivel) {
            for (char espacio : fila) {
                sb.append("| ").append(espacio).append(" "); // Formato de salida
            }
            sb.append("|\n"); // Fin de la fila
        }
        return sb.toString(); // Devuelve el nivel como texto
    }

    // Cambia el estado de un espacio (ocupar o liberar), con validaciones
    static void cambiarEstado(char nuevoEstado) {
        try {
            int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel (1, 2, 3):"));
            char[][] parqueo = getNivel(nivel); // Obtener la matriz correspondiente

            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la fila (0-" + (parqueo.length - 1) + "):"));
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la columna (0-" + (parqueo[0].length - 1) + "):"));

            // Validar ubicación
            if (fila < 0 || fila >= parqueo.length || columna < 0 || columna >= parqueo[0].length) {
                JOptionPane.showMessageDialog(null, "Ubicación fuera de rango.");
                return;
            }

            char actual = parqueo[fila][columna];

            // Validar si es espacio reservado para ejecutivos
            if (actual == 'E') {
                JOptionPane.showMessageDialog(null, "Este espacio está reservado para ejecutivos y no se puede modificar.");
                return;
            }

            // Preguntar si es persona con discapacidad antes de ocupar espacio
            if (nuevoEstado == 'P' && actual == 'D') {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Eres una persona con discapacidad?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (respuesta != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "No puedes ocupar este espacio reservado.");
                    return; // No se permite ocupar el espacio reservado si no se es discapacitado
                }
            }

            // Validaciones según estado actual y nuevo estado
            if (nuevoEstado == 'P' && actual == 'P') {
                JOptionPane.showMessageDialog(null, "Este espacio ya está ocupado.");
            } else if (nuevoEstado == 'O' && actual == 'O') {
                JOptionPane.showMessageDialog(null, "Este espacio ya está libre.");
            } else {
                parqueo[fila][columna] = nuevoEstado; // Actualiza el estado del espacio
                JOptionPane.showMessageDialog(null, "Espacio actualizado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada. Intente de nuevo.");
        }
    }

    // Devuelve la matriz correspondiente al nivel
    static char[][] getNivel(int nivel) {
        switch (nivel) {
            case 1: return S1; // Nivel S1
            case 2: return S2; // Nivel S2
            case 3: return S3; // Nivel S3
            default: return S1; // Por defecto, devuelve S1
        }
    }
}