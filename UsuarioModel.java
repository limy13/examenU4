
import java.util.ArrayList;
import java.util.HashMap;

public class UsuarioModel {

    private HashMap<Rol, ArrayList<Usuario>> ISC;
    private HashMap<Rol, ArrayList<Usuario>> IMAT;
    private HashMap<Rol, ArrayList<Usuario>> ELC;
    private ArrayList<Profesor> PROFESOR;
    private ArrayList<Alumno> ALUMNO;
    private ArrayList<Coordinador> COORDINADOR;

    public HashMap<Rol, ArrayList<Usuario>> getISC() {
        return ISC;
    }

    public HashMap<Rol, ArrayList<Usuario>> getIMAT() {
        return IMAT;
    }

    public HashMap<Rol, ArrayList<Usuario>> getELC() {
        return ELC;
    }

    public ArrayList<Profesor> getPROFESOR() {
        return PROFESOR;
    }

    public ArrayList<Alumno> getALUMNO() {
        return ALUMNO;
    }

    public ArrayList<Coordinador> getCOORDINADOR() {
        return COORDINADOR;
    }

}
