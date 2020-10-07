package parcial_2;

public class ModeloDecorator extends BicicletaDecorator {

    private String modelo;

    public ModeloDecorator(Bicicleta bike, String modelo) {
        super(bike);
        this.modelo=modelo;
    }

    @Override
    public String showBicycle() {
        String respuesta=super.showBicycle();
        return respuesta+" \nModelo: "+modelo;
    }

}
