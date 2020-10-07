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

    public RadioDecorator(Bicicleta bike,String radio) {
        super(bike);
        this.radio=radio;
    }

    @Override
    public String showBicycle() {
        String respuesta=super.showBicycle();
        return respuesta+"\nRadio de ruedas: "+radio;
    }
}
