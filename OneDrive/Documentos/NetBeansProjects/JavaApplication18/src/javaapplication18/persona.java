/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication18;

public class persona {
   private String Nombres;
   private String apellidos;

    public persona(String Nombres, String apellidos) {
        this.Nombres = Nombres;
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "persona{" + "Nombres=" + Nombres + ", apellidos=" + apellidos + '}';
    }
   
   
}
