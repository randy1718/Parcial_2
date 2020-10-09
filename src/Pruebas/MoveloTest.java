package Pruebas;

import org.junit.jupiter.api.Test;
import parcial_2.Mensaje;
import parcial_2.MoveloAdapter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoveloTest {

    @Test
    void crearMoveloUser(){
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        String username=movelo.getNombre();
        String email=movelo.getEmail();
        String password=movelo.getPassword();
        assertEquals("movelo2020movelo@movelo.orgjgRF12#)A",username+email+password);
    }

    @Test
    void addMensajesEmergencia(){
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        movelo.addMensaje("rrandymiller@gmail.com","Necesito ayuda rapido!");
        ArrayList<Mensaje> data=movelo.getMensajes("rrandymiller@gmail.com");
        String email=data.get(0).getEmailUser();
        String mensaje=data.get(0).getMensaje();

        assertEquals("rrandymiller@gmail.comNecesito ayuda rapido!",email+mensaje);
    }

    @Test
    void getMensajesEmergencia(){
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        movelo.addMensaje("rrandymiller@gmail.com","Necesito ayuda rapido!");
        ArrayList<Mensaje> data=movelo.getMensajes("rrandymiller@gmail.com");
        String email=data.get(0).getEmailUser();
        String mensaje=data.get(0).getMensaje();

        assertEquals("rrandymiller@gmail.comNecesito ayuda rapido!",email+mensaje);
    }

    @Test
    void setUsername() {
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        movelo.setNombre("movelo1221");
        String username=movelo.getNombre();
        String email=movelo.getEmail();
        String password=movelo.getPassword();
        assertEquals("movelo1221movelo@movelo.orgjgRF12#)A",username+email+password);
    }

    @Test
    void setCorreo() {
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        movelo.setEmail("movel4@movelo.org");
        String username=movelo.getNombre();
        String email=movelo.getEmail();
        String password=movelo.getPassword();
        assertEquals("movelo2020movel4@movelo.orgjgRF12#)A",username+email+password);
    }

    @Test
    void setClave() {
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        movelo.setPassword("YTGqwe123&%");
        String username=movelo.getNombre();
        String email=movelo.getEmail();
        String password=movelo.getPassword();
        assertEquals("movelo2020movelo@movelo.orgYTGqwe123&%",username+email+password);
    }

    @Test
    void mostrarDatos() {
        MoveloAdapter movelo= new MoveloAdapter("movelo2020","movelo@movelo.org","jgRF12#)A");
        String datos=movelo.mostrarDatos();
        assertEquals("Datos Movelo:\nUsername: movelo2020\nEmail: movelo@movelo.org\nPassword: jgRF12#)A\n\n",datos);
    }

}