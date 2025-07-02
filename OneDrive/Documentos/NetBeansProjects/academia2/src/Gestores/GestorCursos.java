package Gestores;

import clases.Profesor;
import clases.Curso;
import java.io.*;
import java.util.ArrayList;

public class GestorCursos {
    private ArrayList<Curso> cursos;
    private final String archivo = "cursos.txt";

    public GestorCursos() {
        cursos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    public void agregarCurso(Curso curso) {
        if (!existeCurso(curso.getCodigo())) {
            cursos.add(curso);
            guardarEnArchivo();
            System.out.println("Curso registrado exitosamente.");
        } else {
            System.out.println("Ya existe un curso con ese código.");
        }
    }

    public boolean existeCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Curso buscarCurso(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void mostrarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            for (Curso c : cursos) {
                System.out.println(c);
                System.out.println("-----------------------");
            }
        }
    }

    private void cargarDesdeArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
               
                String[] partes = linea.split(",");
                if (partes.length == 5) {
              
                    Profesor profesorTemporal = new Profesor("","", "", "", partes[3], "", "");
                    Curso c = new Curso(
                        partes[0],
                        partes[1],
                        partes[2],
                        profesorTemporal,
                        Integer.parseInt(partes[4])
                    );
                    cursos.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de cursos.");
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Curso c : cursos) {
                pw.println(c.getCodigo() + "," +
                           c.getNombre() + "," +
                           c.getDescripcion() + "," +
                           c.getProfesor().getIdProfesor() + "," +
                           c.getCapacidadMaxima());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de cursos.");
        }
    }
}
