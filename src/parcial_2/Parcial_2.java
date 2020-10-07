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
        acceso.addBiciusuario("Randy", "rrandymiller@gmail.com", "123456A$", "2000/09/17");
        acceso.addBiciusuario("Alexander", "alexjg@gmail.com", "87!R54321", "2002/08/01");
        acceso.addEmpresa("Apple","123456","apple@apple.com","carrera 7 # 34-12","ASDFqw1$");
        Bicycle bike=new ModeloDecorator(new Bicicleta("123 ","src ","rojo "),"2020");

        acceso.validacionDatos("apple@apple.com","ASDFqw1$");
        Stakeholder user=acceso.buscarBiciusuario("rrandymiller@gmail.com");
        acceso.addMiembroEmpresa("apple@apple.com",user);
        acceso.mostrarMiembrosEmpresa("apple@apple.com");

        String r=acceso.validacionDatos("rrandymiller@gmail.com", "123456A$");
        acceso.addBicicleta("rrandymiller@gmail.com",bike);
        acceso.mostrarBicicletas("rrandymiller@gmail.com");
        acceso.botonPanico("rrandymiller@gmail.com","hola");

        String s=acceso.validacionDatos("alexjg@gmail.com", "87!R54321");
        acceso.addBicicleta("alexjg@gmail.com",bike);
        acceso.addViaje("alexjg@gmail.com","12345678","1234567","30 minutos","14,5kilometros por hora",6);

        String m=acceso.validacionDatos("movelo@movelo.com","12345Q%3");

        //acceso.eliminarBiciusuario("rrandymiller@gmail.com");

        String my=acceso.mostrarMiembros();
        acceso.mostrarEmpresas();
        acceso.mostrarBiciusuarios();



        System.out.print(""+r+s+m+bike.showBicycle());
        
    }
    
}
