import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sistema {

    public static final Map<Carreras, Map<Rol, ArrayList<Usuario>>> usuarios = new HashMap<>();
    public static Carreras carrera; //accede a la carrera de la persona que inicia sesion
    public static Map<Carreras, String []> materias  = new HashMap<>();

    public Sistema() {
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


        String [] materiasIsc;
        materiasIsc = new String[]{"Programación 1", "Programación 2", "Programación 3", "Probabilidad 1", "Probabilidad 2", "Probabilidad 3", "Cálculo 1", "Cálculo 2", "Cálculo 3"};

        String [] materiasImat;
        materiasImat = new String[]{"Estadística 1", "Estadística 2", "Estadística 3", "Contabilidad 1", "Contabilidad 2", "Contabilidad 3", "Cálculo 1", "Cálculo 2", "Cálculo 3"};

        String [] materiasElc;
        materiasElc = new String[]{"Redes 1", "Redes 2", "Redes 3", "Circuitos 1", "Circuitos 2", "Circuitos 3", "Cálculo 1", "Cálculo 2", "Cálculo 3"};

        materias.put(Carreras.ISC, materiasIsc);
        materias.put(Carreras.IMAT, materiasImat);
        materias.put(Carreras.ELC, materiasElc);


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

}
