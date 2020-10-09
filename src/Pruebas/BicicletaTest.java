package Pruebas;

import org.junit.jupiter.api.Test;
import parcial_2.Bicicleta;
import parcial_2.BicicletaDecorator;
import parcial_2.Bicycle;
import parcial_2.ModeloDecorator;

import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {

    @Test
    void CrearBicicleta(){
        Bicycle bike= new ModeloDecorator(new Bicicleta("FAG-2304-K","SPECIALIZATED","ROJO"),"2020");
        String serial=bike.getSerial();
        String marca=bike.getMarca();
        String color=bike.getColor();
        String modelo=((ModeloDecorator)bike).getModelo();
        assertEquals("FAG-2304-KSPECIALIZATEDROJO2020",serial+marca+color+modelo);
        bike.showBicycle();
    }

    @Test
    void showBicycle() {
        Bicycle bike= new ModeloDecorator(new Bicicleta("FAG-2304-K","SPECIALIZATED","ROJO"),"2020");
        String r=bike.showBicycle();
        assertEquals("\nBicicleta \nSerial: FAG-2304-K\nMarca: SPECIALIZATED\nColor: ROJO \nModelo: 2020",r);
    }
}