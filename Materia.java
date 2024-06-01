public class Materia {

    private String nombre;
    private double calificacion;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.calificacion = -1; // Inicialmente sin calificación, -1 indica que no ha sido calificada.
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
            System.out.println("Calificación inválida. Debe estar entre 0 y 100.");
        }
    }
}
