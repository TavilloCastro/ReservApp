/*
 Informacion de los usuarios. 
 */
package ProyectoFinal;

import javax.swing.JOptionPane;

public class Empleado {

    //Info de Empleados: 
    private String id;
    private String nombre;
    private String apellidos;
    private String departamento;

    public Empleado(String id, String nombre, String apellidos, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

//Arreglo estatico de los empleados:
    public static final Empleado[] empleados = {
        new Empleado("v01098", "Gustavo", "Castro Azofeifa", "Virtualizacion"),
        new Empleado("c05312", "Gabriel", "Gomez Gutierrez", "Cyberseguridad"),
        new Empleado("t03975", "Bryan", "Obando Nicundano", "TI"),
        new Empleado("ml02470", "Edward", "Sanchez Alvarado", "Machine Learning")
    };

    //Mostrar informacion del empleado:
    public void tablaEmpleados() {
        String tabla = "ID         Nombre     Apellidos                Departamento\n"
                + "-----------------------------------------------------------\n";

        for (Empleado empleado : empleados) {
            tabla += empleado.id + " | " + empleado.nombre + " " + empleado.apellidos + " | " + empleado.departamento + "\n";

        }
        JOptionPane.showMessageDialog(null, tabla, "Usuarios Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

}
