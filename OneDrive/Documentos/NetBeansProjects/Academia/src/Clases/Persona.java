package Clases;

public class Persona {
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String Telefono;

    public Persona(String Nombres, String Apellidos, String Email, String Telefono) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.Telefono = Telefono;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getEmail() {
        return Email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Email=" + Email + ", Telefono=" + Telefono + '}';
    }
    
    
}
