package Pruebas;

import org.junit.jupiter.api.Test;
import parcial_2.AccesoProxy;
import parcial_2.Biciusuario;
import parcial_2.Empresa;
import parcial_2.Stakeholder;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class AccesoProxyTest {

    @Test
    void validacionDatos() {
        AccesoProxy acceso=AccesoProxy.laConstructora();
        acceso.addBiciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        acceso.addEmpresa("Microsoft","123456789","micro10@gmail.com","Calle 6 # 56-12","ASDFa123#");
        acceso.addMoveloUser("movelo20","movelo@movelo.com","12345Q%3");

        BigInteger primo1=acceso.validacionDatos("movelo@movelo.com","12345Q%3");
        BigInteger primo2=acceso.validacionDatos("jose@gmail.com","AERqw12$#");

    }

    @Test
    void mostrarBicicletas() {
        AccesoProxy acceso=AccesoProxy.laConstructora();
        acceso.addBiciusuario("Juan felipe","felipe@gmail.com","AERqw12$#","2000/12/12");
        BigInteger primo3=acceso.validacionDatos("felipe@gmail.com","AERqw12$#");
        acceso.acceder(primo3,"mostrarBicicletas,felipe@gmail.com");
    }

    @Test
    void addViaje() {
        AccesoProxy acceso=AccesoProxy.laConstructora();
        BigInteger primo3=acceso.validacionDatos("felipe@gmail.com","AERqw12$#");
        acceso.acceder(primo3,"addViaje,felipe@gmail.com,123456743,12345678,1234567,30 minutos,14.5 kilometros por hora,6");

    }

    @Test
    void addRuta() {
        AccesoProxy acceso=AccesoProxy.laConstructora();
        BigInteger primo3=acceso.validacionDatos("felipe@gmail.com","AERqw12$#");
        acceso.acceder(primo3,"addRuta,felipe@gmail.com,123421,12345.678,1234.567");

    }

    @Test
    void eliminarRuta() {
        AccesoProxy acceso=AccesoProxy.laConstructora();

    }

    @Test
    void botonPanico() {
        AccesoProxy acceso=AccesoProxy.laConstructora();

    }

    @Test
    void addBiciusuario() {
        AccesoProxy acceso=AccesoProxy.laConstructora();

    }

    @Test
    void addEmpresa() {
    }

    @Test
    void addMoveloUser() {
    }

    @Test
    void addBicicleta() {
        AccesoProxy acceso=AccesoProxy.laConstructora();

    }

    @Test
    void eliminarBiciusuario() {
        AccesoProxy acceso=AccesoProxy.laConstructora();
        acceso.addBiciusuario("Andres","andres@gmail.com","AERqw12$#","2003/12/12");
    }

    @Test
    void eliminarEmpresa() {
    }

    @Test
    void eliminarBicicleta() {
        AccesoProxy acceso=AccesoProxy.laConstructora();

    }

    @Test
    void buscarBiciusuario() {
    }

    @Test
    void buscarEmpresa() {
    }

    @Test
    void buscarMiembroEmpresa() {
    }

    @Test
    void buscarBicicleta() {
    }

    @Test
    void addMiembroEmpresa() {
    }

    @Test
    void eliminarMiembroEmpresa() {
    }

    @Test
    void mostrarMiembros() {
    }

    @Test
    void mostrarMiembrosEmpresa() {
    }

    @Test
    void mostrarBiciusuarios() {
    }

    @Test
    void mostrarEmpresas() {
    }

    @Test
    void actualizarNombreEmpresa() {
    }

    @Test
    void actualizarEmailEmpresa() {
    }

    @Test
    void actualizarPassowordEmpresa() {
    }

    @Test
    void actualizarDireccionEmpresa() {
    }

    @Test
    void actualizarNitEmpresa() {
    }

    @Test
    void actualizarNombreBiciusuario() {
    }

    @Test
    void actualizarEmailBiciusuario() {
    }

    @Test
    void actualizarPasswordBiciusuario() {
    }
}