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
