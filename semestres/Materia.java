package semestres;
import java.util.Map;

import usuarios.Alumno;

public class Materia {

    private String nombre;
    private double calificacion;
    private Map<Alumno, Double> calificaciones;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.calificacion = -1; // Inicialmente sin calificación, -1 indica que no ha sido calificada.
    }

    public <V, K> Map<K,V> getCalificaciones() {
        return (Map<K, V>) calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 100) {
            this.calificacion = calificacion;
        } else {
            System.out.println("\nCalificación inválida. Debe estar entre 0 y 100.");
        }
    }

    public void mostrarCalificacionesAlumno(Alumno alumno) {
        if (calificaciones.containsKey(alumno)) {
            System.out.println("\nCalificaciones de " + alumno.getNombre() + " para la materia " + this.nombre + ":");
            for (Map.Entry<Alumno, Double> entry : calificaciones.entrySet()) {
                System.out.println(" - " + entry.getValue());
            }
        } else {
            System.out.println("\nEl alumno " + alumno.getNombre() + " no tiene calificación para la materia " + this.nombre);
        }
    }
}

