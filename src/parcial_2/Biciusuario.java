/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import javax.swing.*;
import java.security.spec.ECField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Randy
 */
public class Biciusuario extends Stakeholder{
    private ArrayList<Bicycle> bicicletas;
    private ArrayList<Ruta> rutas;
    private ArrayList<Viaje> viajes;
    private int arboles;
    private String name,correo,clave;
    private String date;
    private String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
    
    public Biciusuario(String nombre,String email,String password, String fechaNacimiento){
        try {
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(password);
            int mayusculas = verificarMayusculas(password);
            int arroba=verificarCorreo(email);
            int numeros=verificarNumeros(password);
            Date fecha=null;
            SimpleDateFormat formatter=null;
            try{
                fecha = new SimpleDateFormat("yyyy/MM/dd").parse(fechaNacimiento);
                formatter=new SimpleDateFormat("yyyy/MM/dd");
            }catch (Exception e){
                System.out.println("La fecha de nacimiento no tiene el formato valido (YYYY/MM/DD)");
            }

            if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1 && !email.isEmpty() && !nombre.isEmpty() && fecha!=null) {
                name = nombre;
                correo = email;
                clave = password;
                date=formatter.format(fecha);
                bicicletas = new ArrayList<>();
                rutas=new ArrayList<>();
                viajes=new ArrayList<>();
                arboles=0;
                System.out.println("creando biciusuario...");
            }else if(fecha==null) {
                JPanel panel=new JPanel();
                JOptionPane.showMessageDialog(panel,"El biciusuario "+nombre+" ingreso la fecha de nacimiento en un formato invalido, el correcto es (YYYY/MM/DD)","Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JPanel panel=new JPanel();
                JOptionPane.showMessageDialog(panel,"El biciusuario "+nombre+" tiene la contraseña o el correo invalidos","Error", JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e){

        }

    }

    public void addBicicleta(Bicycle bike){
        bicicletas.add(bike);
    }

    public Bicycle darBicicleta(String serial){
        Bicycle bike=null;
        try{
            for(int i=0;i<bicicletas.size();i++){
                Bicicleta bici= (Bicicleta) bicicletas.get(i);
                if(bici.getSerial().equals(serial)){
                    bike=bici;
                }
            }
        }catch (Exception e){

        }

        return bike;
    }

    public void eliminarBicicleta(String serial){
        for(int i=0;i<bicicletas.size();i++){
            Bicicleta bici= (Bicicleta) bicicletas.get(i);
            if(bici.getSerial().equals(serial)){
                bicicletas.remove(bici);
            }
        }
    }

    public String getBicicletas(){
        String respuesta="No tiene bicicletas";
        for(int i=0;i<bicicletas.size();i++){
            Bicycle bici= bicicletas.get(i);
                respuesta=respuesta+bici.showBicycle();
        }
        return respuesta;
    }

    public void addRuta(String codigo,String coorIni,String coorFin){
        if(codigo.isEmpty() || coorIni.isEmpty() || coorFin.isEmpty()){
           System.out.println("Alguno de los valores esta vacio y por eso no se puede crear la ruta");
        }else {
            Ruta r = new Ruta(coorIni, coorFin, codigo);
            rutas.add(r);
            System.out.println("Ruta añadida exitosamente!");
        }
    }

    public Ruta getRuta(String codigo){
        Ruta respuesta=null;
        try{
            for(int i=0;i<rutas.size();i++){
                if(rutas.get(i).getCodigo().equals(codigo)){
                    respuesta=rutas.get(i);
                }
            }
        }catch (Exception e){

        }

        return respuesta;
    }

    public void eliminarRuta(String codigo){
        for(int i=0;i<rutas.size();i++){
            if(rutas.get(i).getCodigo().equals(codigo)){
                rutas.remove(rutas.get(i));
            }
        }
    }

    public void addViaje(String codigoViaje,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros){
        Viaje travel=new Viaje(codigoViaje,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
        viajes.add(travel);
        arboles=arboles+distanciaKilometros;
        System.out.println("El usuario "+getNombre()+" obtiene "+distanciaKilometros+" arboles por este viaje!");
    }

    public Viaje getViaje(String codigo){
        Viaje respuesta=null;
        try{
            for(int i=0;i<viajes.size();i++){
                if(viajes.get(i).getCodigo().equals(codigo)){
                    respuesta=viajes.get(i);
                }
            }
        }catch (Exception e){

        }

        return respuesta;
    }

    @Override
    public String mostrarDatos() {
        return "Datos Biciusuario: \n"+"Nombre: "+name+"\nEmail: "+correo+"\nFecha de Nacimiento: "+date+"\n\n";
    }

    @Override
    public void setNombre(String name) {
        if(!name.equals("")){
            this.name=name;
        }else{
            System.out.println("El username nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setEmail(String email) {
        if(!correo.equals("")){
            int arroba=verificarCorreo(email);
            if(arroba==1){
                correo=email;
            }
        }else{
            System.out.println("El email nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setPassword(String password) {
        if(!password.equals("")){
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(clave);
            int mayusculas = verificarMayusculas(clave);
            if(password.length()>=8 && matcher.find() && mayusculas>=1 ){
                clave=password;
            }
        }else{
            System.out.println("La clave nueva no puede estar vacia!");
        }
    }

    @Override
    public String getNombre() {
       return name;
    }

    @Override
    public String getEmail() {
        return correo;
    }

    @Override
    public String getPassword() {
        return clave;
    }

    public String getFechaNacimiento(){
        String respuesta="";
        try{
            respuesta=date;
        }catch (Exception e){
            System.out.println(e);
            if(e.toString().equals("java.lang.NullPointerException")){
                respuesta="La fecha no tiene el formato requerido (yyyy/MM/DD)";
            }
        }
        return respuesta;
    }

    @Override
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

    @Override
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

    @Override
    public int verificarNumeros(String clave) {
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
