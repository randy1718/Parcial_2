/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

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
        }else{
           JPanel panel=new JPanel();
           JOptionPane.showMessageDialog(panel,"La creacion de movelo tiene la contraseña o el correo invalidos","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setUsername(String user){
        if(!user.equals("")){
            username=user;
        }else{
            System.out.println("El username nuevo no puede estar vacio!");
        }
    }
    
    public void setCorreo(String correo){
        
    }
    
    public void setClave(String clave){
        
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
        return "Datos Movelo:\n\n Username: "+username+"\nEmail: "+email+"\nPassword: "+password;
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
