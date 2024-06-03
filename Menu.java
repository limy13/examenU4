import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private String decision; //sirve para tomar una decision en cualquier menú
    //para elegir una opcion en el menu usen Strings porque es mas dificl que truene porfa :)
    private Sistema sistema = new Sistema();

    public void iniciarSesion() {
        boolean datosCorrectos = true, salir = false;
        do {
            System.out.println("\n---- BIENVENIDO A MINDBOX ITM ----\n");
            try {
                System.out.print("Ingresa tu usuario para continuar: ");
                String usuario = scanner.nextLine();
                System.out.print("Ingresa tu contraseña: ");
                String contrasena = scanner.nextLine();

                Usuario usuarioActual = sistema.verificarInicioSesion(usuario, contrasena);
                if(usuarioActual != null) {
                    UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                    seleccionarMenu();
                }
                else {
                    System.out.println("\nUsuario o contraseña incorrectos.");
                    do {
                        try {
                            System.out.print("\n¿Desea intentarlo otra vez? (1 = si, 2 = no)");
                            int decision = scanner.nextInt();
                            if(decision == 2) {
                                datosCorrectos = false;
                                salir = true;
                            }
                            else if (decision == 1){
                                datosCorrectos = true;
                                salir = true;
                            }
                            else {
                                System.out.println("\nPor favor ingrese una de las opciones disponibles");
                            }
                        }
                        catch (Exception e) {
                            System.out.println("\nPor favor ingrese una de las opciones disponibles");
                        }
                    }
                    while(!salir);
                }
            }
            catch (Exception e) {
                System.out.println("\nPor favor ingrese una cadena");
            }
        }
        while(datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case COORDINADOR: menuCoordinador(usuario.getNombreUsuario()); //le manda por parametro ek nombre de usuario para que muestre quien esta en sesion
                break;
            case ALUMNO: menuAlumno(usuario.getNombreUsuario());
                break;
            case PROFESOR: menuAlumno(usuario.getNombreUsuario());
                break;
        }
    }

    public void menuCoordinador(String nombreUsuario) {
        do {
            System.out.println("\n******");
            System.out.println("\n---- BIENVENIDO COORDINADOR ----\n");
            System.out.println(nombreUsuario);
            System.out.println("\n1. Mostrar registro de alumnos graduados");
            System.out.println("2. Alumnos");
            System.out.println("3. Calificaciones");
            System.out.println("4. Profesores");
            System.out.println("5. Avanzar de semestre");
            System.out.println("6. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextLine();

            switch (decision) {
                //Ver info Personal
                case "1":
                    //Mostrar alumnos graduados
                    break;
                case "2":
                    String decisionAlumno;
                    do {
                        System.out.println("\n---- MENÚ DE ALUMNOS ----\n");
                        System.out.println("1. Registrar alumno");
                        System.out.println("2. Consultar alumno");
                        System.out.println("3. Modificar datos de alumno");
                        System.out.println("4. Eliminar alumno");
                        System.out.println("5. Regresar al menú principal");
                        System.out.print("\nIngrese opción: ");
                        decisionAlumno = scanner.nextLine();

                        switch (decisionAlumno) {
                            case "1":
                                // Registra alumno
                                break;
                            case "2":
                                // Consultar  alumno
                                break;
                            case "3":
                                Alumno.modificarAlumno();
                                // Modifica los datos de un alumno
                                break;
                            case "4":
                                // Elimina un alumno
                                break;
                            case "5":
                                System.out.println("Regresando al menú principal");
                                break;
                            default:
                                System.out.println("Elige una opción Valida");
                                break;
                        }
                    } while (!decisionAlumno.equals("5"));
                    break;
                case "3":
                    menuCalificaciones();
                    break;
                case "4":
                    //Avanzar semestre
                    break;
                case "5":
                    System.out.println("Cerrando Sesion");
                    break;
                default:
                    System.out.println("Elige una opción Valida");
                    break;
            }
        } while (!decision.equals("5"));
    }


    public void menuAlumno(String nombreUsuario) {
        do {
            System.out.println("\n******");
            System.out.println("\n---- BIENVENIDO ALUMNO ----\n");
            System.out.println("Usuario: " + nombreUsuario);
            System.out.println("\n1. Ver mis calificaciones");
            System.out.println("2. Ver mis cursos inscritos");
            System.out.println("3. Ver mi información personal");
            System.out.println("4. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextLine();

            switch (decision) {
                case "1":
                    //Ver calificacion
                    break;
                case "2":
                    //Ver Cursos Inscritos
                    break;
                case "3":
                    //Ver info Personal
                    break;
                case "4":
                    System.out.println("Cerrando Sesion");
                    break;
                default:
                    System.out.println("Elige una opción Valida");
                    break;
            }
        } while (!decision.equals("4"));
    }

    public void menuProfesor(String nombreUsuario) {
        do {
            System.out.println("\n******");
            System.out.println("\n---- BIENVENIDO MAESTRO ----\n");
            System.out.println("Usuario: " + nombreUsuario);
            System.out.println("\n1. Ver mis grupos");
            System.out.println("2. Ver mis materias asignadas");
            System.out.println("3. Calificaciones");
            System.out.println("4. Ver información personal");
            System.out.println("5. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextLine();

            switch (decision) {
                case "1":
                    //Ver Mis grupos
                    break;
                case "2":
                    //VER materias Impartidas
                    break;
                case "3":
                    menuCalificaciones();
                    break;
                case "4":
                    //Ver info Personal
                    break;
                case "5":
                    System.out.println("Cerrando Sesion");
                    break;
                default:
                    System.out.println("Elige una opción Valida");
                    break;
            }
        } while (!decision.equals("5"));
    }

    public void menuCalificaciones() {
        String dc;
        do {
            System.out.println("QUE DESEA HACER?");
            System.out.println("1. Registrar Calificaciones");
            System.out.println("2. Consultar Calificaciones");
            System.out.println("3. Modificar Calificaciones");
            System.out.println("4. Salir");
            dc = scanner.nextLine();

            switch (dc) {
                case "1":
                    //Registrar Calificaciones
                    break;
                case "2":
                    //Consultar Calificaciones
                    break;
                case "3":
                    //Modificar Calificaciones
                    break;
                case "4":
                    System.out.println("Saliendo del Programa");
                    break;
                default:
                    System.out.println("Elige una opción Valida");
                    break;
            }
        } while (!dc.equals("4"));
    }
}