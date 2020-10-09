package Pruebas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import parcial_2.*;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void crearEmpresa(){
        String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
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
            assertEquals("Appleapple@apple.comASD123$#Carrera 8 # 12-12123456678",nombre+email+password+direccion+nit);
        }else{
            fail("La clave o el correo no cumplen con los requerimientos!");
        }
    }

    @Test
    void addMiembros(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","124526678");
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
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","124536678");
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
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","124566788");
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
    void addRuta(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.addRuta("12345","1234.56789","12345.23456");
        Ruta r=null;
        String code="";
        String cI="";
        String cF="";
        try{
            r=company.getRuta("12345");
            code=r.getCodigo();
            cI=r.getCoordIniciales();
            cF=r.getCoordFinales();
        }catch (Exception e){
            fail("La ruta no se adicionó correctamente!");
        }

        if(code.isEmpty() || cI.isEmpty() || cF.isEmpty()){
            fail("Alguno de los valores de la ruta esta vacio. No se debe crear la ruta asi.");
        }else{
            assertEquals("123451234.5678912345.23456", code + cI + cF);
        }
    }

    @Test
    void getRuta(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.addRuta("12345","12354.56789","12345.23456");
        Ruta r=company.getRuta("12345");
        String code=r.getCodigo();
        String cI=r.getCoordIniciales();
        String cF=r.getCoordFinales();
        assertEquals("1234512354.5678912345.23456",code+cI+cF);
    }

    @Test
    void eliminarRuta(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.addRuta("12345","12354.56789","12345.23456");
        Ruta r=company.getRuta("12345");
        String code=r.getCodigo();
        String cI=r.getCoordIniciales();
        String cF=r.getCoordFinales();
        assertEquals("1234512354.5678912345.23456",code+cI+cF);
        company.eliminarRuta("12345");
        Ruta rou=company.getRuta("12345");
        if(rou!=null){
            fail("La ruta no se borró correctamente!");
        }
    }

    @Test
    void addViaje(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.addViaje("9632412","123.13456","3456.4567","30 minutos","100 km/h",10);
        Viaje v=company.getViaje("9632412");
        String codigo=v.getCodigo();
        String ci=v.getCoordenadasIniciales();
        String cf=v.getCoordenadasFinales();
        String velocidad=v.getVelocidad();
        int distancia=v.getDistancia();
        int arboles=v.getArbolesObtenidos();
        assertEquals("9632412123.134563456.456710100 km/h10",codigo+ci+cf+distancia+velocidad+arboles);
    }

    @Test
    void mostrarMiembros(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Empresa compy=new Empresa("Microsoft","microsoft@microsoft.com","ASDfJ3$#","Carrera 132 # 12-12","124566578");
        company.addMiembros(compy);
        company.addMiembros(user);
        String members=company.mostrarMiembros();
        assertEquals("Estos son los miembros:\nDatos Empresa:\nNombre: Microsoft\nNit: 124566578\nEmail: microsoft@microsoft.com\nDireccion: Carrera 132 # 12-12\n\n" +
                "\nDatos Biciusuario: \nNombre: Juan jose\nEmail: jose@gmail.com\nFecha de Nacimiento: 2000/12/12\n\n",members);
    }

    @Test
    void mostrarDatos() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String info=company.mostrarDatos();
        assertEquals("Datos Empresa:\nNombre: Apple\nNit: 123456678\nEmail: apple@apple.com\nDireccion: Carrera 8 # 12-12\n\n",info);
    }

    @Test
    void setNombre() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.setNombre("APPLE INC");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("APPLE INCapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setNit() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.setNit("123456712");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456712Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setEmail() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.setEmail("appleinc@apple.com");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleappleinc@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setPassword() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.setPassword("1a3sQ%D1s");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.com1a3sQ%D1s123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void setDireccion(){
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        company.setDireccion("Calle 102 #13-21");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Calle 102 #13-21",name+email+password+nit+direccion);
    }

    @Test
    void getNombre() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);

    }

    @Test
    void getEmail() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getNit() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getPassword() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
    }

    @Test
    void getDireccion() {
        Empresa company=new Empresa("Apple","apple@apple.com","ASD123$#","Carrera 8 # 12-12","123456678");
        String name=company.getNombre();
        String email= company.getEmail();
        String password=company.getPassword();
        String nit= company.getNit();
        String direccion=company.getDireccion();
        assertEquals("Appleapple@apple.comASD123$#123456678Carrera 8 # 12-12",name+email+password+nit+direccion);
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