/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit este template
 */
package Banco;

/**
 *
 * @author 57313
 */
public class CuentaAhorro extends Cuenta {
    private static final double TASA_RENDIMIENTO_ANUAL = 0.022; // 2.2%

    public CuentaAhorro(String numeroCuenta, Cliente cliente) {
        super(numeroCuenta, cliente);
    }

    @Override
    public void depositar(double monto) {
        if (monto >= 500000 && monto < 2000000) {
            saldo += monto - 3000 - (0.01 * monto);
        } else if (monto >= 2000000 && monto <= 10000000) {
            saldo += monto - 2000 - (0.005 * monto);
        } else if (monto > 10000000 && monto <= 100000000) {
            saldo += monto - (0.018 * monto);
        } else if (monto > 100000000) {
            saldo += monto - (0.02 * monto);
        } else {
            saldo += monto;
        }
    }

    @Override
    public void retirar(double monto) {
        saldo -= monto;
    }

    @Override
    public void aplicarCargosMensuales() {
        double interesMensual = saldo * (TASA_RENDIMIENTO_ANUAL / 12);
        saldo += interesMensual;
    }
}
