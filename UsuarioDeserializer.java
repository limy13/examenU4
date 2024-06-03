import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDeserializer {

    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson gson = new Gson();
            UsuarioModel usuarioModel = gson.fromJson(reader, UsuarioModel.class);
            HashMap<Rol, ArrayList<Usuario>> ISC;
            HashMap<Rol, ArrayList<Usuario>> ELC;
            HashMap<Rol, ArrayList<Usuario>> IMAT;
            ArrayList<Usuario> alumnos;
            ArrayList<Usuario> profesores;
            ArrayList<Usuario> coordinadores;

            if(usuarioModel == null) {
                System.out.println("El archivo JSON no pudo ser deserializado a UsuarioModel");
                return;
            }

            if(usuarioModel.getISC() != null) {
                alumnos = new ArrayList<>(usuarioModel.getISC().get(Rol.ALUMNO));
                profesores = new ArrayList<>(usuarioModel.getISC().get(Rol.PROFESOR));
                coordinadores = new ArrayList<>(usuarioModel.getISC().get(Rol.COORDINADOR));

                Sistema.usuarios.put(Carreras.ISC, new HashMap<>());
                Sistema.usuarios.get(Carreras.ISC).put(Rol.ALUMNO, alumnos);
                Sistema.usuarios.get(Carreras.ISC).put(Rol.PROFESOR, profesores);
                Sistema.usuarios.get(Carreras.ISC).put(Rol.COORDINADOR, coordinadores);
            }
            else {
                Sistema.usuarios.put(Carreras.ISC, new HashMap<>());
            }

            if(usuarioModel.getELC() != null) {
                alumnos = new ArrayList<>(usuarioModel.getELC().get(Rol.ALUMNO));
                profesores = new ArrayList<>(usuarioModel.getELC().get(Rol.PROFESOR));
                coordinadores = new ArrayList<>(usuarioModel.getELC().get(Rol.COORDINADOR));

                Sistema.usuarios.put(Carreras.ELC, new HashMap<>());
                Sistema.usuarios.get(Carreras.ELC).put(Rol.ALUMNO, alumnos);
                Sistema.usuarios.get(Carreras.ELC).put(Rol.PROFESOR, profesores);
                Sistema.usuarios.get(Carreras.ELC).put(Rol.COORDINADOR, coordinadores);
            }
            else {
                Sistema.usuarios.put(Carreras.ELC, new HashMap<>());
            }

            if(usuarioModel.getIMAT() != null) {
                alumnos = new ArrayList<>(usuarioModel.getIMAT().get(Rol.ALUMNO));
                profesores = new ArrayList<>(usuarioModel.getIMAT().get(Rol.PROFESOR));
                coordinadores = new ArrayList<>(usuarioModel.getIMAT().get(Rol.COORDINADOR));

                Sistema.usuarios.put(Carreras.IMAT, new HashMap<>());
                Sistema.usuarios.get(Carreras.IMAT).put(Rol.ALUMNO, alumnos);
                Sistema.usuarios.get(Carreras.IMAT).put(Rol.PROFESOR, profesores);
                Sistema.usuarios.get(Carreras.IMAT).put(Rol.COORDINADOR, coordinadores);
            }
            else {
                Sistema.usuarios.put(Carreras.IMAT, new HashMap<>());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
