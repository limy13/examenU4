import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Coordinador extends Usuario {

    private String rfc;
    private double sueldo;
    private String [] materiasImparte;

    public Coordinador(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacmiento, Carreras carrera, double sueldo, String[] materiasImparte, String nombreUsuario, String contrasena) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacmiento, carrera, Rol.COORDINADOR, nombreUsuario, contrasena);
        this.rfc = generarRfc(fechaNacmiento, nombre, apellido);
        this.sueldo = sueldo;
        this.materiasImparte = materiasImparte;
    }

    public static String generarRfc(String fechaNacimiento, String nombre, String apellido) {
        String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
        String rfc;
        Random random = new Random();
        String homoclave = "";
        for (int i = 0; i < 3; i++) {
            char caracter = caracteres.charAt(random.nextInt(caracteres.length()));
            homoclave += caracter;
        }
        String [] partesNacimiento = fechaNacimiento.split("-");
        String [] partesApellido = apellido.split(" ");
        return rfc = ("" + apellido.charAt(0) + apellido.charAt(1) + partesApellido[1].charAt(0) + nombre.charAt(0) +
                partesNacimiento[0].charAt(2) + partesNacimiento[0].charAt(3) + partesNacimiento[1] + partesNacimiento[2] + homoclave).toUpperCase();
    }

    public void verInformacionCoordinador() {
        super.verInformacionPersonal();
        System.out.println("RFC: " + this.rfc);
        System.out.println("Sueldo: " + this.sueldo);
        System.out.println("Materias que imparte: ");
        for (String materia : this.materiasImparte) {
            System.out.println(" - " + materia);
        }
    }

    public void verProfesoresPorCarrera() {
        try {
            ArrayList<Profesor> profesoresCarrera = new ArrayList<>();
            for (Usuario usuario : Sistema.usuarios.get(this.getCarrera()).get(Rol.PROFESOR)) {
                profesoresCarrera.add((Profesor) usuario);
            }

            if (!profesoresCarrera.isEmpty()) {
                System.out.println("\nProfesores de la misma carrera:");
                for (Profesor profesor : profesoresCarrera) {
                    profesor.verInformacionPersonal();
                }
            } else {
                System.out.println("No hay profesores asignados a esta carrera.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar la lista de profesores por carrera. Por favor, intente de nuevo.");
        }
    }

    public static void asignarCalificaciones(Alumno alumno, Map<String, Materia> materiasConCalificaciones) {
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<String, Materia> entry : materiasConCalificaciones.entrySet()) {
            String materiaNombre = entry.getKey();
            Materia materia = entry.getValue();

            // Verificar si la materia ya tiene calificación asignada
            if (materia.getCalificacion() != -1) {
                System.out.println("La materia " + materiaNombre + " ya tiene una calificación asignada.");
                continue; // Saltar a la siguiente materia
            }

            // Solicitar calificación para la materia
            double calificacion;
            do {
                System.out.print("Ingrese la calificación para la materia " + materiaNombre + " del estudiante " + alumno.getNombre() + ": ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Error: la calificación debe ser un número decimal.");
                    scanner.next(); // Descartar la entrada no válida
                }
                calificacion = scanner.nextDouble();
            } while (calificacion < 0 || calificacion > 100);

            materia.setCalificacion(calificacion);
            System.out.println("Calificación asignada correctamente para la materia " + materiaNombre);

            // Almacenar la calificación (opcional)
            // ...
        }
    }
}
