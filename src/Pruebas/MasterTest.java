package Pruebas;

import org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import parcial_2.AccesoProxy;
import parcial_2.Biciusuario;
import parcial_2.Master;
import parcial_2.Stakeholder;

import static org.junit.jupiter.api.Assertions.*;


class MasterTest {

    @Test
    void addBiciusuario() {

        Master acceso=Master.laConstructora();
        acceso.addBiciusuario("Alejandro","alejo@outlook.com","123qweQ%4","2000/12/22");
        Stakeholder miembro=acceso.buscarBiciusuario("alejo@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String date=((Biciusuario)miembro).getFechaNacimiento();
        assertEquals("Alejandroalejo@outlook.com123qweQ%42000/12/22",name+email+password+date);

    }

    @Test
    void addEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void addMoveloUser() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void addBicicleta() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void eliminarBiciusuario() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void eliminarEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void buscarBiciusuario() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void buscarEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void buscarBicicleta() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void addMiembroEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void eliminarMiembroEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void mostrarMiembros() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void mostrarBiciusuarios() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void mostrarEmpresas() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarNombreEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarEmailEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarPassowordEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarDireccionEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarNitEmpresa() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarNombreBiciusuario() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarEmailBiciusuario() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void actualizarPasswordBiciusuario() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void validacionDatos() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void mostrarBicicletas() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void addViaje() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void addRuta() {
        Master acceso=Master.laConstructora();
    }

    @Test
    void eliminarRuta() {
        Master acceso=Master.laConstructora();
    }
}