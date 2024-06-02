import java.util.ArrayList;

public class Coordinador extends Usuario {

    private String rfc;
    private double sueldo;
    private ArrayList<String> materiasImparte;

    public Coordinador(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, int anoNacimiento, Carreras carrera, double sueldo, ArrayList<String> materiasImparte, String rfc) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, anoNacimiento, carrera, Rol.COORDINADOR);
        this.rfc = rfc;
        this.sueldo = sueldo;
        this.materiasImparte = materiasImparte;
    }
}
