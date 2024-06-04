import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Profesor extends Usuario {

    private String rfc;
    private double sueldo;
    private ArrayList<String> materiasImparte;

    public Profesor(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, double sueldo, ArrayList<String> materiasImparte, String rfc, String nombreUsuario, String contrasena) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.PROFESOR, nombreUsuario, contrasena);
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

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public static void registrarProfesor() {
        // Aquí puse un try
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> datosComun = datosComun(Rol.PROFESOR);
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
            System.out.print("Sueldo: ");
            double sueldo = scanner.nextDouble();
            String rfc = generarRfc(fechaNacimiento, nombre, apellidos);
            ArrayList<String> materiasImparte = new ArrayList<>();

            //agregar metodo donde el profe elija sus materias

            Profesor profesor = new Profesor(nombre, apellidos, ciudad, estado, curp.toUpperCase(), direccion, numeroControl, fechaNacimiento, Sistema.carrera, sueldo, materiasImparte, rfc, nombreUsuario, contrasena);

            if (!Sistema.usuarios.containsKey(Sistema.carrera)) {
                Sistema.usuarios.put(Sistema.carrera, new HashMap<>());
            }
            if (!Sistema.usuarios.get(Sistema.carrera).containsKey(Rol.PROFESOR)) {
                Sistema.usuarios.get(Sistema.carrera).put(Rol.PROFESOR, new ArrayList<>());
            }

            Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR).add(profesor);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al registrar al profesor. Por favor, intente de nuevo.");
        }
    }

    @Override
    public void verInformacionPersonal() {
        // Aquí puse un try
        try {
            super.verInformacionPersonal();
            System.out.println("RFC: " + this.rfc);
            System.out.println("Sueldo: " + this.sueldo);
            System.out.println("Materias que imparte: " + String.join(", ", this.materiasImparte));
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar la información personal del profesor. Por favor, intente de nuevo.");
        }
    }

    public static String generarRfc(String fechaNacimiento, String nombre, String apellido) {
        // Aquí puse un try
        try {
            String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
            String rfc;
            Random random = new Random();
            String homoclave = "";
            for (int i = 0; i < 3; i++) {
                char caracter = caracteres.charAt(random.nextInt(caracteres.length()));
                homoclave += caracter;
            }
            String[] partesNacimiento = fechaNacimiento.split("-");
            String[] partesApellido = apellido.split(" ");
            return rfc = ("" + apellido.charAt(0) + apellido.charAt(1) + partesApellido[1].charAt(0) + nombre.charAt(0) +
                    partesNacimiento[0].charAt(2) + partesNacimiento[0].charAt(3) + partesNacimiento[1] + partesNacimiento[2] + homoclave).toUpperCase();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al generar el RFC. Por favor, intente de nuevo.");
            return null;
        }
    }

    public static void modificarProfesor() {
        boolean band = false;
        // Aquí puse un try
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n---- Modificar profesor ----");
            System.out.print("\nIngrese el número de control del profesor que desea modificar: ");
            String numero = scanner.nextLine();
            for (Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR)) {
                if (numero.equals(usuario.getNumeroControl())) {
                    band = true;
                    Profesor profesor = (Profesor) usuario;
                    System.out.print("\nNombre: ");
                    String nombre = scanner.nextLine();
                    profesor.setNombre(nombre);
                    System.out.print("Apellido paterno: ");
                    String apellidoP = scanner.nextLine();
                    System.out.print("Apellido materno: ");
                    String apellidoM = scanner.nextLine();
                    profesor.setApellido(apellidoP.concat(" ").concat(apellidoM));
                    String fechaNacimiento = validarFecha(); // Método para validar fecha
                    profesor.setFechaNacimiento(fechaNacimiento);
                    System.out.print("Género (H/M): ");
                    String genero = scanner.nextLine().toUpperCase();
                    System.out.print("Estado: ");
                    String estado = validarEstado(scanner.nextLine());
                    profesor.setEstado(estado);
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    profesor.setCiudad(ciudad);
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    profesor.setDireccion(direccion);
                    String nombreUsuario = registrarNombreUsuario();
                    profesor.setNombreUsuario(nombreUsuario);
                    String numeroControl = generarNumeroControl(nombre.charAt(0), Rol.ALUMNO);
                    profesor.setNumeroControl(numeroControl);
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    profesor.setContrasena(contrasena);
                    String curp = generarCurp(nombre, apellidoP, apellidoM, fechaNacimiento, genero, estado);
                    profesor.setCurp(curp);
                    System.out.println("Sueldo: ");
                    double sueldo = scanner.nextDouble();
                    profesor.setSueldo(sueldo);
                    String rfc = generarRfc(fechaNacimiento, nombre, apellidoP.concat(" ").concat(apellidoM));
                    profesor.setRfc(rfc);

                    //agregar metodo para que modifique sus materias
                }
            }
            if (!band) {
                System.out.println("\nEste número de control no pertenece a ningún profesor");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar al profesor. Por favor, intente de nuevo.");
        }
    }

    public void verInformacionProfesor() {
        // Aquí puse un try
        try {
            super.verInformacionPersonal();
            System.out.println("RFC: " + this.rfc);
            System.out.println("Sueldo: " + this.sueldo);
            System.out.println("Materias que imparte: " + String.join(", ", this.materiasImparte));
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar la información del profesor. Por favor, intente de nuevo.");
        }
    }

    public static void eliminarProfesor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n---- Eliminar Profesor ----");
            System.out.print("Ingrese el número de control del profesor que desea eliminar: ");
            String numero = scanner.nextLine();

            Profesor profesorAEliminar = null;
            for (Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR)) {
                if (numero.equals(usuario.getNumeroControl())) {
                    profesorAEliminar = (Profesor) usuario;
                    break;
                }
            }

            if (profesorAEliminar != null) {
                Sistema.usuarios.get(Sistema.carrera).get(Rol.PROFESOR).remove(profesorAEliminar);
                System.out.println("\nAlumno eliminado exitosamente.");
            } else {
                System.out.println("\nNo se encontró ningún alumno con el número de control ingresado");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al eliminar al alumno. Por favor, intente de nuevo");
        }
    }
}