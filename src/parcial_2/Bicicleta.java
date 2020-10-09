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
public class Bicicleta implements Bicycle {
    private String serial,marca,color;
    public Bicicleta(String serial, String marca, String color){
        this.serial=serial;
        this.marca=marca;
        this.color=color;
    }

    @Override
    public String showBicycle() {
        return "\nBicicleta "+"\nSerial: "+serial+"\nMarca: "+marca+"\nColor: "+color;
    }

    public String getSerial(){
        return serial;
    }

    public String getMarca(){
        return marca;
    }

    public String getColor(){
        return color;
    }
}
