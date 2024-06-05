import sistema.Menu;
import sistema.Sistema;

public class Main {

    public static void main(String[] args) {
        //COORDINADOR ISC: Usuarios.Usuario: 1, Contraseña: 1
        //COORDINADOR IMAT: Usuarios.Usuario: 2, Contraseña: 2
        //COORDINADOR ELC: Usuarios.Usuario: 3, Contraseña: 3
        Sistema.leerJSON();
        Menu menu = new Menu(true);
        menu.iniciarSesion();
        Sistema.guardarEnJSON();
    }
}
