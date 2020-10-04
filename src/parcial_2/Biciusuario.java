/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Randy
 */
public class Biciusuario implements Stakeholder{
    private ArrayList<Bicycle> bicicletas;
    private String name,correo,clave,date;
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
            if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1 && !email.equals("") && !nombre.equals("")) {
                name = nombre;
                correo = email;
                clave = password;
                date = fechaNacimiento;
                bicicletas = new ArrayList<>();
                System.out.println("creando...");
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

    @Override
    public String mostrarDatos() {
        return "";
    }

    @Override
    public void setNombre(String name) {
       
    }

    @Override
    public void setEmail(String email) {
       
    }

    @Override
    public void setPassword(String password) {
        
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
}
