package Pruebas;

import org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import parcial_2.*;

import static org.junit.jupiter.api.Assertions.*;


class MasterTest {

    @Test
    void addBiciusuario() {

        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Alejandro","alejo@outlook.com","123qweQ%4","2000/12/22");
        acceso.addBiciusuario(user);
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
        Stakeholder empresa=new Empresa("Amazon","amazon@gmail.com","1234aSAD%$","carrera 8 #109-08","123456");
        acceso.addEmpresa(empresa);
        Stakeholder miembro=acceso.buscarEmpresa("amazon@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String nit=((Empresa)miembro).getNit();
        assertEquals("Amazon123456amazon@gmail.com1234aSAD%$",name+nit+email+password);
    }

    @Test
    void addMoveloUser() {
        Master acceso=Master.laConstructora();
        Stakeholder movelo=new MoveloAdapter("movelo20","movelo@movelo.com","12345Q%3");
        acceso.addMoveloUser(movelo);
        Stakeholder miembro=acceso.buscarUserMovelo("movelo@movelo.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        assertEquals("movelo20movelo@movelo.com",name+email);
    }

    @Test
    void addBicicleta() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Camila","camila@outlook.com","123qweQ%4","2000/12/22");
        acceso.addBiciusuario(user);
        Stakeholder miembro=acceso.buscarBiciusuario("camila@outlook.com");
        Bicycle bike=new Bicicleta("1234","src","rojo");
        acceso.addBicicleta("camila@outlook.com",bike);
        acceso.buscarBicicleta("camila@outlook.com","1234");
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