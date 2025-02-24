package parqueadero;
class Camion extends Vehiculo {
    private double capacidadCarga;
    private static final double TARIFA_HORA = 10000;

    public Camion(String placa, String marca, String modelo, double capacidadCarga) {
        super(placa, marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_HORA;
    }
}
