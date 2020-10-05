package Pruebas;

import org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import parcial_2.AccesoProxy;
import static org.junit.jupiter.api.Assertions.*;


class MasterTest {

    @Test
    void addBiciusuario() {

        AccesoProxy acceso=AccesoProxy.laConstructora();
        acceso.addBiciusuario("","","","");
        assertEquals("hola","hola","Esta incorrecto");

    }

    @Test
    void addEmpresa() {
    }

    @Test
    void addMoveloUser() {
    }

    @Test
    void addBicicleta() {
    }

    @Test
    void eliminarBiciusuario() {
    }

    @Test
    void eliminarEmpresa() {
    }

    @Test
    void buscarBiciusuario() {
    }

    @Test
    void buscarEmpresa() {
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

    @Test
    void validacionDatos() {
    }

    @Test
    void mostrarBicicletas() {
    }

    @Test
    void addViaje() {
    }

    @Test
    void addRuta() {
    }

    @Test
    void eliminarRuta() {
    }
}