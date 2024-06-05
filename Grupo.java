import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {

    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Alumno> reprobados = new ArrayList<>();

    public int getNumeroAlumnos() {
        return alumnos.size();
    }

    void anadirAlumno(){
        if (alumnos.size() < 3){
            for (int i = 0; i < 3; i++){
                Scanner scanner = new Scanner(System.in);
                System.out.println("\nRegistro de alumno " + (i+1));
                Alumno.registrarAlumno(); // Llama al método estático registrarAlumno de la clase Usuarios.Alumno
            }
        }else if (alumnos.size() < 20){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nRegistro de nuevo alumno");
            Alumno.registrarAlumno(); // Llama al método estático registrarAlumno de la clase Usuarios.Alumno
        }
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    void anadirReprobado(Alumno alumno){
        reprobados.add(alumno);
        alumnos.remove(alumno);
    }

    boolean estaReprobadoElAlumno(Alumno alumno){
        boolean reprobado = false;
        if (alumno.equals(alumno)){
            reprobado = false;
        }else{
            reprobado = true;
        }
        return reprobado;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Alumno> getReprobados() {
        return reprobados;
    }

    public void setReprobados(ArrayList<Alumno> reprobados) {
        this.reprobados = reprobados;
    }

}
