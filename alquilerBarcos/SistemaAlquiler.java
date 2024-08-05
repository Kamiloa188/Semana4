package alquilerBarcos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SistemaAlquiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Amarre amarre = new Amarre("A001", "Zona 1");

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.nextLine();
        Cliente cliente = new Cliente(nombre, dni);

        System.out.print("Ingrese la matricula del barco: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese la eslora del barco (en metros): ");
        double eslora = scanner.nextDouble();
        System.out.print("Ingrese el ano de fabricacion del barco: ");
        int anoFabricacion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea
        Barco barco = new Barco(matricula, eslora, anoFabricacion);

        System.out.print("Ingrese la fecha de inicio (dd/MM/yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (dd/MM/yyyy): ");
        String fechaFinStr = scanner.nextLine();

        Date fechaInicio = parseFecha(fechaInicioStr, sdf);
        Date fechaFin = parseFecha(fechaFinStr, sdf);

        System.out.print("Ingrese la posicion del amarre: ");
        String posicionAmarre = scanner.nextLine();

        Alquiler alquiler = new Alquiler(cliente, barco, fechaInicio, fechaFin, posicionAmarre);
        amarre.agregarAlquiler(alquiler);

        imprimirRecibo(alquiler);
        scanner.close();
    }

    private static Date parseFecha(String fechaStr, SimpleDateFormat sdf) {
        try {
            return sdf.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Fecha invalida.");
            return new Date();
        }
    }

    private static void imprimirRecibo(Alquiler alquiler) {
        System.out.println("\n--- RECIBO DE INSCRIPCION ---");
        System.out.println("Cliente: " + alquiler.getCliente());
        System.out.println("Barco: " + alquiler.getBarco());
        System.out.println("Fecha de Inicio: " + alquiler.getFechaInicio());
        System.out.println("Fecha de Fin: " + alquiler.getFechaFin());
        System.out.println("Posicion del Amarre: " + alquiler.getPosicionAmarre());
        System.out.println("Numero de Dias: " + alquiler.calcularDias());
        System.out.println("Costo Total: $" + alquiler.calcularCosto());
        System.out.println("------------------------------");
    }
}
