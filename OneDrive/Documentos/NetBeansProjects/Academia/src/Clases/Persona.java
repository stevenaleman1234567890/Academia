package Clases;

public class Persona {
    private String Nombres;
    private String Apellidos;
    private String Email;
    private String telefono;

    public Persona(String Nombres, String Apellidos, String Email, String telefono) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Email = Email;
        this.telefono = telefono;
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
        return telefono;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "Nombres=" + Nombres + ", Apellidos=" + Apellidos + ", Email=" + Email + ", telefono=" + telefono + '}';
    }
    
    
}
