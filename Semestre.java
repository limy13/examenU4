import java.util.ArrayList;

public class Semestre {
    int numeroDeSemestre;
    ArrayList<Grupo> grupos = new ArrayList<>();
    Grupo grupoA = new Grupo();
    Grupo grupoB = new Grupo();
    int contadorGrupos = 1;
    Semestre(int numeroDeSemestre){
        this.numeroDeSemestre = numeroDeSemestre;
        grupos.add(grupoA);
    }

    public void anadirGrupoB(){
        grupos.add(grupoB);
        contadorGrupos++;
    }

    boolean estaLlenoElGrupo(int indiceDeGrupo){
        boolean estanLlenos = false;
        if(grupos.get(indiceDeGrupo).getNumeroAlumnos() == 20){
            estanLlenos = true;
        }
        return estanLlenos;
    }

    void anadirAlumnos(){
        if (!estaLlenoElGrupo(0)){
            grupoA.anadirAlumno();
        }
        else if(estaLlenoElGrupo(0) && grupos.size() == 1){
            anadirGrupoB();
            grupoB.anadirAlumno();
        }
        else if (!estaLlenoElGrupo(1)) {
            grupoB.anadirAlumno();
        }
        else if (estaLlenoElGrupo(1)) {
            System.out.println("NO HAY CUPO");
        }
    }

    public int getNumeroDeSemestre() {
        return numeroDeSemestre;
    }
}
