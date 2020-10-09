/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

/**
 *
 * @author Randy
 */
public class RadioDecorator extends BicicletaDecorator {

    protected String radio;
    private String color;
    private String marca;
    private String serial;

    public RadioDecorator(Bicicleta bike,String radio) {
        super(bike);
        color=bike.getColor();
        marca=bike.getMarca();
        serial=bike.getSerial();
        this.radio=radio;
    }

    @Override
    public String showBicycle() {
        String respuesta=super.showBicycle();
        return respuesta+"\nRadio de ruedas: "+radio;
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

    public String getRadio(){
        return radio;
    }
}
