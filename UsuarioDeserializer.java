

public class UsuarioDeserializer {

//    public static void deserialize() {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
//            Gson gson = new Gson();
//            Usuarios.models.UsuarioModel usuarioModel = gson.fromJson(reader, Usuarios.models.UsuarioModel.class);
//            HashMap<Usuarios.utils.Rol, ArrayList<Usuarios.Usuario>> ISC;
//            HashMap<Usuarios.utils.Rol, ArrayList<Usuarios.Usuario>> ELC;
//            HashMap<Usuarios.utils.Rol, ArrayList<Usuarios.Usuario>> IMAT;
//            ArrayList<Usuarios.Usuario> alumnos;
//            ArrayList<Usuarios.Usuario> profesores;
//            ArrayList<Usuarios.Usuario> coordinadores;
//
//            if(usuarioModel == null) {
//                System.out.println("El archivo JSON no pudo ser deserializado a Usuarios.models.UsuarioModel");
//                return;
//            }
//
//            if(usuarioModel.getISC() != null) {
//                alumnos = new ArrayList<>(usuarioModel.getISC().get(Usuarios.utils.Rol.ALUMNO));
//                profesores = new ArrayList<>(usuarioModel.getISC().get(Usuarios.utils.Rol.PROFESOR));
//                coordinadores = new ArrayList<>(usuarioModel.getISC().get(Usuarios.utils.Rol.COORDINADOR));
//
//                sistema.Sistema.usuarios.put(Carreras.ISC, new HashMap<>());
//                sistema.Sistema.usuarios.get(Carreras.ISC).put(Usuarios.utils.Rol.ALUMNO, alumnos);
//                sistema.Sistema.usuarios.get(Carreras.ISC).put(Usuarios.utils.Rol.PROFESOR, profesores);
//                sistema.Sistema.usuarios.get(Carreras.ISC).put(Usuarios.utils.Rol.COORDINADOR, coordinadores);
//            }
//            else {
//                sistema.Sistema.usuarios.put(Carreras.ISC, new HashMap<>());
//            }
//
//            if(usuarioModel.getELC() != null) {
//                alumnos = new ArrayList<>(usuarioModel.getELC().get(Usuarios.utils.Rol.ALUMNO));
//                profesores = new ArrayList<>(usuarioModel.getELC().get(Usuarios.utils.Rol.PROFESOR));
//                coordinadores = new ArrayList<>(usuarioModel.getELC().get(Usuarios.utils.Rol.COORDINADOR));
//
//                sistema.Sistema.usuarios.put(Carreras.ELC, new HashMap<>());
//                sistema.Sistema.usuarios.get(Carreras.ELC).put(Usuarios.utils.Rol.ALUMNO, alumnos);
//                sistema.Sistema.usuarios.get(Carreras.ELC).put(Usuarios.utils.Rol.PROFESOR, profesores);
//                sistema.Sistema.usuarios.get(Carreras.ELC).put(Usuarios.utils.Rol.COORDINADOR, coordinadores);
//            }
//            else {
//                sistema.Sistema.usuarios.put(Carreras.ELC, new HashMap<>());
//            }
//
//            if(usuarioModel.getIMAT() != null) {
//                alumnos = new ArrayList<>(usuarioModel.getIMAT().get(Usuarios.utils.Rol.ALUMNO));
//                profesores = new ArrayList<>(usuarioModel.getIMAT().get(Usuarios.utils.Rol.PROFESOR));
//                coordinadores = new ArrayList<>(usuarioModel.getIMAT().get(Usuarios.utils.Rol.COORDINADOR));
//
//                sistema.Sistema.usuarios.put(Carreras.IMAT, new HashMap<>());
//                sistema.Sistema.usuarios.get(Carreras.IMAT).put(Usuarios.utils.Rol.ALUMNO, alumnos);
//                sistema.Sistema.usuarios.get(Carreras.IMAT).put(Usuarios.utils.Rol.PROFESOR, profesores);
//                sistema.Sistema.usuarios.get(Carreras.IMAT).put(Usuarios.utils.Rol.COORDINADOR, coordinadores);
//            }
//            else {
//                sistema.Sistema.usuarios.put(Carreras.IMAT, new HashMap<>());
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e);
//        } catch (IOException e) {
//            System.out.println(e);
//        } catch (JsonSyntaxException e) {
//            System.out.println(e);
//        } catch (JsonParseException e) {
//            System.out.println(e);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
