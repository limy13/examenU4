import java.util.ArrayList;

public class Grupo {
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    public int getNumeroAlumnos() {
        return alumnos.size();
    }
    void anadirAlumno(){
        if (alumnos.size() < 3){
            for (int i = 0; i < 3; i++){
                //se registran alumnos pero ps todavia no existe el metodo para registrar alumnos
                //esto es forzado btw, tiene que agregar si o si 3 alumnos si es que no existe ninguno
                alumnos.add(new Alumno());
            }
        }else if (alumnos.size() < 20){
            alumnos.add(new Alumno());
        }
        //se registra a un alumno con metodo que los alumnos ya tendran
    }

}
