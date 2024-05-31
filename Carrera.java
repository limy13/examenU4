import java.util.ArrayList;

public class Carrera {
    Semestre[] semestres = new Semestre[3];
    Semestre semestre1 = new Semestre(1);
    Semestre semestre2 = new Semestre(2);
    Semestre semestre3 = new Semestre(3);
    ArrayList<Alumno> graduados = new ArrayList<Alumno>();

    Carrera(){
        semestres[0] = semestre1;
    }
    void procesoDeInicioDeSemestre(){

        //tienen que existir minimo 3 alumnos
        //se asignan los alumnos a su respectivo grupo

        /*
        si es la primera vez que se inicia el programa se crea uno
        cuando se aprueban las materias suben de semestre 1 a 2, 2 a 3 y de 3 a graduados
        si se aprueban materias y pasa el semestre 1 a 2 se queda vacio el semestre 1 hasta que
         se añadan nuevos alumnos
        */
    }

    String mostrarSemestres(Semestre semestre){
        String enunciado = "";
        if(semestre != null){
            enunciado = "Semestre" + semestre.getNumeroDeSemestre();
        }
        return enunciado;
    }
}
