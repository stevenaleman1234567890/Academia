package Gestores;
import Clases.Estudiante;
import java.io.*;
import java.util.ArrayList;

public class GestorEstudiantes {
    private ArrayList<Estudiante> Estudiantes;
    private final String archivo =  "Estudiantes.txt";
    
    public GestorEstudiantes(){
    Estudiantes = new ArrayList<>();
    cargarDesdeArchivo();
    }
    
    public void AgregarEstudiantes(Estudiante estudiante){
      if (Estudiantes.contains(estudiante)){
       Estudiantes.add(estudiante);
         guardarEnArchivo();
         System.out.println("Estudiante Registrado con Exito.");
      } else{
         System.out.println("El estudiante ya esta registrado en el sistema.");
      }
    }
    public ArrayList<Estudiante> GetEstudiantes(){
      return Estudiantes;
    }
    public void mostraEstudiantes(){
      if (Estudiantes.isEmpty()){
         System.out.println("No Hay estudiantes registratos en el sistema");
      } else {
       for (Estudiante e : Estudiantes){
         System.out.println(e);
       }
      }
    }
    private void cargarDesdeArchivo(){
      File file = new File(archivo);
      if (!file.exists())return;
      
      try (BufferedReader br = new BufferedReader(new FileReader(file))){
        String linea;
        while ((linea = br.readLine()) != null){
        
            String[] partes = linea.split(",");
            if (partes.length ==7){
             Estudiante e = new Estudiante(
                     partes[1],
                     partes[2],
                     partes[3],
                     partes[4],
                     partes[0],
                     partes[5],
                     partes[6]
             );
             Estudiantes.add(e);
            }
        }
      } catch (IOException e){
          System.out.println("Error al leer el archivo estudiantes.");
      }
    }
    private void guardarEnArchivo(){
      try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))){
         for (Estudiante e : Estudiantes){
            pw.println(e.getCarnet() + "," + 
                       e.getNombres() + "," +
                       e.getApellidos() + "," + 
                       e.getEmail() + "," +
                       e.getTelefono() + "," +
                       e.getCarrera() + "," + 
                       e.getNivel());
         }
      } catch (IOException e){
          System.out.println("Error al guardar este archivo");
      }
    }
}
