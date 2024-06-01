public class Grupo {
    private Alumno[] alumnos = new Alumno[20];

    public int getNumeroAlumnos() {
        return alumnos.length;
    }

    void anadirAlumno(){
        if (alumnos.length < 3){
            for (int i = 0; i < 3; i++){
                //se registran alumnos pero ps todavia no existe el metodo para registrar alumnos
                //esto es forzado btw, tiene que agregar si o si 3 alumnos si es que no existe ninguno
                alumnos[i] = new Alumno();
            }
        }
        if (alumnos.length > 3 && alumnos.length < 20){
            for (int i = 0; i < alumnos.length; i++){
                if (alumnos[i] == null){
                    alumnos[i] = new Alumno();
                }
            }
        }
        //se registra a un alumno con metodo que los alumnos ya tendran
        Alumno a = new Alumno();
        alumnos[getNumeroAlumnos()-1] = a;
    }
}
