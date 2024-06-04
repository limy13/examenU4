import java.util.ArrayList;
import java.util.Random;

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
}
