package parqueadero;

class Motocicleta extends Vehiculo {
    private int cilindraje;
    private static final double TARIFA_HORA = 2000;

    public Motocicleta(String placa, String marca, String modelo, int cilindraje) {
        super(placa, marca, modelo);
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_HORA;
    }
}
