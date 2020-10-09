package Pruebas;

import org.junit.jupiter.api.Test;
import parcial_2.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class BiciusuarioTest {

    @Test
    public void crearBiciusuario(){
        String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        String fechaNacimiento= user.getFechaNacimiento();

        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(password);
        int mayusculas = verificarMayusculas(password);
        int arroba=verificarCorreo(email);
        int numeros=verificarNumeros(password);
        if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1){
            assertEquals("Juan josejose@gmail.comAERqw12$#2000/12/12",nombre+email+password+fechaNacimiento);
        }else{
            fail("La clave o el correo no cumplen con los requerimientos!");
        }

    }

    @Test
    void addBicicleta() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Bicycle bike= new Bicicleta("2134","SRC","ROJO");
        user.addBicicleta(bike);

        Bicycle b=user.darBicicleta("2134");
        b.showBicycle();
        assertEquals("\nBicicleta \nSerial: 2134\nMarca: SRC\nColor: ROJO",b.showBicycle());
    }
    @Test
    void darBicicleta(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Bicycle bike= new Bicicleta("2134","SRC","ROJO");
        Bicycle bike2= new Bicicleta("9876","RECS","AZUL");
        user.addBicicleta(bike);
        user.addBicicleta(bike2);

        Bicycle b=user.darBicicleta("9876");
        b.showBicycle();
        assertEquals("\nBicicleta \nSerial: 9876\nMarca: RECS\nColor: AZUL",b.showBicycle());
    }

    @Test
    void eliminarBicicleta(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Bicycle bike= new Bicicleta("2134","SRC","ROJO");
        Bicycle bike2= new Bicicleta("9876","RECS","AZUL");
        user.addBicicleta(bike);
        user.addBicicleta(bike2);

        user.eliminarBicicleta("2134");
        String res="";
        Bicycle b=null;
        try{
            b=user.darBicicleta("2134");
            b.showBicycle();
            if(b!=null){
                fail("No se borro correctamente la bicicleta");
            }
        }catch (Exception e){
            res=e.toString();
            assertEquals("java.lang.NullPointerException",res);
        }
    }

    @Test
    void getBicicletas(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        Bicycle bike= new Bicicleta("2134","SRC","ROJO");
        Bicycle bike2= new Bicicleta("9876","RECS","AZUL");
        user.addBicicleta(bike);
        user.addBicicleta(bike2);

        String bicicletas=user.getBicicletas();
        assertEquals("\nBicicleta \nSerial: 2134\nMarca: SRC\nColor: ROJO\nBicicleta \nSerial: 9876\nMarca: RECS\nColor: AZUL",bicicletas);
    }

    @Test
    void addRuta(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.addRuta("12345","1234.56789","12345.23456");
        Ruta r=null;
        String code="";
        String cI="";
        String cF="";
        try{
            r=user.getRuta("12345");
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
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.addRuta("12345","12354.56789","12345.23456");
        Ruta r=user.getRuta("12345");
        String code=r.getCodigo();
        String cI=r.getCoordIniciales();
        String cF=r.getCoordFinales();
        assertEquals("1234512354.5678912345.23456",code+cI+cF);
    }

    @Test
    void eliminarRuta(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.addRuta("12345","12354.56789","12345.23456");
        Ruta r=user.getRuta("12345");
        String code=r.getCodigo();
        String cI=r.getCoordIniciales();
        String cF=r.getCoordFinales();
        assertEquals("1234512354.5678912345.23456",code+cI+cF);
        user.eliminarRuta("12345");
        Ruta rou=user.getRuta("12345");
        if(rou!=null){
            fail("La ruta no se borró correctamente!");
        }
    }

    @Test
    void addViaje(){
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.addViaje("9632412","123.13456","3456.4567","30 minutos","100 km/h",10);
        Viaje v=user.getViaje("9632412");
        String codigo=v.getCodigo();
        String ci=v.getCoordenadasIniciales();
        String cf=v.getCoordenadasFinales();
        String velocidad=v.getVelocidad();
        int distancia=v.getDistancia();
        int arboles=v.getArbolesObtenidos();
        assertEquals("9632412123.134563456.456710100 km/h10",codigo+ci+cf+distancia+velocidad+arboles);
    }

    @Test
    void mostrarDatos() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        String datos=user.mostrarDatos();
        assertEquals("Datos Biciusuario: \nNombre: Juan jose\nEmail: jose@gmail.com\nFecha de Nacimiento: 2000/12/12\n\n",datos);
    }

    @Test
    void setNombre() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.setNombre("JUAN JOSE");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        String fechaNacimiento= user.getFechaNacimiento();
        assertEquals("JUAN JOSEjose@gmail.comAERqw12$#2000/12/12",nombre+email+password+fechaNacimiento);

    }

    @Test
    void setEmail() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.setEmail("jjose@gmail.com");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        String fechaNacimiento= user.getFechaNacimiento();
        assertEquals("Juan josejjose@gmail.comAERqw12$#2000/12/12",nombre+email+password+fechaNacimiento);
    }

    @Test
    void setPassword() {
        Biciusuario user=new Biciusuario("Juan jose","jose@gmail.com","AERqw12$#","2000/12/12");
        user.setPassword("1234AS!%");
        String nombre=user.getNombre();
        String email= user.getEmail();
        String password=user.getPassword();
        String fechaNacimiento= user.getFechaNacimiento();
        assertEquals("Juan josejose@gmail.com1234AS!%2000/12/12",nombre+email+password+fechaNacimiento);
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