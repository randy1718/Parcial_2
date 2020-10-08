package Pruebas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import parcial_2.Biciusuario;
import parcial_2.Empresa;
import parcial_2.Stakeholder;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void crearEmpresa(){
        String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String nombre=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();

        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(password);
        int mayusculas = verificarMayusculas(password);
        int arroba=verificarCorreo(email);
        int numeros=verificarNumeros(password);
        if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1){
            assertEquals("Appleapple@apple.comASD123$#Carrera 8 # 12-12123456",nombre+email+password+direccion+nit);
        }else{
            fail("La clave o el correo no cumplen con los requerimientos!");
        }
    }

    @Test
    void addMiembros(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","12456");
        company.addMiembros(compy);
        company.addMiembros(user);
        Stakeholder member=company.darMiembro("microsoft@microsoft.com");
        String nombre=member.getNombre();
        String email= member.getEmail();
        String password=member.getPassword();
        assertEquals("Microsoftmicrosoft@microsoft.comASDfJ3$#",nombre+email+password);

    }

    @Test
    void darMiembro(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","12456");
        company.addMiembros(compy);
        company.addMiembros(user);
        Stakeholder member=company.darMiembro("jose@gmail.com");
        String nombre=member.getNombre();
        String email= member.getEmail();
        String password=member.getPassword();
        assertEquals("Juan josejose@gmail.comAERqw12$#",nombre+email+password);
    }

    @Test
    void eliminarMiembro(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","12456");
        company.addMiembros(compy);
        company.addMiembros(user);
        Stakeholder member=company.darMiembro("jose@gmail.com");
        String nombre=member.getNombre();
        String email= member.getEmail();
        String password=member.getPassword();
        assertEquals("Juan josejose@gmail.comAERqw12$#",nombre+email+password);
        company.eliminarMiembro("jose@gmail.com");
        Stakeholder m=company.darMiembro("jose@gmail.com");
        if (m!=null) {
            fail("No se borro correctamente el miembro");
        }

    }

    @Test
    void mostrarMiembros(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","12456");
        company.addMiembros(compy);
        company.addMiembros(user);
        String members=company.mostrarMiembros();
        assertEquals("Estos son los miembros:\nDatos Empresa:\nNombre: Microsoft\nNit: 12456\nEmail: microsoft@microsoft.com\nDireccion: Carrera 132 # 12-12\n\n" +
                "\nDatos Biciusuario: \nNombre: Juan jose\nEmail: jose@gmail.com\nFecha de Nacimiento: 2000/12/12\n\n",members);
    }

    @Test
    void mostrarDatos() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String info=company.mostrarDatos();
        assertEquals("Datos Empresa:\nNombre: Apple\nNit: 123456\nEmail: apple@apple.com\nDireccion: Carrera 8 # 12-12\n\n",info);
    }

    @Test
    void setNombre() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        company.setNombre("APPLE INC");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("APPLE INCapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setNit() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        company.setNit("1234567");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#1234567Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setEmail() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        company.setEmail("appleinc@apple.com");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleappleinc@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setPassword() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        company.setPassword("1a3sQ%D1s");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.com1a3sQ%D1s123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setDireccion(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        company.setDireccion("Calle 102 #13-21");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Calle 102 #13-21",name+email+password+nit+direccion);
    }

    @Test
    void getNombre() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);

    }

    @Test
    void getEmail() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getNit() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getPassword() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getDireccion() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    public int verificarMayusculas(String clave) {
        int contador = 0;
        char letra;
        for (int i = 0; i < clave.length(); i++) {
            letra = clave.charAt(i);
            if (Character.isUpperCase(letra)) {
                contador = contador + 1;
            }
        }

        return contador;
    }

    public int verificarCorreo(String correo) {
        int contador = 0;
        char letra;
        for (int i = 0; i < correo.length(); i++) {
            letra = correo.charAt(i);
            String let=String.valueOf(letra);
            if (let.equals("@")) {
                contador = contador + 1;
            }
        }
        return contador;
    }

    private int verificarNumeros(String clave) {
        int contador = 0;
        char letra;
        for (int i = 0; i < clave.length(); i++) {
            letra = clave.charAt(i);
            String let=String.valueOf(letra);
            if (let.matches("[0-9]")) {
                contador = contador + 1;
            }
        }

        return contador;
    }
}