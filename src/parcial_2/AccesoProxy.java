/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Randy
 */
public class AccesoProxy{
    private static AccesoProxy instancia = null;
    private final ArrayList<Stakeholder> stakeholders=new ArrayList<>();
    protected String validacion="false";
    protected String email="";
    private BigInteger numPrimo;
    
    public static AccesoProxy laConstructora(){
        if(instancia==null){
            instancia=new AccesoProxy();
	}
       return instancia;
    }

    public BigInteger validacionDatos(String email, String password){
        BigInteger primo=null;
        String respuesta="false";
        try{
            for(int i=0;i<stakeholders.size();i++){
                Stakeholder miembro=stakeholders.get(i);
                if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password) && miembro instanceof MoveloAdapter){
                    respuesta="Movelo";
                    break;
                }else if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password) && miembro instanceof Biciusuario){
                    respuesta="Biciusuario";
                    break;
                }else if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password) && miembro instanceof Empresa){
                    respuesta="Empresa";
                    break;
                }
            }
        }catch (Exception e){

        }

        if(respuesta.equals("Biciusuario") || respuesta.equals("Movelo") || respuesta.equals("Empresa")) {
            int biglength=1050;
            Random rnd=new Random();
            primo=BigInteger.probablePrime(biglength,rnd);
            numPrimo=primo;
            validacion = respuesta;
            this.email=email;
            System.out.println("Real: "+primo);
        }
        System.out.println(respuesta);
        return primo;
    }

    /**private BigInteger cifrar(BigInteger primo){
        String number=primo.toString();
        int[] numeros=new int[number.length()];
        int[] cifrados=new int[number.length()*4];
        for(int i=0;i<number.length();i++){

            numeros[i]=number.charAt(i)-'0';
            String sa=Long.toBinaryString(numeros[i]);
            cifrados[i]=Integer.parseInt(sa);

        }
        StringBuilder s=new StringBuilder();
        for(int n:cifrados){
            s.append(n);
        }
        BigInteger num=new BigInteger(s.toString());
        return num;
    }
/**
    private BigInteger descifrar(BigInteger primo){

        String number=primo.toString();
        int[] numeros=new int[number.length()];
        for(int i=0;i<number.length();i++){
            numeros[i]=number.charAt(i)-'0';

        }
        StringBuilder s=new StringBuilder();
        for(int n:numeros){
            s.append(n);

        }
        BigInteger num=new BigInteger("");
        return num;
    }*/


    public void acceder(BigInteger primo, String metodo){
        if(numPrimo==primo && validacion.equals("Biciusuario")) {
            Master master=Master.laConstructora();
            String[] datos=metodo.split(",");
            switch (datos[0]) {
                case "addBicicleta":
                    Bicycle bike=new Bicicleta(datos[2],datos[3],datos[4]);
                    master.addBicicleta(datos[1], bike);
                    break;
                case "mostrarBicicletas":
                    String respuesta = master.mostrarBicicletas(datos[1]);
                    break;
                case "addViaje":
                    master.addViaje(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],Integer.parseInt(datos[7]));
                    break;

                case "buscarViaje":
                    Viaje v=master.buscarViaje(datos[1],datos[2]);
                    break;

                case "buscarRuta":
                    Ruta rou=master.buscarRuta(datos[1],datos[2]);
                    break;

                case "addRuta":
                    master.addRuta(datos[1],datos[2],datos[3],datos[4]);
                    break;

                case "eliminarRuta":
                    master.eliminarRuta(datos[1],datos[2]);
                    break;

                case "botonPanico":
                    master.botonPanico(datos[1],datos[2]);
                    break;

                case "eliminarBiciusuario":
                    master.eliminarBiciusuario(datos[1]);
                    break;

                case "eliminarBicicleta":
                    master.eliminarBicicleta(datos[1],datos[2]);
                    break;

                case "buscarBicicleta":
                    Bicycle bici=master.buscarBicicleta(datos[1],datos[2]);
                    break;

                case "actualizarNombreBiciusuario":
                    master.actualizarNombreBiciusuario(datos[1],datos[2]);
                    break;

                case "actualizarEmailBiciusuario":
                    master.actualizarEmailBiciusuario(datos[1],datos[2]);
                    break;

                case "actualizarPasswordBiciusuario":
                    master.actualizarPasswordBiciusuario(datos[1],datos[2]);
                    break;

            }
        }else if(numPrimo==primo && validacion.equals("Empresa")){
            Master master=Master.laConstructora();
            String[] datos=metodo.split(",");
            switch (datos[0]) {

                case "addViaje":
                    master.addViaje(datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],Integer.parseInt(datos[7]));
                    break;

                case "buscarViaje":
                    Viaje v=master.buscarViaje(datos[1],datos[2]);
                    break;

                case "buscarRuta":
                    Ruta route=master.buscarRuta(datos[1],datos[2]);
                    break;

                case "addRuta":
                    master.addRuta(datos[1],datos[2],datos[3],datos[4]);
                    break;

                case "eliminarRuta":
                    master.eliminarRuta(datos[1],datos[2]);
                    break;

                case "botonPanico":
                    master.botonPanico(datos[1],datos[2]);
                    break;

                case "eliminarEmpresa":
                    master.eliminarEmpresa(datos[1]);
                    break;

                case "buscarBiciusuario":
                    Stakeholder m=master.buscarBiciusuario(datos[1]);
                    break;

                case "buscarMiembroEmpresa":
                    Stakeholder member=master.buscarMiembroEmpresa(datos[1], datos[2]);
                    break;

                case "addMiembroEmpresa":
                    Stakeholder miembro=master.buscarBiciusuario(datos[2]);
                    master.addMiembroEmpresa(datos[1], miembro);
                    break;

                case "eliminarMiembroEmpresa":
                    master.eliminarMiembroEmpresa(datos[1], datos[2]);
                    break;

                case "mostrarMiembrosEmpresa":
                    String r=master.mostrarMiembrosEmpresa(datos[1]);
                    break;

                case "actualizarNombreEmpresa":
                    master.actualizarNombreEmpresa(datos[1], datos[2]);
                    break;

                case "actualizarEmailEmpresa":
                    master.actualizarEmailEmpresa(datos[1], datos[2]);
                    break;

                case "actualizarPassowordEmpresa":
                    master.actualizarPasswordEmpresa(datos[1], datos[2]);
                    break;

                case "actualizarDireccionEmpresa":
                    master.actualizarDireccionEmpresa(datos[1], datos[2]);
                    break;

                case "actualizarNitEmpresa":
                    master.actualizarNitEmpresa(datos[1], datos[2]);
                    break;
            }

        } else if(numPrimo==primo && validacion.equals("Movelo")){
            Master master=Master.laConstructora();
            String[] datos=metodo.split(",");
            switch (datos[0]) {

                case "eliminarBiciusuario":
                    master.eliminarBiciusuario(datos[1]);
                    break;

                case "eliminarEmpresa":
                    master.eliminarEmpresa(datos[1]);
                    break;

                case "buscarBiciusuario":
                    Stakeholder m=master.buscarBiciusuario(datos[1]);
                    break;

                case "buscarEmpresa":
                    Stakeholder e=master.buscarEmpresa(datos[1]);
                    break;

                case "buscarUserMovelo":
                    Stakeholder u=master.buscarUserMovelo(datos[1]);
                    break;

                case "mostrarMiembros":
                    String respuesta=master.mostrarMiembros();
                    break;

                case "mostrarBiciusuarios":
                    String biusers=master.mostrarBiciusuarios();
                    break;

                case "mostrarEmpresas":
                    String companies=master.mostrarEmpresas();
                    break;

                case "getMessages":
                    ArrayList<Mensaje> messages=master.getMessages(datos[1], datos[2]);
                    break;
            }
        }else{
            System.out.println("No tiene acceso!");
        }
    }

    public void addBiciusuario(String nombre, String email, String password, String fechaNacimiento) {
        int contador = 0;
        for(int i=0;i<stakeholders.size();i++){
            if(stakeholders.get(i).getEmail().equals(email) && stakeholders.get(i).getNombre().equals(nombre)){
                System.out.println("El biciusuario ya esta registrado");
            }else if(stakeholders.get(i).getNombre().equals(nombre) || stakeholders.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre de usuario ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== stakeholders.size()) {
            Master master=Master.laConstructora();
            Biciusuario user=new Biciusuario(nombre,email,password,fechaNacimiento);
            stakeholders.add(user);
            master.addBiciusuario(user);
        }
    }

    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
        int contador = 0;
        for(int i=0;i<stakeholders.size();i++){
            if(stakeholders.get(i) instanceof Empresa) {
                Empresa ceo= (Empresa) stakeholders.get(i);
                if (ceo.getEmail().equals(email) && ceo.getNombre().equals(nombre)) {
                    System.out.println("La empresa ya esta registrado");
                } else if (ceo.getNombre().equals(nombre) || ceo.getEmail().equals(email) || ceo.getNit().equals(nit)) {
                    System.out.println("El email o el nombre de la empresa ya estan registrados");
                } else {
                    contador++;
                }
            }else{
                contador++;
            }
        }
        if (contador== stakeholders.size()) {
            Master master=Master.laConstructora();
            Stakeholder company=new Empresa(nombre,email,password,direccion,nit);
            stakeholders.add(company);
            master.addEmpresa(company);
        }
    }

    public void addMoveloUser(String username, String email, String password) {
        int contador = 0;
        for(int i=0;i<stakeholders.size();i++){
            if(stakeholders.get(i).getEmail().equals(email) && stakeholders.get(i).getNombre().equals(username)){
                System.out.println("El usario de Movelo ya esta registrado");
            }else if(stakeholders.get(i).getNombre().equals(username) || stakeholders.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre del usuario de Movelo ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== stakeholders.size()) {
            Master master=Master.laConstructora();
            MoveloAdapter movelo=new MoveloAdapter(username,email,password);
            stakeholders.add(movelo);
            master.addMoveloUser(movelo);
        }
    }


    /**
     @Override
     public String mostrarBicicletas(String emailBiciusuario) {
     String respuesta="";
     if(validacion.equals("true") && email.equals(emailBiciusuario)) {
     respuesta = this.master.mostrarBicicletas(emailBiciusuario);
     }else{
     System.out.println("No tiene acceso!");
     }
     return respuesta;
     }

     @Override
     public void addViaje(String emailUser,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros) {
     if(validacion.equals("true") && email.equals(emailUser)) {
     this.master.addViaje(emailUser,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
     }else if(validacion.equals("Movelo")) {
     this.master.addViaje(emailUser,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
     }else{
     System.out.println("No tienes acceso!");
     }

     }

     @Override
     public void addRuta(String emailUser, String codigoRuta,String coordenadasIniciales,String coordenadasFinales) {
     if(validacion.equals("true") && email.equals(emailUser)) {
     this.master.addRuta(emailUser, codigoRuta, coordenadasIniciales, coordenadasFinales);
     }else if(validacion.equals("Movelo")) {
     this.master.addRuta(emailUser, codigoRuta, coordenadasIniciales, coordenadasFinales);
     }else{
     System.out.println("No tienes acceso!");
     }
     }

     @Override
     public void eliminarRuta(String emailUser,String codigoRuta) {
     if(validacion.equals("true") && email.equals(emailUser)) {
     this.master.eliminarRuta(emailUser,codigoRuta);
     }else if(validacion.equals("Movelo")) {
     this.master.eliminarRuta(emailUser,codigoRuta);
     }else{
     System.out.println("No tienes acceso!");
     }
     }

     @Override
     public String botonPanico(String email, String mensaje) {
     String respuesta="";
     if(validacion.equals("true") && this.email.equals(email)) {
     respuesta= this.master.botonPanico(email, mensaje);
     }else{
     System.out.println("No tienes acceso!");
     }
     return respuesta;
     }

    public void addBiciusuario(String nombre, String email, String password, String fechaNacimiento) {
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(nombre)){
                System.out.println("El biciusuario ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(nombre) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre de usuario ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            Biciusuario user=new Biciusuario(nombre,email,password,fechaNacimiento);
            miembros.add(user);
        }
    }

    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(nombre)){
                System.out.println("La empresa ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(nombre) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre de la empresa ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            Empresa company=new Empresa(nombre,email,password,direccion,nit);
            miembros.add(company);
        }
    }

    public void addMoveloUser(String username, String email, String password) {
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(username)){
                System.out.println("El usario de Movelo ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(username) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre del usuario de Movelo ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            MoveloAdapter movelo=new MoveloAdapter(username,email,password);
            miembros.add(movelo);
        }
    }

    public void addBicicleta(String emailBiciusuario,Bicycle bike) {
        if(validacion.equals("true") && email.equals(emailBiciusuario)){
            this.master.addBicicleta(emailBiciusuario,bike);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void eliminarBiciusuario(String email) {
        if(validacion.equals("true") && this.email.equals(email)){
            this.master.eliminarBiciusuario(email);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarBiciusuario(email);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void eliminarEmpresa(String email) {
        if(validacion.equals("true") && this.email.equals(email)) {
            this.master.eliminarEmpresa(email);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarEmpresa(email);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void eliminarBicicleta(String emailBiciusuario, String serial) {
        if(validacion.equals("true") && this.email.equals(emailBiciusuario)) {
            this.master.eliminarBicicleta(emailBiciusuario,serial);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarBicicleta(emailBiciusuario,serial);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public Stakeholder buscarBiciusuario(String email) {
        Stakeholder biciusuario=null;
        if(validacion.equals("Movelo") || validacion.equals("true")) {
            biciusuario=this.master.buscarBiciusuario(email);
        }else{
            System.out.println("No tienes acceso!");
        }
        return biciusuario;
    }

    public Stakeholder buscarEmpresa(String email) {
        Stakeholder empresa=null;
        if(validacion.equals("Movelo")) {
            empresa=this.master.buscarEmpresa(email);
        }else{
            System.out.println("No tienes acceso!");
        }
        return empresa;
    }

    public Stakeholder buscarUserMovelo(String email){
        Stakeholder movelo=null;
        if(validacion.equals("Movelo")) {
            movelo=this.master.buscarUserMovelo(email);
        }else{
            System.out.println("No tienes acceso!");
        }
        return movelo;
    }

    public Stakeholder buscarMiembroEmpresa(String emailEmpresa,String emailMiembro) {
        Stakeholder miembro=null;
        if(validacion.equals("true") && this.email.equals(emailEmpresa)) {
            miembro=this.master.buscarMiembroEmpresa(emailEmpresa, emailMiembro);
        }else{
            System.out.println("No tienes acceso!");
        }
        return miembro;
    }

    public Bicycle buscarBicicleta(String emailBiciusuario,String serial) {
        Bicycle bike=null;
        if(validacion.equals("true") && this.email.equals(emailBiciusuario)) {
            bike=this.master.buscarBicicleta(emailBiciusuario, serial);
        }else{
            System.out.println("No tienes acceso!");
        }
        return bike;
    }

    public void addMiembroEmpresa(String emailEmpresa, Stakeholder miembro) {
        if(validacion.equals("true") && this.email.equals(emailEmpresa)) {
            this.master.addMiembroEmpresa(emailEmpresa, miembro);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        if(validacion.equals("true") && this.email.equals(emailEmpresa)){
            this.master.eliminarMiembroEmpresa(emailEmpresa,emailUsuario);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public String mostrarMiembros() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarMiembros();
        }
        return respuesta;
    }

    public String mostrarMiembrosEmpresa(String emailEmpresa) {
        String respuesta="";
        if(validacion.equals("true") && this.email.equals(emailEmpresa)){
            respuesta=this.master.mostrarMiembrosEmpresa(emailEmpresa);
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }


    public String mostrarBiciusuarios() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarBiciusuarios();
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }


    public String mostrarEmpresas() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarEmpresas();
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }


    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarNombreEmpresa(emailEmpresa, nameNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }


    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarEmailEmpresa(emailEmpresa, emailNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarPassowordEmpresa(emailEmpresa, passwordNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }


    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarDireccionEmpresa(emailEmpresa, direccionNueva);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarNitEmpresa(emailEmpresa, nitNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }


    public void actualizarNombreBiciusuario(String correo,String nombreNuevo) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarNombreBiciusuario(correo,nombreNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }


    public void actualizarEmailBiciusuario(String correo,String emailNuevo) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarEmailBiciusuario(correo,emailNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }


    public void actualizarPasswordBiciusuario(String correo,String claveNueva) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarPasswordBiciusuario(correo,claveNueva);
        }else{
            System.out.println("No tienes acceso!");
        }
    }
     */
}
