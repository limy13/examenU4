import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Profesor extends Usuario {

    private String rfc;
    private double sueldo;
    private ArrayList<String> materiasImparte;

    public Profesor(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, double sueldo, ArrayList<String> materiasImparte, String rfc) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.PROFESOR);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.materiasImparte = materiasImparte;
    }

    public ArrayList<String> getMateriasImparte() {
        return materiasImparte;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSueldo() {
        return sueldo;
    }

    public static void registrarProfesor() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun= datosComun(Rol.PROFESOR);
        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String fechaNacimiento = datosComun.get(2);
        String estado = datosComun.get(3);
        String ciudad = datosComun.get(4);
        String direccion = datosComun.get(5);
        String curp = datosComun.get(6);
        String nombreUsuario = datosComun.get(7);
        String contrasena = datosComun.get(8);
        String numeroControl = datosComun.get(9);
        System.out.println("Sueldo: ");
        double sueldo = scanner.nextDouble();
        String rfc = generarRfc(fechaNacimiento, nombre, apellidos);
        ArrayList<String> materiasImparte = new ArrayList<>();

        //agregra metodo donde el profe elija sus materias

        Profesor profesor = new Profesor(nombre, apellidos, ciudad, estado, curp.toUpperCase(), direccion, numeroControl, fechaNacimiento, Sistema.carrera, sueldo,  )

        Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR).add(profesor);

    }

    @Override
    public void verInformacionPersonal() {
        super.verInformacionPersonal();
        System.out.println("RFC: " + this.rfc);
        System.out.println("Sueldo: " + this.sueldo);
        //agregar atributo de materias que imparte
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

}
