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
public class Parcial_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        AccesoProxy acceso=AccesoProxy.laConstructora();
        acceso.addBiciusuario("Randy", "rrandymiller@gmail.com", "12345678", "17-09-2000");
        boolean res=acceso.validacionDatos("rrandymiller@gmail.com", "12345678");
        Bicicleta bike=new Bicicleta("123","src","rojo");
        acceso.addBicicleta("rrandymiller@gmail.com",bike);
        System.out.print(""+res);
        
    }
    
}
