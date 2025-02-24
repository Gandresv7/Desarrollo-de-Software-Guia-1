package parqueadero;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Parqueadero {
    private List<Vehiculo> vehiculos;

    public Parqueadero() {
        this.vehiculos = new ArrayList<>();
    }

    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado con éxito.");
    }

    public double registrarSalida(String placa) {
        Iterator<Vehiculo> iterator = vehiculos.iterator();
        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPlaca().equals(placa)) {
                LocalDateTime horaSalida = LocalDateTime.now();
                long horas = Duration.between(vehiculo.getHoraEntrada(), horaSalida).toHours();
                if (horas == 0) horas = 1; // Considerar fracciones como una hora completa
                double costo = vehiculo.calcularTarifa(horas);
                iterator.remove();
                return costo;
            }
        }
        System.out.println("Vehículo no encontrado.");
        return 0;
    }

    public void consultarEstado() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos en el parqueadero:");
            for (Vehiculo v : vehiculos) {
                System.out.println("Placa: " + v.getPlaca() + ", Marca: " + v.getMarca() + ", Modelo: " + v.getModelo());
            }
        }
    }
}
