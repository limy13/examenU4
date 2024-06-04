import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Alumno extends Usuario {
    private ArrayList<Materia> materias;
    private int semestre;
    private double promedio;
    private String grupo;
    private ArrayList<Materia> materiasInscritas;

    public Alumno(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, int semestre, String nombreUsuario, String contrasena) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.ALUMNO, nombreUsuario, contrasena);
        this.materias = new ArrayList<>();
        this.semestre = semestre;

        this.materiasInscritas = new ArrayList<>();
        asignarMaterias(carrera, semestre);
    }

    private void asignarMaterias(Carreras carrera, int semestre) {
        String[] materiasSemestre = Sistema.obtenerMaterias(carrera, semestre);
        for (String nombreMateria : materiasSemestre) {
            materias.add(new Materia(nombreMateria));
        }
    }

    public ArrayList<Materia> getMaterias() { return materias;}

    public ArrayList<Materia> getMateriasInscritas() { return materiasInscritas; }

    public void setMateriasInscritas(ArrayList<Materia> materiasInscritas) {this.materiasInscritas = materiasInscritas;}

    @Override
    public void verInformacionPersonal() {
        super.verInformacionPersonal();
        System.out.println("Semestre: " + this.semestre);
        System.out.println("Grupo: " + this.grupo);
        System.out.println("Promedio: " + this.promedio);
    }

    public static void registrarAlumno() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = Usuario.datosComun(Rol.ALUMNO);
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

        System.out.print("Ingrese el semestre del alumno: ");
        int semestre = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt()

        Alumno alumno = new Alumno(nombre, apellidos, ciudad, estado, curp.toUpperCase(), direccion, numeroControl, fechaNacimiento, Sistema.carrera, semestre, nombreUsuario, contrasena);

        // Asegúrate de que la lista de alumnos para la carrera actual no sea null
        if (!Sistema.usuarios.containsKey(Sistema.carrera)) {
            Sistema.usuarios.put(Sistema.carrera, new HashMap<>());
        }
        if (!Sistema.usuarios.get(Sistema.carrera).containsKey(Rol.ALUMNO)) {
            Sistema.usuarios.get(Sistema.carrera).put(Rol.ALUMNO, new ArrayList<>());
        }

        // Agrega el alumno a la lista correspondiente
        Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO).add(alumno);
    }

    public static void modificarAlumno() {
        boolean band = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Modificar alumno ----");
        System.out.print("Ingrese el número de control del alumno que desea modificar: ");
        String numero = scanner.nextLine();
        for (Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO)) {
            if (numero.equals(usuario.getNumeroControl())) {
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
        if (!band) {
            System.out.println("\nEste número de control no pertenece a ningún alumno");
        }
    }
}