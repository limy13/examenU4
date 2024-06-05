package sistema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import usuarios.Alumno;
import usuarios.Coordinador;
import usuarios.Profesor;
import usuarios.Usuario;
import usuarios.utils.Rol;
import utils.UsuarioEnSesion;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private String decision; //sirve para tomar una decision en cualquier menú
    //para elegir una opcion en el menu usen Strings porque es mas dificl que truene porfa :)
    private Sistema sistema;

    public Menu(boolean band) {
        sistema = new Sistema(band);
    }

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
                } else {
                    System.out.println("\nUsuarios.Usuario o contraseña incorrectos.");
                    do {
                        try {
                            System.out.print("\n¿Desea intentarlo otra vez? (1. Si, 2. Cerrar Programa)");
                            int decision = scanner.nextInt();
                            scanner.nextLine();
                            if(decision == 2) {
                                datosCorrectos = false;
                                salir = true;
                            } else if (decision == 1){
                                datosCorrectos = true;
                                salir = true;
                            } else {
                                System.out.println("\nPor favor ingrese una de las opciones disponibles");
                            }
                        } catch (Exception e) {
                            System.out.println("\nPor favor ingrese una de las opciones disponibles");
                            scanner.nextLine();
                        }
                    } while(!salir);
                }
            } catch (Exception e) {
                System.out.println("\nPor favor ingrese una cadena");
                scanner.nextLine();
            }
        } while(datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
        switch (usuario.getRol()) {
            case COORDINADOR: menuCoordinador(usuario); //le manda por parametro ek nombre de usuario para que muestre quien esta en sesion
                break;
            case ALUMNO: menuAlumno(usuario);
                break;
            case PROFESOR: menuProfesor(usuario);
                break;
        }
    }


    public void menuCoordinador(Usuario usuario) {
        do {
            System.out.println("\n**");
            System.out.println("\n---- BIENVENIDO COORDINADOR ----\n");
            System.out.println("Usuario: " + usuario.getNombreUsuario());
            System.out.println("\n1. Mostrar registro de alumnos graduados");
            System.out.println("2. Alumnos");
            System.out.println("3. Calificaciones");
            System.out.println("4. Profesores");
            System.out.println("5. Avanzar de semestre");
            System.out.println("6. Ver información personal");
            System.out.println("7. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextLine();

            switch (decision) {
                //Ver info Personal
                case "1":
                    Sistema.imprimirGraduados();
                    break;
                case "2":
                    String decisionAlumno;
                    do {
                        System.out.println("\n---- MENÚ DE ALUMNOS ----\n");
                        System.out.println("1. Registrar alumno");
                        System.out.println("2. Consultar alumno");
                        System.out.println("3. Modificar datos de alumno");
                        System.out.println("4. Eliminar alumno");
                        System.out.println("5. Regresar al menú de Coordinador");
                        System.out.print("\nIngrese opción: ");
                        decisionAlumno = scanner.nextLine();

                        switch (decisionAlumno) {
                            case "1":
                                Alumno.registrarAlumno();
                                break;
                            case "2":
                                System.out.println("\nIngrese el semestre del que quiera ver los alumnos");
                                String sem = scanner.nextLine();
                                switch (sem){
                                    case "1":
                                        verListaAlumnosPorSemestre(1);
                                        break;
                                    case "2":
                                        verListaAlumnosPorSemestre(2);
                                        break;
                                    case "3":
                                        verListaAlumnosPorSemestre(3);
                                        break;
                                    default:
                                        System.out.println("\nIngrese una opcion valida");
                                        break;
                                }
                                break;
                            case "3":
                                Alumno.modificarAlumno();
                                break;
                            case "4":
                                Alumno.eliminarAlumno();
                                break;
                            case "5":
                                System.out.println("\nRegresando al menú principal");
                                break;
                            default:
                                System.out.println("\nElige una opción Valida");
                                break;
                        }
                    } while (!decisionAlumno.equals("5"));
                    break;
                case "3":
                    //No estoy segura de que esto funcione jaja
                    menuCalificaciones();
                    break;
                case "4":
                    String decisionProfesor;
                    do {
                        System.out.println("\n---- MENÚ DE PROFESORES ----\n");
                        System.out.println("1. Registrar Profesor");
                        System.out.println("2. Consultar Profesores");
                        System.out.println("3. Modificar datos de un Profesor");
                        System.out.println("4. Eliminar Profesor");
                        System.out.println("5. Regresar al menú de Coordinador");
                        System.out.print("\nIngrese opción: ");
                        decisionProfesor = scanner.nextLine();

                        switch (decisionProfesor) {
                            case "1":
                                Profesor.registrarProfesor();
                                break;
                            case "2":
                                //Consultar profesores
                                Usuario usuarioActual = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();
                                ((Coordinador) usuarioActual).verProfesoresPorCarrera();
                                break;
                            case "3":
                                Profesor.modificarProfesor();
                                break;
                            case "4":
                                Profesor.eliminarProfesor();
                                break;
                            case "5":
                                System.out.println("\nRegresando al menú principal");
                                break;
                            default:
                                System.out.println("\nElige una opción Valida");
                                break;
                        }
                    } while (!decisionProfesor.equals("5"));
                    break;
                case "5":
                    Sistema.subirDeSemestre();
                    break;
                case "6":
                    ((Coordinador) usuario).verInformacionCoordinador();
                    break;
                case "7":
                    System.out.println("\nCerrando Sesion");
                    break;
                default:
                    System.out.println("\nElige una opción Valida");
                    break;
            }
        } while (!decision.equals("7"));
    }


    public void menuAlumno(Usuario usuario) {
        do {
            System.out.println("\n**");
            System.out.println("\n---- BIENVENIDO ALUMNO ----\n");
            System.out.println("Usuario: " + usuario.getNombreUsuario());
            System.out.println("\n1. Ver mis calificaciones");
            System.out.println("2. Ver mis cursos inscritos");
            System.out.println("3. Ver mi información personal");
            System.out.println("4. Cerrar sesión");
            System.out.print("\nIngrese opción: ");
            decision = scanner.nextLine();

            switch (decision) {
                case "1":
                    ((Alumno) usuario).mostrarCalificaciones();
                    break;
                case "2":
                    //Ver Cursos Inscritos
                    break;
                case "3":
                    ((Alumno) usuario).verInformacionPersonal();
                    break;
                case "4":
                    System.out.println("\nCerrando Sesion");
                    break;
                default:
                    System.out.println("\nElige una opción Valida");
                    break;
            }
        } while (!decision.equals("4"));
    }

    public void menuProfesor(Usuario usuario) {
        do {
            System.out.println("\n**");
            System.out.println("\n---- BIENVENIDO MAESTRO ----\n");
            System.out.println("Usuarios: " + usuario.getNombreUsuario());
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
                    ((Profesor) usuario).verInformacionProfesor();
                    break;
                case "5":
                    System.out.println("\nCerrando Sesion");
                    break;
                default:
                    System.out.println("\nElige una opción Valida");
                    break;
            }
        } while (!decision.equals("5"));
    }

    public void menuCalificaciones() {
        String dc;
        do {
            System.out.println("QUE DESEA HACER?\n");
            System.out.println("1. Registrar Calificaciones");
            System.out.println("2. Consultar Calificaciones");
            System.out.println("3. Modificar Calificaciones");
            System.out.println("4. Salir");
            dc = scanner.nextLine();

            switch (dc) {
                case "1":
                    //asignarCalificaciones();
                    break;
                case "2":
                    //Consultar Calificaciones
                    break;
                case "3":
                    //Modificar Calificaciones
                    break;
                case "4":
                    System.out.println("\nSaliendo del Programa");
                    break;
                default:
                    System.out.println("\nElige una opción Valida");
                    break;
            }
        } while (!dc.equals("4"));
    }

    private void verListaAlumnosPorSemestre(int semestre) {
        ArrayList<Usuario> usuarios = Sistema.usuarios.get(Sistema.carrera).get(Rol.ALUMNO);

        List<Alumno> alumnos = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            alumnos.add((Alumno) usuario);
        }

        List<Alumno> alumnosFiltrados = Alumno.filtrarPorSemestre(alumnos, semestre);

        if (!alumnosFiltrados.isEmpty()) {
            System.out.println("\nLista de alumnos del semestre " + semestre + ":");
            for (Alumno alumno : alumnosFiltrados) {
                alumno.verInformacionPersonal();
            }
        } else {
            System.out.println("\nNo hay alumnos inscritos en el semestre especificado.");
        }
    }
}