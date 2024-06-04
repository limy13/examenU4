import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    public int getNumeroAlumnos() {
        return alumnos.size();
    }

    void anadirAlumno(){
        if (alumnos.size() < 3){
            for (int i = 0; i < 3; i++){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Registro de alumno " + (i+1));
                Alumno.registrarAlumno(); // Llama al método estático registrarAlumno de la clase Alumno
            }
        }else if (alumnos.size() < 20){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Registro de nuevo alumno");
            Alumno.registrarAlumno(); // Llama al método estático registrarAlumno de la clase Alumno
        }
    }

}
