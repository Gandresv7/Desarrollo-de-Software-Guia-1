package parqueadero;

class Automovil extends Vehiculo {
    private String tipoCombustible;
    private static final double TARIFA_HORA = 5000;

    public Automovil(String placa, String marca, String modelo, String tipoCombustible) {
        super(placa, marca, modelo);
        this.tipoCombustible = tipoCombustible;
    }

	@Override
    public double calcularTarifa(long horas) {
        return horas * TARIFA_HORA;
    }
}
