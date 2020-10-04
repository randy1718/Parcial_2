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

        acceso.addMoveloUser("movelo20","movelo@movelo.com","12345Q%3");
        acceso.addBiciusuario("Randy", "rrandymiller@gmail.com", "123456A$", "17-09-2000");
        acceso.addBiciusuario("Alexander", "alexjg@gmail.com", "87!R54321", "1-08-2002");
        Bicycle bike=new ModeloDecorator(new Bicicleta("123 ","src ","rojo "),"2020");

        String r=acceso.validacionDatos("rrandymiller@gmail.com", "123456A$");
        acceso.addBicicleta("rrandymiller@gmail.com",bike);


        String s=acceso.validacionDatos("alexjg@gmail.com", "87!R54321");
        acceso.addBicicleta("alexjg@gmail.com",bike);

        String m=acceso.validacionDatos("movelo@movelo.com","12345Q%3");

        acceso.eliminarBiciusuario("rrandymiller@gmail.com");

        String my=acceso.mostrarMiembros();

        System.out.print(""+r+s+m+bike.showBicycle());
        
    }
    
}
