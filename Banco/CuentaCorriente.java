/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package Banco;

/**
 *
 * @author 57313
 */
public class CuentaCorriente extends Cuenta {
    private static final double TASA_MANTENIMIENTO_MENSUAL = 0.015; // 1.5%
    private static final double COSTO_CHEQUE = 3000;

    public CuentaCorriente(String numeroCuenta, Cliente cliente) {
        super(numeroCuenta, cliente);
    }

    @Override
    public void depositar(double monto) {
        if (monto < 500000) {
            saldo += monto - 7000;
        } else if (monto >= 500000 && monto < 2000000) {
            saldo += monto - 5000 - (0.02 * monto);
        } else if (monto >= 2000000 && monto <= 10000000) {
            saldo += monto - 4000 - (0.02 * monto);
        } else if (monto > 10000000) {
            saldo += monto - (0.033 * monto);
        } else {
            saldo += monto;
        }
    }

    @Override
    public void retirar(double monto) {
        saldo -= monto;
    }

    public void emitirCheque() {
        saldo -= COSTO_CHEQUE;
    }

    @Override
    public void aplicarCargosMensuales() {
        saldo -= saldo * TASA_MANTENIMIENTO_MENSUAL;
    }
}
