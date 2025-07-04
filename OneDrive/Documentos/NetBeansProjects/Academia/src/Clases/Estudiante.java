
package Clases;

public class Estudiante extends Persona {
    private String Carnet;
    private String carrera;
    private String Nivel;

    public Estudiante(String Carnet, String carrera, String Nivel, String Nombres, String Apellidos, String Email, String Telefono) {
        super(Nombres, Apellidos, Email, Telefono);
        this.Carnet = Carnet;
        this.carrera = carrera;
        this.Nivel = Nivel;
    }

    public String getCarnet() {
        return Carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setNivel(String Nivel) {
        this.Nivel = Nivel;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Carnet=" + Carnet + ", carrera=" + carrera + ", Nivel=" + Nivel + '}';
    }
    
    
}
