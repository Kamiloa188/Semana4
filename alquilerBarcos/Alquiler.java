/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to cambiar este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java para editar este template
 */
package alquilerBarcos;

import java.util.Date;

/**
 *
 * @author 57313
 */
public class Alquiler {

    private Cliente cliente;
    private Barco barco;
    private Date fechaInicio;
    private Date fechaFin;
    private String posicionAmarre;

    public Alquiler(Cliente cliente, Barco barco, Date fechaInicio, Date fechaFin, String posicionAmarre) {
        this.cliente = cliente;
        this.barco = barco;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.posicionAmarre = posicionAmarre;
    }

    public int calcularDias() {
        long diferencia = fechaFin.getTime() - fechaInicio.getTime();
        return (int) (diferencia / (1000 * 60 * 60 * 24));
    }

    public double calcularCosto() {
        int dias = calcularDias();
        double costoPorDia = 25000; // en pesos
        double costoTotal = dias * costoPorDia;
        return costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(String posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "cliente=" + cliente + ", barco=" + barco + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", posicionAmarre=" + posicionAmarre + '}';
    }

}
