import java.util.ArrayList;

public class Alumno extends Usuario{
    private ArrayList<Materia> materias;

    public Alumno(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, int anoNacimiento, Carreras carrera, int semestre) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, anoNacimiento, carrera);
        this.materias = new ArrayList<>();
        asignarMaterias(carrera, semestre);
    }

    private void asignarMaterias(Carreras carrera, int semestre) {
        String[] materiasSemestre = Sistema.obtenerMaterias(carrera, semestre);
        for (String nombreMateria : materiasSemestre) {
            materias.add(new Materia(nombreMateria));
        }
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }
}
