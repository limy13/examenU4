package carreras;
import java.util.ArrayList;
import semestres.Grupo;
import semestres.Semestre;
import usuarios.Alumno;

public class Carrera {

    private int id;
    private String nombreCarrera;
    private int cantidadGrupos;
    private int cantidadAlumnos;
    private int cantidadMaterias;
    private String fechaCreacion;
    private String coordinador;
    private String abreviacion;

    ArrayList<Semestre> semestres = new ArrayList<>();
    ArrayList<Alumno> graduados = new ArrayList<Alumno>();

    public Carrera(int id, String nombreCarrera, int cantidadGrupos, int cantidadAlumnos, int cantidadMaterias, String fechaCreacion, String coordinador, String abreviacion) {
        this.id = id;
        this.nombreCarrera = nombreCarrera;
        this.cantidadGrupos = cantidadGrupos;
        this.cantidadAlumnos = cantidadAlumnos;
        this.cantidadMaterias = cantidadMaterias;
        this.fechaCreacion = fechaCreacion;
        this.coordinador = coordinador;
        this.abreviacion = abreviacion;
        anadirSemestre();
    }

    Semestre procesoPrimeraVezSemestre(){
        Semestre semestre = new Semestre();
        System.out.println("\n** SE CREÓ UN NUEVO PRIMER SEMESTRE **");
        System.out.println("\nSe creó el grupo A de el semestre 1 de la carrera " + this.nombreCarrera +": ");
        for (int i = 0; i < semestres.size(); i++) {

        }
        System.out.println("\nPara que el grupo pueda se requieren 3 alumnos, se crean a continuacion:");

        return semestre;
    }

    void anadirSemestre(){
        semestres.add(procesoPrimeraVezSemestre());
    }

    Semestre anadirAlumnosReprobadosAGrupoCorrespondiente(Semestre semestreNuevo){
        for (Semestre semestre : semestres) {
            ArrayList<Alumno> vacio = new ArrayList<>();
            for (int i = 0; i < semestre.getGrupos().size(); i++) {
                semestreNuevo.getGrupos().get(i).setAlumnos(semestre.getGrupos().get(i).getReprobados());
                semestre.getGrupos().get(i).setReprobados(vacio);
            }
        }
        return semestreNuevo;
    }

    void subirDeGradoSemestres(){
        for(Semestre semestre : semestres){
            semestre.setNumeroDeSemestre(semestre.getNumeroDeSemestre() + 1);
            for (Grupo grupo : semestre.getGrupos()) {
                for (int j = 0; j < grupo.getNumeroAlumnos(); j++) {
                    if (grupo.estaReprobadoElAlumno(grupo.getAlumnos().get(j))) {
                        grupo.anadirReprobado(grupo.getAlumnos().get(j));
                        grupo.getAlumnos().remove(grupo.getAlumnos().get(j));
                    }
                }
            }
        }
    }

    String mostrarSemestres(Semestre semestre){
        String enunciado = "";
        if(semestre != null){
            enunciado = "\nSemestre" + semestre.getNumeroDeSemestre();
        }
        return enunciado;
    }
}