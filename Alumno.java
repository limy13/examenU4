import java.util.ArrayList;

public class Alumno extends Usuario{
    private ArrayList<Materia> materias;
    private int semestre;
    private double promedio;
    private String grupo; //esto puede cambiarse

    public Alumno(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, int semestre) {
        super(nombre, apellido, ciudad, estado, curp, direccion, numeroControl, fechaNacimiento, carrera, Rol.ALUMNO);
        this.materias = new ArrayList<>();
        this.semestre = semestre;
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

    @Override
    public void verInformacionPersonal() {
        super.verInformacionPersonal();
        System.out.println("Semestre: " + this.semestre);
        System.out.println("Grupo: " + this.grupo);
        System.out.println("Promedio: " + this.promedio);
    }
}
