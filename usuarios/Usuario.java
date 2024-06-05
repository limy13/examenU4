package usuarios;


import java.time.LocalDate;
import java.util.*;

import carreras.utils.*;
import sistema.Sistema;
import usuarios.utils.Rol;

public class Usuario {
    private String nombre, apellido, ciudad, estado, curp, fechaRegistro, direccion, numeroControl, nombreUsuario, contrasena, fechaNacimiento;
    private Carreras carrera;
    private Rol rol;

    public Usuario(String nombre, String apellido, String ciudad, String estado, String curp, String direccion, String numeroControl, String fechaNacimiento, Carreras carrera, Rol rol, String nombreUsuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.estado = estado;
        this.curp = curp;
        this.fechaRegistro = String.valueOf(LocalDate.now());
        this.direccion = direccion;
        this.numeroControl = numeroControl;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public Rol getRol() {
        return rol;
    }

    public static ArrayList<String> datosComun(Rol rol) {
        ArrayList<String> datosComun = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String rolUsuario = rol == Rol.ALUMNO ? "Usuarios.Alumno" : rol == Rol.PROFESOR ? "Usuarios.Profesor" : "Usuarios.Coordinador";

        System.out.println(String.format("\n\n---- Bienvenido al registro del %s", rolUsuario + " ----"));
        System.out.println("\nIngresa los siguientes datos para continuar con el registro: ");
        System.out.print("\nNombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido paterno: ");
        String apellidoP = scanner.nextLine();
        System.out.print("Apellido materno: ");
        String apellidoM = scanner.nextLine();
        String fechaNacimiento = validarFecha();
        System.out.print("Género (H/M): ");
        String genero = scanner.nextLine().toUpperCase();
        System.out.print("Estado: ");
        String estado = validarEstado(scanner.nextLine());
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        String nombreUsuario = registrarNombreUsuario();
        String numeroControl = generarNumeroControl(nombre.charAt(0), rol);
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        String estadoAbrev = obtenerAbreviaturaEstado(estado);
        String curp = generarCurp(nombre, apellidoP, apellidoM, fechaNacimiento, genero, estadoAbrev);

        datosComun.addAll(Arrays.asList(nombre, apellidoP.concat(" ").concat(apellidoM), fechaNacimiento, estado, ciudad, direccion, curp.toUpperCase(), nombreUsuario, contrasena, numeroControl));
        return datosComun;
    }

    public static String registrarNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario = "";
        boolean nombreUsuarioExistente = true;
        do {
            System.out.print("Ingresa el nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for (Map<Rol, ArrayList<Usuario>> usuariosList : Sistema.usuarios.values()) {
                for (ArrayList<Usuario> usuarios : usuariosList.values()) {
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                            nombreUsuarioExistente = true;
                            System.out.println("\nEste nombre de usuario ya ha sido registrado, por favor ingrese uno diferente");
                            break;
                        }
                    }
                }
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }

    public static String generarNumeroControl(char letraNombre, Rol rol) {
        boolean band = false;
        String numeroControl = "";
        String caracter = rol == Rol.ALUMNO ? "L" : rol == Rol.PROFESOR ? "M" : "C";
        String siglasCarrera = Sistema.carrera == Carreras.ISC ? "ISC" : Sistema.carrera == Carreras.IMAT ? "IMAT" : "ELC";

        numeroControl = numeroControl + caracter + letraNombre + "24" + siglasCarrera;

        for (Usuario usuario : Sistema.usuarios.get(Sistema.carrera).get(rol)) {
            String[] numeroPartes = usuario.getNumeroControl().split("-");
            if (numeroPartes[0].equals(numeroControl)) {
                int numero = Integer.parseInt(numeroPartes[1]) + 1;
                numeroControl = numeroControl + "-" + numero;
                band = true;
                break;
            }
        }

        if (!band) {
            numeroControl = numeroControl + "-" + 0;
        }
        return numeroControl;
    }

