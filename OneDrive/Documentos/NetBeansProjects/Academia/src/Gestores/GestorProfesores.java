package Gestores;
import Clases.Profesor;
import java.io.*;
import java.util.ArrayList;

public class GestorProfesores {
    private ArrayList<Profesor> Profesores;
    private final String archivo = "Profesores.txt";
    
    public GestorProfesores() {
      Profesores = new ArrayList<>();
       cargarDesdeArchivo();
    }
    public void agregarProfesor(Profesor profesor){
        if (Profesores.contains(profesor)){
          Profesores.add(profesor);
          guardarEnArchivo();
           System.out.println("El profesor ya esta registrado con exito.");
        } else{
          System.out.println("El profesor ya existe.");
        }
    }
    public ArrayList<Profesor> getProfesores(){
     return Profesores;
    }
    public void mostrarProfesores() {
     if (Profesores.isEmpty()){
      System.out.print("No hay Profesores registrados ahorita");
     } else{
      for (Profesor p : Profesores){
        System.out.println(p);
      }
     }
    }
    private void cargarDesdeArchivo(){
    File file = new File (archivo);
    if (file.exists())return;
    
    try (BufferedReader br = new BufferedReader(new FileReader(file))){
      String linea;
      while ((linea = br.readLine())!= null) {
      String[] partes = linea.split(",");
      if (partes.length == 7) {
        Profesor p = new Profesor(
            partes[1] ,
            partes[2] ,
            partes[3] ,
            partes[4] ,
            partes[0] ,
            partes[5] ,
            partes[6]); Profesores.add(p);
      }
      }
    } catch (IOException e){
      System.out.println("Error al leer el archivo de los Profesores");
    }
    }
    private void guardarEnArchivo() {
      try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))){
        for (Profesor p : Profesores){
         pw.println(p.getIDprofesor() + "," +
                    p.getNombres() + "," +
                    p.getApellidos() + "," +
                    p.getEmail() + "," +
                    p.getTelefono() + "," +
                    p.getEspecialida() + "," +
                    p.getTipocontrato());
        }
      } catch (IOException e){
        System.out.println("Error al guardar el archivo de profesores");
      }
    }
}
