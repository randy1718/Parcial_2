/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Randy
 */
public class Movelo {
    
    private String username, email, password;
    private ArrayList<Mensaje> mensajesEmergencia;
    private String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
    
    public Movelo(String username, String email, String password){
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(password);
        int mayusculas = verificarLetrasMayusculas(password);
        int arroba=verificarEmail(email);
        int numeros=verificarCantidadNumeros(password);  
        if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1 && !email.equals("") && !username.equals("")){
           this.username=username;
           this.password=password;
           this.email=email;
           mensajesEmergencia=new ArrayList<>();
        }else{
           JPanel panel=new JPanel();
           JOptionPane.showMessageDialog(panel,"La creacion de movelo tiene la contraseña o el correo invalidos","Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addMensajesEmergencia(String emailUser, String mensaje){
        Mensaje men=new Mensaje(emailUser,mensaje);
        mensajesEmergencia.add(men);
    }

    public void setUsername(String user){
        if(!user.equals("")){
            username=user;
        }else{
            System.out.println("El username nuevo no puede estar vacio!");
        }
    }
    
    public void setCorreo(String correo){
        if(!correo.equals("")){
            int arroba=verificarEmail(email);
            if(arroba==1){
                this.email=email;
            }
        }else{
            System.out.println("El email nuevo no puede estar vacio!");
        }
    }
    
    public void setClave(String clave){
        if(!clave.equals("")){
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(clave);
            int mayusculas = verificarLetrasMayusculas(clave);
            if(clave.length()>=8 && matcher.find() && mayusculas>=1 ){
                password=clave;
            }
        }else{
            System.out.println("La clave nueva no puede estar vacia!");
        }
    }
            
    
   
    public String getUsername() {
        return username;
    }

   
    public String getCorreo() {
        return email;
    }

    
    public String getClave() {
        return password;
    }
    
    public String mostrarInformacion() {
        return "Datos Movelo:\nUsername: "+username+"\nEmail: "+email+"\nPassword: "+password+"\n\n";
    }
    
    public final int verificarLetrasMayusculas(String clave) {
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
    
    public final int verificarEmail(String correo) {
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
    
    public final int verificarCantidadNumeros(String clave) {
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
