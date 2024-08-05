/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change este license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit este template
 */
package Banco;

import java.util.Scanner;

/**
 *
 * @author 57313
 */
public class main {

    /**
     * @param args los argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcion;
        do {
            System.out.println("\n--- Sistema Bancario ---");
            System.out.println("1. Abrir Cuenta");
            System.out.println("2. Transferencias");
            System.out.println("3. Cajero Automatico");
            System.out.println("4. Cierre de Mes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    abrirCuenta(scanner, banco);
                    break;
                case 2:
                    realizarTransferencia(scanner, banco);
                    break;
                case 3:
                    operarCajero(scanner, banco);
                    break;
                case 4:
                    banco.cerrarMes();
                    banco.mostrarEstadoCuentas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void abrirCuenta(Scanner scanner, Banco banco) {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese edad del cliente: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        String representante = null;
        if (edad < 18) {
            System.out.print("Ingrese nombre del representante: ");
            representante = scanner.nextLine();
        }

        Cliente cliente = new Cliente(nombre, apellido, edad, representante);

        System.out.print("Ingrese tipo de cuenta (Ahorro/Corriente): ");
        String tipoCuenta = scanner.nextLine();

        System.out.print("Ingrese numero de cuenta: ");
        String numeroCuenta = scanner.nextLine();

        Cuenta cuenta = null;
        if (tipoCuenta.equalsIgnoreCase("Ahorro")) {
            cuenta = new CuentaAhorro(numeroCuenta, cliente);
        } else if (tipoCuenta.equalsIgnoreCase("Corriente")) {
            cuenta = new CuentaCorriente(numeroCuenta, cliente);
        } else {
            System.out.println("Tipo de cuenta no valido.");
            return;
        }

        banco.abrirCuenta(cuenta);
        System.out.println("Cuenta abierta con exito: " + cuenta);
    }

    private static void realizarTransferencia(Scanner scanner, Banco banco) {
        System.out.print("Ingrese numero de cuenta origen: ");
        String numeroCuentaOrigen = scanner.nextLine();
        System.out.print("Ingrese numero de cuenta destino: ");
        String numeroCuentaDestino = scanner.nextLine();
        System.out.print("Ingrese monto a transferir: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de linea

        banco.transferir(numeroCuentaOrigen, numeroCuentaDestino, monto);
    }

    private static void operarCajero(Scanner scanner, Banco banco) {
        System.out.print("Ingrese numero de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        Cuenta cuenta = banco.buscarCuenta(numeroCuenta);

        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.print("Ingrese monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de linea

        cuenta.retirar(monto);
        System.out.println("Transaccion exitosa. Nuevo saldo: " + cuenta.getSaldo());
    }
}
