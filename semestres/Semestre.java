package semestres;
import java.util.ArrayList;
import java.util.Scanner;

public class Semestre {
    private int numeroDeSemestre = 1;
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private Grupo grupoA = new Grupo();
    private Grupo grupoB = new Grupo();
    private int contadorGrupos = 1;

    public Semestre(){
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

    void anadirAlumnos() {
        Scanner scanner = new Scanner(System.in);  // Añadido Scanner para leer la entrada del usuario
        char grupoSeleccionado;

        while (true) {  // Bucle para validar la entrada del grupo
            System.out.print("Ingrese el grupo al que desea añadir al alumno (A/B): ");
            grupoSeleccionado = scanner.nextLine().toUpperCase().charAt(0);

            if (grupoSeleccionado == 'A' || grupoSeleccionado == 'B') {
                break;  // Entrada válida, salir del bucle
            } else {
                System.out.println("Grupo no válido. Por favor, ingrese 'A' o 'B'.");
            }
        }

        if (grupoSeleccionado == 'A') {
            if (!estaLlenoElGrupo(0)) {
                grupoA.anadirAlumno();  // Añadir alumno al grupo A
            } else {
                System.out.println("El grupo A está lleno.");
            }
        } else if (grupoSeleccionado == 'B') {
            if (grupos.size() == 1) {
                anadirGrupoB();  // Añadir grupo B si aún no existe
            }
            if (!estaLlenoElGrupo(1)) {
                grupoB.anadirAlumno();  // Añadir alumno al grupo B
            } else {
                System.out.println("El grupo B está lleno.");
            }
        }
    }

    public int getNumeroDeSemestre() {
        return numeroDeSemestre;
    }

    public void setNumeroDeSemestre(int numeroDeSemestre) {
        this.numeroDeSemestre = numeroDeSemestre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }


}