    public static String obtenerPrimeraVocal(String apellido) {
        String apellidoUpper = apellido.toUpperCase();
        for (int i = 1; i < apellidoUpper.length(); i++) {
            char c = apellidoUpper.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return String.valueOf(c);
            }
        }
        return "X";
    }

    public static String validarFecha() {
        Scanner scanner = new Scanner(System.in);
        boolean fechaValida = false;
        String fechaIngresada = "";

        while (!fechaValida) {
            System.out.print("Ingresa una fecha con formato yyyy-MM-dd: ");
            fechaIngresada = scanner.nextLine();

            String[] partesFecha = fechaIngresada.split("-");
            int año = Integer.parseInt(partesFecha[0]);
            int mes = Integer.parseInt(partesFecha[1]);
            int dia = Integer.parseInt(partesFecha[2]);

            // si año es == a el actual hacer esto
            if (año == LocalDate.now().getYear()) {
                if (mes >= 1 && mes <= 12 && mes <= LocalDate.now().getMonthValue()) {
                    // Validar el dia
                    if (dia >= 1 && dia <= obtenerDiasEnMes(mes)) {
                        fechaValida = true;
                    } else {
                        System.out.println("\nError: El dia ingresado no corresponde al mes especificado.");
                    }
                } else {
                    System.out.println("\nError: El mes ingresado no es valido.");
                }
            }

            // Verificar que el año no sea futuro pero tampoco presente
            if (año < LocalDate.now().getYear() && año > 1907) {
                // Validar el mes
                if (mes >= 1 && mes <= 12) {
                    // Validar el dia
                    if (dia >= 1 && dia <= obtenerDiasEnMes(mes)) {
                        fechaValida = true;
                    } else {
                        System.out.println("\nError: El dia ingresado no corresponde al mes especificado.");
                    }
                } else {
                    System.out.println("\nError: El mes ingresado no es valido.");
                }
            } else {
                System.out.println("\nError: El año ingresado no puede ser un año futuro o muy muy viejo.");
            }
        }

        return fechaIngresada;
    }

    public static int obtenerDiasEnMes(int mes) {
        switch (mes) {
            case 2:
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30; // Abril, junio, septiembre y noviembre tienen 30 dias
            default:
                return 31; // Los demas meses tienen 31 dias
        }
    }

    public void verInformacionPersonal() {
        System.out.println("---- Información Personal ----");
        System.out.println("Nombre completo: " + this.nombre + " " + this.apellido);
        System.out.println("Fecha de nacimiento: " + this.fechaNacimiento);
        System.out.println("Ciudad: " + this.ciudad);
        System.out.println("Estado: " + this.estado);
        System.out.println("CURP: " + this.curp);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Fecha de registro: " + this.fechaRegistro);
        System.out.println("Número de control: " + this.numeroControl);
        System.out.println("carreras.Carrera: " + this.carrera);
    }

    private static final List<String> ESTADOS_MEXICO = Arrays.asList(
            "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Ciudad de Mexico",
            "Coahuila", "Colima", "Durango", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Mexico", "Michoacan",
            "Morelos", "Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Queretaro", "Quintana Roo", "San Luis Potosi",
            "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas"
    );

    private static final Map<String, String> ESTADOS_ABREVIATURAS = new HashMap<String, String>() {{
        put("Aguascalientes", "AS");
        put("Baja California", "BC");
        put("Baja California Sur", "BS");
        put("Campeche", "CC");
        put("Chiapas", "CS");
        put("Chihuahua", "CH");
        put("Ciudad de Mexico", "DF");
        put("Coahuila", "CL");
        put("Colima", "CM");
        put("Durango", "DG");
        put("Guanajuato", "GT");
        put("Guerrero", "GR");
        put("Hidalgo", "HG");
        put("Jalisco", "JC");
        put("Mexico", "MC");
        put("Michoacan", "MN");
        put("Morelos", "MS");
        put("Nayarit", "NT");
        put("Nuevo Leon", "NL");
        put("Oaxaca", "OC");
        put("Puebla", "PL");
        put("Queretaro", "QT");
        put("Quintana Roo", "QR");
        put("San Luis Potosi", "SP");
        put("Sinaloa", "SL");
        put("Sonora", "SR");
        put("Tabasco", "TC");
        put("Tamaulipas", "TS");
        put("Tlaxcala", "TL");
        put("Veracruz", "VZ");
        put("Yucatan", "YN");
        put("Zacatecas", "ZS");
    }};

    public static String validarEstado(String estado) {
        Scanner scanner = new Scanner(System.in);
        estado = estado.toLowerCase();
        List<String> estadosNormalizados = new ArrayList<>();
        for (String estadoValido : ESTADOS_MEXICO) {
            estadosNormalizados.add(estadoValido.toLowerCase());
        }
        while (!estadosNormalizados.contains(estado)) {
            System.out.println("Estado no valido. Por favor, ingresa un estado valido en Mexico: ");
            estado = scanner.nextLine().toLowerCase();
        }
        int index = estadosNormalizados.indexOf(estado);
        return ESTADOS_MEXICO.get(index);
    }

    public static String obtenerAbreviaturaEstado(String estado) {
        return ESTADOS_ABREVIATURAS.getOrDefault(estado, "XX");
    }

    public static String generarCurp(String nombre, String apellidoP, String apellidoM, String fechaNacimiento, String genero, String estadoAbrev) {
        String primerLetraApellidoP = apellidoP.substring(0, 1).toUpperCase();
        String primeraVocalApellidoP = obtenerPrimeraVocal(apellidoP);
        String primerLetraApellidoM = apellidoM.substring(0, 1).toUpperCase();
        String primerLetraNombre = nombre.substring(0, 1).toUpperCase();
        String[] fecha = fechaNacimiento.split("-");
        String año = fecha[0].substring(2);
        String mes = fecha[1];
        String dia = fecha[2];

        String curp = primerLetraApellidoP + primeraVocalApellidoP + primerLetraApellidoM + primerLetraNombre + año + mes + dia + genero + estadoAbrev;

        Random random = new Random();
        String homoclave = "";
        for (int i = 0; i < 3; i++) {
            char caracter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".length()));
            homoclave += caracter;
        }
        curp += homoclave;

        return curp;
    }

    static char validarGrupo(){
        Scanner scanner = new Scanner(System.in);
        char grupoIngresado;
        while (true){
            grupoIngresado = scanner.nextLine().toUpperCase().charAt(0);
            if(grupoIngresado == 'A' || grupoIngresado == 'B'){
                break;
            }else{
                System.out.println("--- Ese grupo no existe intentalo de nuevo ---");
            }
        }
        return grupoIngresado;
    }
}