/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import java.math.BigInteger;

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
        
        
        AccesoProxy access=AccesoProxy.laConstructora();

        access.addMoveloUser("movelo20","movelo@movelo.com","12345Q%3");
        access.addBiciusuario("Alexander", "alexjg@gmail.com", "87!R54321", "2002/08/01");
        access.addEmpresa("Apple","123456","apple@apple.com","carrera 7 # 34-12","ASDFqw1$");
        access.addBiciusuario("Randy", "rrandymiller@gmail.com", "123456A$", "2000/09/17");

        BigInteger primo=access.validacionDatos("rrandymiller@gmail.com","123456A$");
        access.acceder(primo,"addBicicleta,rrandymiller@gmail.com,1234,src,rojo");
        access.acceder(primo,"buscarBicicleta,rrandymiller@gmail.com,1234");
        access.acceder(primo,"botonPanico,rrandymiller@gmail.com,Ayuda me robaron la bicicleta");
        System.out.println(primo);

        BigInteger primo1=access.validacionDatos("apple@apple.com","ASDFqw1$");
        access.acceder(primo1,"addMiembroEmpresa,apple@apple.com,rrandymiller@gmail.com");
        access.acceder(primo1,"mostrarMiembrosEmpresa,apple@apple.com");

        BigInteger primo2=access.validacionDatos("alexjg@gmail.com", "87!R54321");
        access.acceder(primo2,"addViaje,alexjg@gmail.com,12345678,1234567,30 minutos,14.5 kilometros por hora,6");

        BigInteger primo3=access.validacionDatos("movelo@movelo.com","12345Q%3");
        access.acceder(primo3,"mostrarMiembros");
        access.acceder(primo3,"mostrarEmpresas");
        access.acceder(primo3,"mostrarBiciusuarios");
    }
    
}
