/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package alquilerBarcos;

/**
 *
 * @author 57313
 */
public class Cliente {
    private String nombre;
    private String dni;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", dni=" + dni + '}';
    }
}
