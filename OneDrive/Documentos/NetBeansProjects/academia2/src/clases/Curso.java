package clases;
import java.util.ArrayList;
import Excepciones.CapacidadMaximaException;
import Excepciones.EstudianteDuplicadoException;


public class Curso {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Profesor profesor;
    private int capacidadMaxima;
    private ArrayList<Estudiante> listaEstudiantes;

    
    public Curso(String codigo, String nombre, String descripcion, Profesor profesor, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
        this.listaEstudiantes = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Profesor getProfesor() { return profesor; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public ArrayList<Estudiante> getListaEstudiantes() { return listaEstudiantes; }

    
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setProfesor(Profesor profesor) { this.profesor = profesor; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    
    public void agregarEstudiante(Estudiante estudiante)
            throws EstudianteDuplicadoException, CapacidadMaximaException {

   
        if (listaEstudiantes.contains(estudiante)) {
            throw new EstudianteDuplicadoException("El estudiante ya está matriculado en este curso.");
        }

    
        if (listaEstudiantes.size() >= capacidadMaxima) {
            throw new CapacidadMaximaException("El curso ha alcanzado su capacidad máxima.");
        }
        
        listaEstudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Curso: " + nombre + " (" + codigo + ")\n" +
               "Descripción: " + descripcion + "\n" +
               "Profesor: " + profesor.getNombres() + " " + profesor.getApellidos() + "\n" +
               "Capacidad máxima: " + capacidadMaxima + "\n" +
               "Estudiantes inscritos: " + listaEstudiantes.size();
    }
}
