package semestres;
import carreras.utils.Carreras;
import sistema.Sistema;
import usuarios.Alumno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Semestre {
    private int contadorGrupos = 1;
    private static HashMap<Carreras, HashMap<String, HashMap<String, ArrayList<Alumno>>>> grupos = new HashMap<>();

    public Semestre(){
        grupos.put(Carreras.ISC, new HashMap<>());
        grupos.put(Carreras.IMAT, new HashMap<>());
        grupos.put(Carreras.ELC, new HashMap<>());

        grupos.get(Carreras.ISC).put("1", new HashMap<>());
        grupos.get(Carreras.IMAT).put("1", new HashMap<>());
        grupos.get(Carreras.ELC).put("1", new HashMap<>());

        grupos.get(Carreras.ISC).put("2", new HashMap<>());
        grupos.get(Carreras.IMAT).put("2", new HashMap<>());
        grupos.get(Carreras.ELC).put("2", new HashMap<>());

        grupos.get(Carreras.ISC).put("3", new HashMap<>());
        grupos.get(Carreras.IMAT).put("3", new HashMap<>());
        grupos.get(Carreras.ELC).put("3", new HashMap<>());

        grupos.get(Carreras.ISC).put("4", new HashMap<>());
        grupos.get(Carreras.IMAT).put("4", new HashMap<>());
        grupos.get(Carreras.ELC).put("4", new HashMap<>());

        grupos.get(Carreras.ISC).get("1").put("A", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("1").put("A", new ArrayList<>());
        grupos.get(Carreras.ELC).get("1").put("A", new ArrayList<>());
        grupos.get(Carreras.ISC).get("1").put("B", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("1").put("B", new ArrayList<>());
        grupos.get(Carreras.ELC).get("1").put("B", new ArrayList<>());

        grupos.get(Carreras.ISC).get("2").put("A", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("2").put("A", new ArrayList<>());
        grupos.get(Carreras.ELC).get("2").put("A", new ArrayList<>());
        grupos.get(Carreras.ISC).get("2").put("B", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("2").put("B", new ArrayList<>());
        grupos.get(Carreras.ELC).get("2").put("B", new ArrayList<>());

        grupos.get(Carreras.ISC).get("3").put("A", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("3").put("A", new ArrayList<>());
        grupos.get(Carreras.ELC).get("3").put("A", new ArrayList<>());
        grupos.get(Carreras.ISC).get("3").put("B", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("3").put("B", new ArrayList<>());
        grupos.get(Carreras.ELC).get("3").put("B", new ArrayList<>());

        grupos.get(Carreras.ISC).get("4").put("Graduados", new ArrayList<>());
        grupos.get(Carreras.IMAT).get("4").put("Graduados", new ArrayList<>());
        grupos.get(Carreras.ELC).get("4").put("Graduados", new ArrayList<>());
    }

//    boolean estaLlenoElGrupo(int indiceDeGrupo){
//        boolean estanLlenos = false;
//        if(grupos.get(indiceDeGrupo).getNumeroAlumnos() == 20){
//            estanLlenos = true;
//        }
//        return estanLlenos;
//    }
//
//    void anadirAlumnos() {
//        Scanner scanner = new Scanner(System.in);  // Añadido Scanner para leer la entrada del usuario
//        char grupoSeleccionado;
//
//        while (true) {  // Bucle para validar la entrada del grupo
//            System.out.print("Ingrese el grupo al que desea añadir al alumno (A/B): ");
//            grupoSeleccionado = scanner.nextLine().toUpperCase().charAt(0);
//
//            if (grupoSeleccionado == 'A' || grupoSeleccionado == 'B') {
//                break;  // Entrada válida, salir del bucle
//            } else {
//                System.out.println("Grupo no válido. Por favor, ingrese 'A' o 'B'.");
//            }
//        }
//
//        if (grupoSeleccionado == 'A') {
//            if (!estaLlenoElGrupo(0)) {
//                grupoA.anadirAlumno();  // Añadir alumno al grupo A
//            } else {
//                System.out.println("El grupo A está lleno.");
//            }
//        } else if (grupoSeleccionado == 'B') {
//            if (grupos.size() == 1) {
//                anadirGrupoB();  // Añadir grupo B si aún no existe
//            }
//            if (!estaLlenoElGrupo(1)) {
//                grupoB.anadirAlumno();  // Añadir alumno al grupo B
//            } else {
//                System.out.println("El grupo B está lleno.");
//            }
//        }
//    }

    private void asignarMaterias(Carreras carrera, int semestre) {
        // Aquí puse un try
        try {
            String[] materiasSemestre = Sistema.obtenerMaterias(carrera, semestre);
            for (String nombreMateria : materiasSemestre) {
                materias.add(new Materia(nombreMateria));
            }
        } catch (Exception e) {
            System.out.println("\nOcurrió un error al asignar materias. Por favor, intente de nuevo.");
        }
    }

    public static String anadirAlumno(Alumno alumno) {
        String grupo;
        grupos.get(Sistema.carrera).get("1").get("A").add(alumno);
        grupo = "A";
        return grupo;
    }

//    public int getNumeroDeSemestre() {
//        return numeroDeSemestre;
//    }
//
//    public void setNumeroDeSemestre(int numeroDeSemestre) {
//        this.numeroDeSemestre = numeroDeSemestre;
//    }
//
//    public ArrayList<Grupo> getGrupos() {
//        return grupos;
//    }


}