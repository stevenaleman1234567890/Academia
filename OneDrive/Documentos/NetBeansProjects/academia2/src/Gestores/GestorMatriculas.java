package Gestores;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import clases.Matricula;
import Excepciones.CapacidadMaximaException;
import Excepciones.EstudianteDuplicadoException;
import clases.Estudiante;
import clases.Curso;

public class GestorMatriculas {
    private ArrayList<Matricula> matriculas;
    private final String archivo = "matriculas.txt";

    private Gestorestudiantes gestorEstudiantes;
    private GestorCursos gestorCursos;

    public GestorMatriculas(Gestorestudiantes gestorEstudiantes, GestorCursos gestorCursos) {
        this.matriculas = new ArrayList<>();
        this.gestorEstudiantes = gestorEstudiantes;
        this.gestorCursos = gestorCursos;
        cargarDesdeArchivo();
    }

    
    public void matricular(String carnetEstudiante, String codigoCurso) {
        Estudiante estudiante = buscarEstudiantePorCarnet(carnetEstudiante);
        Curso curso = gestorCursos.buscarCurso(codigoCurso);

        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        try {
            curso.agregarEstudiante(estudiante); 
            Matricula m = new Matricula(estudiante, curso, LocalDate.now());
            matriculas.add(m);
            guardarEnArchivo();
            System.out.println("Matrícula realizada correctamente.");
        } catch (EstudianteDuplicadoException | CapacidadMaximaException e) {
            System.out.println("No se pudo matricular: " + e.getMessage());
        }
    }

   
    public void mostrarMatriculas() {
        if (matriculas.isEmpty()) {
            System.out.println("No hay matrículas registradas.");
        } else {
            for (Matricula m : matriculas) {
                System.out.println(m);
            }
        }
    }

    
    private Estudiante buscarEstudiantePorCarnet(String carnet) {
        for (Estudiante e : gestorEstudiantes.getEstudiantes()) {
            if (e.getCarnet().equalsIgnoreCase(carnet)) {
                return e;
            }
        }
        return null;
    }

    
    private void cargarDesdeArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
              
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    Estudiante e = buscarEstudiantePorCarnet(partes[0]);
                    Curso c = gestorCursos.buscarCurso(partes[1]);
                    LocalDate fecha = LocalDate.parse(partes[2]);

                    if (e != null && c != null) {
                        try {
                            c.agregarEstudiante(e);
                            Matricula m = new Matricula(e, c, fecha);
                            matriculas.add(m);
                        } catch (Exception ignored) {}
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de matrículas.");
        }
    }

    
    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Matricula m : matriculas) {
                pw.println(m.getEstudiante().getCarnet() + "," +
                           m.getCurso().getCodigo() + "," +
                           m.getFechaMatricula());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de matrículas.");
        }
    }
}

