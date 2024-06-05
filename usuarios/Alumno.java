package usuarios;
import usuarios.Usuario;
import java.util.*;
import carreras.utils.Carreras;
import semestres.Materia;
import sistema.Sistema;
import usuarios.utils.Rol;

public class Alumno extends Usuario {
    private ArrayList<Materia> materias;
    private int semestre;
    private double promedio;
    private char grupo;
    private ArrayList<Materia> materiasInscritas;
    private HashMap<String, Materia> materiasConCalificaciones;

    public Alumno(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, char grupo, int semestre, String nombreUsuario, String contrasena) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.ALUMNO, nombreUsuario, contrasena);
        this.materias = new ArrayList<>();
        this.semestre = semestre;
        this.materiasConCalificaciones = new HashMap<>();
        this.grupo = grupo;
        this.materiasInscritas = new ArrayList<>();
        asignarMaterias(carrera, semestre);
    }

    private void asignarMaterias(Carreras carrera, int semestre) {
        // Aquí puse un try
        try {
            String[] materiasSemestre = Sistema.obtenerMaterias(carrera, semestre);
            for (String nombreMateria : materiasSemestre) {
                materias.add(new Materia(nombreMateria));
            }
        } catch (Exception e) {
            System.out.println("\nOcurrió un error al asignar materias. Por favor, intente de nuevo.");
        }
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public ArrayList<Materia> getMateriasInscritas() {
        return materiasInscritas;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int numero) {
        semestre = numero;
    }

    public static List<Alumno> filtrarPorSemestre(List<Alumno> alumnos, int semestre) {
        List<Alumno> alumnosFiltrados = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            if (alumno.getSemestre() == semestre) {
                alumnosFiltrados.add(alumno);
            }
        }
        return alumnosFiltrados;
    }

    public void setMateriasInscritas(ArrayList<Materia> materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }

    @Override
    public void verInformacionPersonal() {
        super.verInformacionPersonal();
        System.out.println("Semestre: " + this.semestre);
        System.out.println("Grupo: " + this.grupo);
        System.out.println("Promedio: " + this.promedio);
    }

    public static void modificarAlumno() {
        boolean band = false;
        // Aquí puse un try
        try {
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
                    String fechaNacimiento = Usuario.validarFecha(); // Método para validar fecha
                    usuario.setFechaNacimiento(fechaNacimiento);
                    System.out.print("Género (H/M): ");
                    String genero = scanner.nextLine().toUpperCase();
                    System.out.print("Estado: ");
                    String estado = Usuario.validarEstado(scanner.nextLine());
                    usuario.setEstado(estado);
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    usuario.setCiudad(ciudad);
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    usuario.setDireccion(direccion);
                    String nombreUsuario = Usuario.registrarNombreUsuario();
                    usuario.setNombreUsuario(nombreUsuario);
                    String numeroControl = Usuario.generarNumeroControl(nombre.charAt(0), Rol.ALUMNO);
                    usuario.setNumeroControl(numeroControl);
                    System.out.print("Contraseña: ");
                    String contrasena = scanner.nextLine();
                    usuario.setContrasena(contrasena);
                    String curp = Usuario.generarCurp(nombre, apellidoP, apellidoM, fechaNacimiento, genero, estado);
                    usuario.setCurp(curp);
                }
            }
            if (!band) {
                System.out.println("\nEste número de control no pertenece a ningún alumno");
            }
        } catch (Exception e) {
            System.out.println("\nOcurrió un error al modificar al alumno. Por favor, intente de nuevo.");
        }
    }

    public static void eliminarAlumno() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n---- Eliminar alumno ----");
            System.out.print("Ingrese el número de control del alumno que desea eliminar: ");
            String numero = scanner.nextLine();

            Alumno alumnoAEliminar = null;
            for (Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO)) {
                if (numero.equals(usuario.getNumeroControl())) {
                    alumnoAEliminar = (Alumno) usuario;
                    break;
                }
            }

            if (alumnoAEliminar != null) {
                Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO).remove(alumnoAEliminar);
                System.out.println("\nUsuarios.Alumno eliminado exitosamente.");
            } else {
                System.out.println("\nNo se encontró ningún alumno con el número de control ingresado.");
            }
        } catch (Exception e) {
            System.out.println("\nOcurrió un error al eliminar al alumno. Por favor, intente de nuevo.");
        }
    }

    public void mostrarCalificaciones() {
        System.out.println("Calificaciones de " + this.getNombre() + " " + this.getApellido() + ":");
        for (Map.Entry<String, Materia> entry : materiasConCalificaciones.entrySet()) {
            String materiaNombre = entry.getKey();
            Materia materia = entry.getValue();
            double calificacion = materia.getCalificacion();
            if (calificacion != -1) {
                System.out.println(materiaNombre + ": " + calificacion);
            } else {
                System.out.println(materiaNombre + ": Sin calificar");
            }
        }
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public static void registrarAlumno() {
        // Aquí puse un try
        try {
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
            System.out.println("Inserte el grupo del Alumno (A/B)");
            char grupo = Usuario.validarGrupo();

            Alumno alumno = new Alumno(nombre, apellidos, ciudad, estado, curp.toUpperCase(), direccion, numeroControl, fechaNacimiento, Sistema.carrera, grupo,1, nombreUsuario, contrasena);

            // Asegúrate de que la lista de alumnos para la carrera actual no sea null
            if (!Sistema.usuarios.containsKey(Sistema.carrera)) {
                Sistema.usuarios.put(Sistema.carrera, new HashMap<>());
            }
            if (!Sistema.usuarios.get(Sistema.carrera).containsKey(Rol.ALUMNO)) {
                Sistema.usuarios.get(Sistema.carrera).put(Rol.ALUMNO, new ArrayList<>());
            }

            // Agrega el alumno a la lista correspondiente
            Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO).add(alumno);
        } catch (Exception e) {
            System.out.println("\nOcurrió un error al registrar al alumno. Por favor, intente de nuevo.");
        }
    }
}