package Banco;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
/**
 *
 * @author 57313
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private int edad;
    private String representante;

    public Cliente(String nombre, String apellido, int edad, String representante) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.representante = representante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getRepresentante() {
        return representante;
    }

    @Override
    public String toString() {
        if (edad < 18) {
            return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", representante=" + representante + '}';
        } else {
            return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
        }
    }
}