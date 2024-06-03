import java.util.ArrayList;
import java.util.Scanner;

public class Alumno extends Usuario{
    private ArrayList<Materia> materias;
    private int semestre;
    private double promedio;
    private String grupo; //esto puede cambiarse

    public Alumno(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, int semestre, String nombreUsuario, String contrasena) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.ALUMNO, nombreUsuario, contrasena);
        this.materias = new ArrayList<>();
        this.semestre = semestre;
        asignarMaterias(carrera, semestre);
    }

    private void asignarMaterias(Carreras carrera, int semestre) {
        String[] materiasSemestre = Sistema.obtenerMaterias(carrera, semestre);
        for (String nombreMateria : materiasSemestre) {
            materias.add(new Materia(nombreMateria));
        }
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    @Override
    public void verInformacionPersonal() {
        super.verInformacionPersonal();
        System.out.println("Semestre: " + this.semestre);
        System.out.println("Grupo: " + this.grupo);
        System.out.println("Promedio: " + this.promedio);
    }

    public static void modificarAlumno() { //poner trys
        boolean band = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Modificar alumno ----");
        System.out.print("Ingrese el número de control del profesor que desea modificar: ");
        String numero = scanner.nextLine();
        for(Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO)) {
            if(numero.equals(usuario.getNumeroControl())) {
                band = true;
                System.out.print("\nNombre: ");
                String nombre = scanner.nextLine();
                usuario.setNombre(nombre);
                System.out.print("Apellido paterno: ");
                String apellidoP = scanner.nextLine();
                System.out.print("Apellido materno: ");
                String apellidoM = scanner.nextLine();
                usuario.setApellido(apellidoP.concat(" ").concat(apellidoM));
                String fechaNacimiento = validarFecha(); // Método para validar fecha
                usuario.setFechaNacimiento(fechaNacimiento);
                System.out.print("Género (H/M): ");
                String genero = scanner.nextLine().toUpperCase();
                System.out.print("Estado: ");
                String estado = validarEstado(scanner.nextLine());
                usuario.setEstado(estado);
                System.out.print("Ciudad: ");
                String ciudad = scanner.nextLine();
                usuario.setCiudad(ciudad);
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                usuario.setDireccion(direccion);
                String nombreUsuario = registrarNombreUsuario();
                usuario.setNombreUsuario(nombreUsuario);
                String numeroControl = generarNumeroControl(nombre.charAt(0), Rol.ALUMNO);
                usuario.setNumeroControl(numeroControl);
                System.out.print("Contraseña: ");
                String contrasena = scanner.nextLine();
                usuario.setContrasena(contrasena);
                String curp = generarCurp(nombre, apellidoP, apellidoM, fechaNacimiento, genero, estado);
                usuario.setCurp(curp);
            }
        }
        if(!band) {
            System.out.println("\nEste número de control no pertenece a ningún alumno");
        }
    }
}
