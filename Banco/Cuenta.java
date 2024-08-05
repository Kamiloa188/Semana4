/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package Banco;

/**
 *
 * @author 57313
 */
public abstract class Cuenta {
    protected String numeroCuenta;
    protected Cliente cliente;
    protected double saldo;

    public Cuenta(String numeroCuenta, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void depositar(double monto);
    public abstract void retirar(double monto);
    public abstract void aplicarCargosMensuales();

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", cliente=" + cliente + ", saldo=" + saldo + '}';
    }
}
