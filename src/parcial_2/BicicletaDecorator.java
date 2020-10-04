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
public abstract class BicicletaDecorator implements Bicycle {
    protected Bicicleta bicycle;

    public BicicletaDecorator(Bicicleta bike){
        bicycle=bike;
    }

    @Override
    public String showBicycle() {
        return this.bicycle.showBicycle();
    }
}
