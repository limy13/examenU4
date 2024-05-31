public class Semestre {
    int numeroDeSemestre;
    Grupo[] grupos = new Grupo[2];
    Grupo grupoA = new Grupo();
    Grupo grupoB = new Grupo();
    int contadorGrupos = 1;
    Semestre(int numeroDeSemestre){
        this.numeroDeSemestre = numeroDeSemestre;
        grupos[0] = grupoA;
    }

    public void anadirGrupoB(){
        grupos[1] = grupoB;
        contadorGrupos++;
    }

    boolean estaLlenoElGrupo(int indiceDeGrupo){
        boolean estanLlenos = false;
        if (grupos[0].getNumeroAlumnos() < 20){
            estanLlenos = false;
        }else if(grupos[0].getNumeroAlumnos() == 20){
            estanLlenos = true;
        }
        return estanLlenos;
    }

    void anadirAlumnos(){
        if (!estaLlenoElGrupo(0)){
            grupoA.anadirAlumno();
        }
        else if(estaLlenoElGrupo(0) && grupos.length == 1){
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
