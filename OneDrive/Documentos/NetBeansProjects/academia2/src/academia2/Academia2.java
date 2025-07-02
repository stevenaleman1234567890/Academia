package academia2;

import Gestores.GestorCursos;
import Gestores.GestorMatriculas;
import Gestores.GestorProfesores;
import Gestores.Gestorestudiantes;
import clases.Curso;
import clases.Estudiante;
import clases.Profesor;
import java.util.Scanner;

public class Academia2 {
    public static void main(String[] args) {
        Gestorestudiantes gestorEstudiantes = new Gestorestudiantes();
        GestorProfesores gestorProfesores = new GestorProfesores();
        GestorCursos gestorCursos = new GestorCursos();
        GestorMatriculas gestorMatriculas = new GestorMatriculas(gestorEstudiantes, gestorCursos);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE ACADEMIA =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar profesor");
            System.out.println("3. Registrar curso");
            System.out.println("4. Matricular estudiante en curso");
            System.out.println("5. Ver lista de estudiantes");
            System.out.println("6. Ver lista de profesores");
            System.out.println("7. Ver lista de cursos");
            System.out.println("8. Ver lista de matrículas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRO DE ESTUDIANTE ---");
                    System.out.print("Carnet: ");
                    String carnet = scanner.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();
                    System.out.print("Nivel: ");
                    String nivel = scanner.nextLine();

                    Estudiante estudiante = new Estudiante(nombres, apellidos, email, telefono, carnet, carrera, nivel);
                    gestorEstudiantes.agregarEstudiante(estudiante);
                    break;

                case 2:
                    System.out.println("\n--- REGISTRO DE PROFESOR ---");
                    System.out.print("ID Profesor: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombres: ");
                    String nomP = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apeP = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailP = scanner.nextLine();
                    System.out.print("Telefono: ");
                    String telP = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Tipo de contrato (Tiempo completo / Por horas): ");
                    String tipoContrato = scanner.nextLine();

                    Profesor profesor = new Profesor(nomP, apeP, emailP, telP, id, especialidad, tipoContrato);
                    gestorProfesores.agregarProfesor(profesor);
                    break;

                case 3:
                    System.out.println("\n--- REGISTRO DE CURSO ---");
                    System.out.print("Codigo del curso: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    System.out.print("Descripcion: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("ID del profesor asignado: ");
                    String idProfesor = scanner.nextLine();
                    Profesor profeAsignado = null;

                   
                    for (Profesor p : gestorProfesores.getProfesores()) {
                        if (p.getIdProfesor().equalsIgnoreCase(idProfesor)) {
                            profeAsignado = p;
                            break;
                        }
                    }

                    if (profeAsignado == null) {
                        System.out.println("Profesor no encontrado.");
                        break;
                    }

                    System.out.print("Capacidad maxima del curso: ");
                    int capacidad = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    Curso nuevoCurso = new Curso(codigo, nombreCurso, descripcion, profeAsignado, capacidad);
                    gestorCursos.agregarCurso(nuevoCurso);
                    break;

                case 4:
                    System.out.println("\n--- MATRICULA DE ESTUDIANTE ---");
                    System.out.print("Carnet del estudiante: ");
                    String carnetMat = scanner.nextLine();
                    System.out.print("Codigo del curso: ");
                    String codigoMat = scanner.nextLine();

                    gestorMatriculas.matricular(carnetMat, codigoMat);
                    break;

                case 5:
                    System.out.println("\n--- LISTA DE ESTUDIANTES ---");
                    gestorEstudiantes.mostrarEstudiantes();
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE PROFESORES ---");
                    gestorProfesores.mostrarProfesores();
                    break;

                case 7:
                    System.out.println("\n--- LISTA DE CURSOS ---");
                    gestorCursos.mostrarCursos();
                    break;

                case 8:
                    System.out.println("\n--- LISTA DE MATRICULAS ---");
                    gestorMatriculas.mostrarMatriculas();
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema");
                    break;

                default:
                    System.out.println("Opción invalida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
}
