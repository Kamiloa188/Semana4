/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package Banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void abrirCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null;
    }

    public void transferir(String numeroCuentaOrigen, String numeroCuentaDestino, double monto) {
        Cuenta origen = buscarCuenta(numeroCuentaOrigen);
        Cuenta destino = buscarCuenta(numeroCuentaDestino);

        if (origen != null && destino != null) {
            origen.retirar(monto);
            destino.depositar(monto);
        } else {
            System.out.println("Una o ambas cuentas no existen.");
        }
    }

    public void cerrarMes() {
        for (Cuenta cuenta : cuentas) {
            cuenta.aplicarCargosMensuales();
        }
    }

    public void mostrarEstadoCuentas() {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }
}
