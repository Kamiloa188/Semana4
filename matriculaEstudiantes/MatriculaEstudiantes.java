package matriculaEstudiantes;

import java.util.Scanner;

public class MatriculaEstudiantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al sistema de matricula de estudiantes");
            System.out.println("Por favor, seleccione una carrera:");
            System.out.println("1. Ingenieria de Sistemas");
            System.out.println("2. Medicina");
            System.out.println("3. Derecho");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarEstudiante(scanner, "Ingenieria de Sistemas");
                    break;
                case 2:
                    registrarEstudiante(scanner, "Medicina");
                    break;
                case 3:
                    registrarEstudiante(scanner, "Derecho");
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void registrarEstudiante(Scanner scanner, String carrera) {
        // Leer el nombre del estudiante
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        // Leer el apellido del estudiante
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        // Leer el documento del estudiante
        System.out.print("Ingrese el documento: ");
        String documento = scanner.nextLine();

        // Leer la direccion del estudiante
        System.out.print("Ingrese la direccion: ");
        String direccion = scanner.nextLine();

        // Leer el telefono del estudiante
        System.out.print("Ingrese el telefono: ");
        String telefono = scanner.nextLine();

        // Leer el semestre del estudiante
        System.out.print("Ingrese el semestre actual: ");
        int semestre = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Leer si el curso es en linea
        System.out.print("¿El curso es en linea? (si/no): ");
        boolean esEnLinea = scanner.nextLine().equalsIgnoreCase("si");

        // Si no es en linea, pedir el número de materias perdidas y créditos perdidos
        int materiasPerdidas = 0;
        int creditosPerdidos = 0;
        if (!esEnLinea) {
            System.out.print("Ingrese el numero de materias perdidas: ");
            materiasPerdidas = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ingrese el numero de creditos de materias perdidas: ");
            creditosPerdidos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
        }

        // Leer el número de creditos del semestre actual
        System.out.print("Ingrese el numero de creditos del semestre actual: ");
        int creditosSemestre = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear el objeto Estudiante con la información proporcionada
        Estudiante estudiante = new Estudiante(nombre, apellido, documento, direccion, telefono, carrera, semestre, esEnLinea, materiasPerdidas, creditosSemestre);

        // Calcular el costo de la matricula
        double costoMatricula = estudiante.calcularMatricula();

        // Imprimir la información del estudiante registrado
        System.out.println("Estudiante registrado:");
        System.out.println(estudiante);

        // Imprimir el recibo de inscripción
        imprimirRecibo(estudiante, costoMatricula);
    }

    private static void imprimirRecibo(Estudiante estudiante, double costoMatricula) {
        System.out.println("\n--- Recibo de Inscripcion ---");
        System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
        System.out.println("Documento: " + estudiante.getDocumento());
        System.out.println("Carrera: " + estudiante.getCarrera());
        System.out.println("Semestre: " + estudiante.getSemestre());
        System.out.println("En Linea: " + (estudiante.isEsEnLinea() ? "Si" : "No"));
        if (!estudiante.isEsEnLinea()) {
            System.out.println("Materias Perdidas: " + estudiante.getMateriasPerdidas());
            System.out.println("Creditos Perdidos: " + estudiante.getCreditosSemestre()); // Cambiado de getMateriasPerdidas a getCreditosSemestre
        }
        System.out.println("Creditos del Semestre: " + estudiante.getCreditosSemestre());
        System.out.println("Costo de Matricula: $" + costoMatricula);
        System.out.println("-----------------------------");
    }
}
