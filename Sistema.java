import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {

    public static final Map<Carreras, Map<Rol, ArrayList<Usuario>>> usuarios = new HashMap<>();
    public static Carreras carrera; //accede a la carrera de la persona que inicia sesion
    public static final Map<Carreras, Map<Integer, String[]>> materiasPorCarreraYSemestre = new HashMap<>();

    public Sistema() {

        Coordinador coordinadorIsc = new Coordinador("Jose", "Herrera Garcia", "Morelia", "MN", Usuario.generarCurp("Jose", "Herrera", "García", "1998-01-01", "H", "MN").toUpperCase(), "JULI", "CJ24ISC-0", "1998-01-01", Carreras.ISC, 20000, new String[]{"Programación 1", "Cálculo 1", "Probabilidad 1"});
        Coordinador coordinadorImat = new Coordinador("Maria", "López Martínez", "Morelia", "MN", Usuario.generarCurp("Maria", "Lopez", "Martinez", "1982-03-24", "M", "MN").toUpperCase(), "JAZMIN", "CM24IMAT-0", "1982-03-24", Carreras.IMAT, 30000, new String[]{"Estadística 1", "Contabilidad 1", "Cálculo 1"});
        Coordinador coordinadorElc = new Coordinador("Elizabeth", "Tinajero Esteves", "Morelia", "MN", Usuario.generarCurp("Elizabeth", "Tinajero", "Esteves", "2000-11-13", "M", "MN").toUpperCase(), "FERNANDO ALEMÁN", "CE24ELC-0", "2000-11-13", Carreras.ELC, 40000, new String[]{"Redes 1", "Circuitos 1", "Cálculo 1"});

        usuarios.put(Carreras.ISC, new HashMap<>());
        usuarios.get(Carreras.ISC).put(Rol.ALUMNO, new ArrayList<>());
        usuarios.get(Carreras.ISC).put(Rol.PROFESOR, new ArrayList<>());
        usuarios.get(Carreras.ISC).put(Rol.COORDINADOR, new ArrayList<>());

        usuarios.put(Carreras.IMAT, new HashMap<>());
        usuarios.get(Carreras.IMAT).put(Rol.ALUMNO, new ArrayList<>());
        usuarios.get(Carreras.IMAT).put(Rol.PROFESOR, new ArrayList<>());
        usuarios.get(Carreras.IMAT).put(Rol.COORDINADOR, new ArrayList<>());

        usuarios.put(Carreras.ELC, new HashMap<>());
        usuarios.get(Carreras.ELC).put(Rol.ALUMNO, new ArrayList<>());
        usuarios.get(Carreras.ELC).put(Rol.PROFESOR, new ArrayList<>());
        usuarios.get(Carreras.ELC).put(Rol.COORDINADOR, new ArrayList<>());
    }

    Usuario verificarInicioSesion(String nombreUsuario, String contraseña) {
        // este metodo verifica en todas las listas que hay si existe el nombre de
        // usuario y contraseña, si si lo retorna y si no, retorna un null

        for(Map<Rol, ArrayList<Usuario>> lista : usuarios.values()) {
            for(ArrayList<Usuario> usuariosList : lista.values()) {
                for(Usuario usuario : usuariosList) {
                    if(usuario.getNombreUsuario().equals(nombreUsuario)) {
                        if(usuario.getContrasena().equals(contraseña)) {
                            carrera = usuario.getCarrera();
                            return usuario;
                        }
                    }
                }
            }
        }
        return null;
    }

    static {
        // Inicializar materias para cada carrera y semestre
        materiasPorCarreraYSemestre.put(Carreras.ISC, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(1, new String[] {"Programación 1", "Probabilidad 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(2, new String[] {"Programación 2", "Probabilidad 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.ISC).put(3, new String[] {"Programación 3", "Probabilidad 3", "Cálculo 3"});

        materiasPorCarreraYSemestre.put(Carreras.IMAT, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(1, new String[] {"Estadística 1", "Contabilidad 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(2, new String[] {"Estadística 2", "Contabilidad 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.IMAT).put(3, new String[] {"Estadística 3", "Contabilidad 3", "Cálculo 3"});

        materiasPorCarreraYSemestre.put(Carreras.ELC, new HashMap<>());
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(1, new String[] {"Redes 1", "Circuitos 1", "Cálculo 1"});
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(2, new String[] {"Redes 2", "Circuitos 2", "Cálculo 2"});
        materiasPorCarreraYSemestre.get(Carreras.ELC).put(3, new String[] {"Redes 3", "Circuitos 3", "Cálculo 3"});
    }

    public static String[] obtenerMaterias(Carreras carrera, int semestre) {
        return materiasPorCarreraYSemestre.get(carrera).get(semestre);
    }

}
