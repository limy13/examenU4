

import java.util.*;

public class Sistema {

    public static final Map<Carreras, Map<Rol, ArrayList<Usuario>>> usuarios = new HashMap<>();
    public static Carreras carrera; // Accede a la carrera de la persona que inicia sesion
    public static final Map<Carreras, Map<Integer, String[]>> materiasPorCarreraYSemestre = new HashMap<>();
    private static ArrayList<Usuario> graduados = new ArrayList<>();
    ///////////////////////////////////AQUI MODIFIQUE Y AGREGUE EL STATIC///////////////
    static {
        for (Carreras carrera : Carreras.values()) {
            usuarios.put(carrera, new HashMap<>());
            for (Rol rol : Rol.values()) {
                usuarios.get(carrera).put(rol, new ArrayList<>());
            }
        }

        ///////////////////////////////////AQUI MODIFIQUE Y AGREGUE EL STATIC///////////////

        materiasPorCarreraYSemestre.put(Carreras.ISC, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(1, new String[]{"Programación 1", "Probabilidad 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(2, new String[]{"Programación 2", "Probabilidad 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(3, new String[]{"Programación 3", "Probabilidad 3", "Cálculo 3"});

        materiasPorCarreraYSemestre.put(Carreras.IMAT, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(1, new String[]{"Estadística 1", "Contabilidad 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(2, new String[]{"Estadística 2", "Contabilidad 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(3, new String[]{"Estadística 3", "Contabilidad 3", "Cálculo 3"});

        materiasPorCarreraYSemestre.put(Carreras.ELC, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(1, new String[]{"Redes 1", "Circuitos 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(2, new String[]{"Redes 2", "Circuitos 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(3, new String[]{"Redes 3", "Circuitos 3", "Cálculo 3"});
    }

    public Sistema(boolean band) {
        if(band) {
            inicializarDatos();
        }
    }

    public void inicializarDatos() {
        // Creación de coordinadores
        Coordinador coordinadorIsc = new Coordinador("Jose", "Herrera Garcia", "Morelia", "MN", Usuario.generarCurp("Jose", "Herrera", "García", "1998-01-01", "H", "MN").toUpperCase(), "JULI", "CJ24ISC-0", "1998-01-01", Carreras.ISC, 20000, new String[]{"Programación 1", "Cálculo 1", "Probabilidad 1"}, "1", "1");
        Coordinador coordinadorImat = new Coordinador("Maria", "López Martínez", "Morelia", "MN", Usuario.generarCurp("Maria", "Lopez", "Martinez", "1982-03-24", "M", "MN").toUpperCase(), "JAZMIN", "CM24IMAT-0", "1982-03-24", Carreras.IMAT, 30000, new String[]{"Estadística 1", "Contabilidad 1", "Cálculo 1"}, "2", "2");
        Coordinador coordinadorElc = new Coordinador("Elizabeth", "Tinajero Esteves", "Morelia", "MN", Usuario.generarCurp("Elizabeth", "Tinajero", "Esteves", "2000-11-13", "M", "MN").toUpperCase(), "FERNANDO ALEMÁN", "CE24ELC-0", "2000-11-13", Carreras.ELC, 40000, new String[]{"Redes 1", "Circuitos 1", "Cálculo 1"}, "3", "3");

        // Agregar coordinadores a sus respectivas listas
        usuarios.get(Carreras.ISC).get(Rol.COORDINADOR).add(coordinadorIsc);
        usuarios.get(Carreras.IMAT).get(Rol.COORDINADOR).add(coordinadorImat);
        usuarios.get(Carreras.ELC).get(Rol.COORDINADOR).add(coordinadorElc);
    }

    Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        // Este método verifica en todas las listas si existe el nombre de usuario y contraseña, si sí lo retorna y si no, retorna un null
        for (Map<Rol, ArrayList<Usuario>> lista : usuarios.values()) {
            for (ArrayList<Usuario> usuariosList : lista.values()) {
                for (Usuario usuario : usuariosList) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        if (usuario.getContrasena().equals(contraseña)) {
                            carrera = usuario.getCarrera();
                            return usuario;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static String[] obtenerMaterias(Carreras carrera, int semestre) {
        return materiasPorCarreraYSemestre.get(carrera).get(semestre);
    }

    public static void asignarCalificaciones(Alumno alumno, Map<String, Materia> materiasConCalificaciones) {
        Scanner scanner = new Scanner(System.in);
        int calificacionesAsignadas = 0;

        for (Map.Entry<String, Materia> entry : materiasConCalificaciones.entrySet()) {
            String materiaNombre = entry.getKey();
            Materia materia = entry.getValue();

            // Verificar si la materia ya tiene calificación asignada para el alumno
            if (materia.getCalificacion() != -1) {
                System.out.println("\nLa materia " + materiaNombre + " ya tiene una calificación asignada.");
                continue; // Saltar a la siguiente materia
            }

            // Solicitar calificación para la materia
            double calificacion;
            do {
                System.out.print("\nIngrese la calificación para la materia " + materiaNombre + " del estudiante " + alumno.getNombre() + ": ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("\nError: la calificación debe ser un número decimal.");
                    scanner.next(); // Descartar la entrada no válida
                }
                calificacion = scanner.nextDouble();
            } while (calificacion < 0 || calificacion > 100);

            materia.setCalificacion(calificacion);
            calificacionesAsignadas++;
            System.out.println("\nCalificación asignada correctamente para la materia " + materiaNombre);

            // Almacenar la calificación específica del alumno en el mapa de calificaciones de la materia
            materia.getCalificaciones().put(alumno, calificacion);
        }

        scanner.close();
        System.out.println("\nTotal de calificaciones asignadas: " + calificacionesAsignadas);
    }

//    public static void guardarEnJSON() {
//        Usuarios.Serializer.UsuarioSerializer.serialize();
//    }
//
//    public static void leerJSON() {
//        Usuarios.Serializer.UsuarioDeserializer.deserialize();
//    }

    static void subirDeSemestre(){
        for (Map<Rol, ArrayList<Usuario>> lista : usuarios.values()) {
            ArrayList<Usuario> alumnosList = lista.get(Rol.ALUMNO);
            if(alumnosList != null) {
                Iterator<Usuario> iterator = alumnosList.iterator();
                while (iterator.hasNext()) {
                    Usuario alumno = iterator.next();
                    int semestre = ((Alumno)alumno).getSemestre();
                    if (semestre == 3) {
                        graduados.add(alumno);
                        iterator.remove();
                    } else {
                        ((Alumno)alumno).setSemestre(semestre + 1);
                    }
                }
            }
        }
    }

    static public void imprimirGraduados() {
        System.out.println("Lista de graduados:");
        for (Usuario graduado : graduados) {
            System.out.println("Nombre: " + graduado.getNombre() + graduado.getApellido());
        }
    }
}
