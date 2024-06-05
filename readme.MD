## Proyecto POO - Examen Final

### Integrantes

- García Tinajero Lizeth
- Meneses Diaz Mariana Sofia
- López Martínez Eduardo
- Aguilar Garnica Alfredo
- Arguello Escutia Luis Antonio

El Instituto Tecnológico de Morelia requiere un nuevo sistema para gestionar todas las actividades escolares, incluyendo la gestión de alumnos, maestros, administrativos y grupos. Este proyecto se ha denominado “Mindbox” y está sujeto a un proceso de licitación. El objetivo es desarrollar un sistema robusto y funcional que esté listo para el 5 de junio de 2024.

### Objetivos
El objetivo principal del sistema Mindbox es gestionar eficientemente las operaciones escolares. Entre los requerimientos clave se incluyen la carga inicial de datos, el almacenamiento de información en archivos JSON, la gestión de carreras, semestres, grupos y materias, así como la asignación y consulta de calificaciones. Además, se deberá implementar roles para alumnos, profesores y coordinadores con distintas capacidades y responsabilidades.

### Requerimientos Específicos

#### Inicialización
- Cargar 3 carreras predeterminadas la primera vez que se ejecute el programa.
- Mantener los datos y cambios realizados en ejecuciones posteriores mediante archivos JSON.
- Incluir un coordinador por carrera al iniciar el sistema.

#### Carreras
- El sistema debe incluir tres carreras: Ingeniería en Sistemas Computacionales (ISC), Ingeniería en Materiales (IMAT) e Ingeniería Electrónica (ELC).
- Atributos de una carrera: Id, Nombre, Cantidad de grupos, Cantidad de alumnos, Cantidad de materias, Fecha de creación, Coordinador.

#### Semestres
- Gestionar 3 semestres.
- Permitir el avance de semestres para grupos, asignando nuevas materias y reseteando calificaciones.
- Reprobar alumnos si no aprueban todas las materias o no tienen todas las calificaciones registradas.
- Atributos del semestre: Id, Número de semestre, Carrera, Grupos.

#### Graduados
- Registrar alumnos graduados con datos como Fecha de graduación, Carrera, Alumnos (con promedio) y Generación de graduación.

#### Grupos
- Los grupos deben tener entre 3 y 20 estudiantes y máximo dos grupos por carrera (A y B).
- Atributos de un grupo: Id, Carrera, Tipo de grupo (A o B), Alumnos, Materias, Semestre.

#### Materias
- Las materias dependen del semestre y carrera.
- Atributos de una materia: Id, Carrera, Grupo, Profesor, Semestre.

#### Calificaciones
- Los profesores y coordinadores pueden registrar y consultar calificaciones.
- Los alumnos pueden ver sus calificaciones por semestre y materia.
- Una vez avanzado el semestre, las calificaciones no pueden modificarse.

#### Historial
- Los alumnos pueden ver todo su historial académico, incluyendo materias cursadas, calificaciones, profesores y promedio por semestre.

#### Roles
El sistema incluirá tres roles:
1. **Alumno**: Gestionado por el coordinador. Cada alumno tendrá un número de control único y podrá ver su información académica.
    - Atributos: Nombre, Apellidos, Año de nacimiento, Ciudad, Estado, CURP, Dirección, Fecha de registro, Carrera, Semestre, Grupo, Promedio, Número de control.
2. **Profesor**: Gestionado por el coordinador. Puede impartir más de una materia y consultar y actualizar su información.
    - Atributos: Nombre, Apellidos, Año de nacimiento, Ciudad, Estado, CURP, Dirección, Fecha de registro, RFC, Materias que imparte, Sueldo, Número de control.
3. **Coordinador**: Debe existir desde el inicio. Puede gestionar toda la información de su carrera y avanzar semestres.
    - Atributos: Nombre, Apellidos, Año de nacimiento, Ciudad, Estado, CURP, Dirección, Fecha de registro, RFC, Materias que imparte, Sueldo.

