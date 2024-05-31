import java.util.ArrayList;
import java.util.Scanner;

public class Profesor extends Usuario {

    private String rfc;
    private double sueldo;
    private ArrayList<String> materiasImparte;

    public Profesor(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, int anoNacimiento, Carreras carrera, double sueldo, ArrayList<String> materiasImparte, String rfc) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, anoNacimiento, carrera);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.materiasImparte = materiasImparte;
    }

    public ArrayList<String> getMateriasImparte() {
        return materiasImparte;
    }

    public static void registrarProfesor() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun= datosComun(Rol.PROFESOR);
        String nombre = datosComun.get(0);
        String apellidos = datosComun.get(1);
        String [] fechaNacimiento = datosComun.get(2).split("-");
        String estado = datosComun.get(3);
        String ciudad = datosComun.get(4);
        String direccion = datosComun.get(5);
        String curp = datosComun.get(6);
        String nombreUsuario = datosComun.get(7);
        String contrasena = datosComun.get(8);
        String numeroControl = datosComun.get(9);
        System.out.println("Sueldo: ");
        double sueldo = scanner.nextDouble();
        Carreras carrera = Sistema.carrera;
        ArrayList<String> materiasImparte = new ArrayList<>();

    }
}
