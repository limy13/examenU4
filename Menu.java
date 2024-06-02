import java.util.Scanner;

public class Menu {

    Sistema sistema = new Sistema();

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        boolean datosCorrectos = true;
        do {
            System.out.println("\n---- BIENVENIDO A MINDBOX ITM ----\n");
            System.out.print("Ingresa tu usuario para continuar: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingresa tu contraseña: ");
            String contrasena = scanner.nextLine();
            Usuario usuarioActual = sistema.verificarInicioSesion(usuario, contrasena);
            if (usuarioActual != null) {
                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();
            } else {
                System.out.println("\nUsuario o contraseña incorrectos.");
                datosCorrectos = true;
            }
        }
        while (datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case Rol.ALUMNO: menuAlumno(usuario);
            case Rol.PROFESOR: menuProfesor(usuario);
            case Rol.COORDINADOR: menuCoordinador(usuario);
        }
    }
}
