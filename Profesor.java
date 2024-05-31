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
        int x = 1;
        for(String materia : Sistema.materias.get(carrera)) {
            System.out.println("\n---- Materias disponibles ----");
            System.out.println(x + ". " + materia);
            x++;
        }
        System.out.println("\nElija las materias que imparte: ");
        int decision = scanner.nextInt(); //try aqui
        String materia = Sistema.materias.get(carrera)[decision - 1];

        for(String i : materiasImparte) {
            if(i.equals(materia)) {
                System.out.println("\nUsted ya imparte esta clase");
            }
            else {
                switch(decision) {

                    case 1:
                        materiasImparte.add(Sistema.materias.get(carrera)[0]);
                        break;

                    case 2:
                        materiasImparte.add(Sistema.materias.get(carrera)[1]);
                        break;

                    case 3:
                        materiasImparte.add(Sistema.materias.get(carrera)[2]);
                        break;

                    case 4:
                        materiasImparte.add(Sistema.materias.get(carrera)[3]);
                        break;

                    case 5:
                        materiasImparte.add(Sistema.materias.get(carrera)[4]);
                        break;

                    case 6:
                        materiasImparte.add(Sistema.materias.get(carrera)[5]);
                        break;

                    case 7:
                        materiasImparte.add(Sistema.materias.get(carrera)[6]);
                        break;

                    case 8:
                        materiasImparte.add(Sistema.materias.get(carrera)[7]);
                        break;

                    case 9:
                        materiasImparte.add(Sistema.materias.get(carrera)[8]);
                        break;
                }
            }
        }





    }


}
