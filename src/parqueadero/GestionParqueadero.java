package parqueadero;

import java.util.Scanner;

public class GestionParqueadero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        while (true) {
            System.out.println("1. Ingresar vehículo\n2. Registrar salida\n3. Consultar estado\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Tipo de vehículo (1. Automóvil, 2. Motocicleta, 3. Camión):");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Placa:");
                    String placa = scanner.nextLine();
                    System.out.println("Marca:");
                    String marca = scanner.nextLine();
                    System.out.println("Modelo:");
                    String modelo = scanner.nextLine();
                    
                    if (tipo == 1) {
                        System.out.println("Tipo de combustible:");
                        String combustible = scanner.nextLine();
                        parqueadero.registrarEntrada(new Automovil(placa, marca, modelo, combustible));
                    } else if (tipo == 2) {
                        System.out.println("Cilindraje:");
                        int cilindraje = scanner.nextInt();
                        parqueadero.registrarEntrada(new Motocicleta(placa, marca, modelo, cilindraje));
                    } else if (tipo == 3) {
                        System.out.println("Capacidad de carga en toneladas:");
                        double carga = scanner.nextDouble();
                        parqueadero.registrarEntrada(new Camion(placa, marca, modelo, carga));
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la placa del vehículo a retirar:");
                    String placaSalida = scanner.nextLine();
                    double costo = parqueadero.registrarSalida(placaSalida);
                    if (costo > 0) {
                        System.out.println("Costo total: $" + costo);
                    }
                    break;
                case 3:
                    parqueadero.consultarEstado();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
