package parcial_2;

public class ModeloDecorator extends BicicletaDecorator {

    private String modelo;
    private String color;
    private String marca;
    private String serial;

    public ModeloDecorator(Bicicleta bike, String modelo) {
        super(bike);
        color=bike.getColor();
        marca=bike.getMarca();
        serial=bike.getSerial();
        this.modelo=modelo;

    }

    @Override
    public String showBicycle() {
        String respuesta=super.showBicycle();
        return respuesta+" \nModelo: "+modelo;
    }

    @Override
    public String getSerial() {
        return serial;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    public String getModelo(){
        return modelo;
    }


}
