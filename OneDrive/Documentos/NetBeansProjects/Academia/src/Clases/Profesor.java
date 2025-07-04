
package Clases;

public class Profesor extends Persona {
    private String IDprofesor;
    private String Especialida;
    private String Tipocontrato;

    public Profesor(String IDprofesor, String Especialida, String Tipocontrato, String Nombres, String Apellidos, String Email, String Telefono) {
        super(Nombres, Apellidos, Email, Telefono);
        this.IDprofesor = IDprofesor;
        this.Especialida = Especialida;
        this.Tipocontrato = Tipocontrato;
    }

    public String getIDprofesor() {
        return IDprofesor;
    }

    public String getEspecialida() {
        return Especialida;
    }

    public String getTipocontrato() {
        return Tipocontrato;
    }

    public void setIDprofesor(String IDprofesor) {
        this.IDprofesor = IDprofesor;
    }

    public void setEspecialida(String Especialida) {
        this.Especialida = Especialida;
    }

    public void setTipocontrato(String Tipocontrato) {
        this.Tipocontrato = Tipocontrato;
    }

    @Override
    public String toString() {
        return "Profesor{" + "IDprofesor=" + IDprofesor + ", Especialida=" + Especialida + ", Tipocontrato=" + Tipocontrato + '}';
    }
    
    
}
