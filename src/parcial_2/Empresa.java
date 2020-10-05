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
public class Empresa implements Stakeholder{
    private ArrayList<Stakeholder> miembros;
    private String name, direccion, nit, email, password;
    private String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
    
    public Empresa(String nombre, String email, String password, String direccion, String nit){
        Pattern pattern = Pattern.compile(REG_EXP);
        Matcher matcher = pattern.matcher(password);
        int mayusculas = verificarMayusculas(password);
        int arroba=verificarCorreo(email);
        int numeros=verificarNumeros(password);
        
        if(password.length()>=8 && matcher.find() && mayusculas>=1 && arroba==1 && numeros>=1 && !email.equals("") && !nombre.equals("")){
           name=nombre;
           this.password=password;
           this.email=email;
           this.nit=nit;
           this.direccion=direccion;
           miembros =new ArrayList<>();
            System.out.println("creando empresa...");
        }else{
           JPanel panel=new JPanel();
           JOptionPane.showMessageDialog(panel,"La empresa "+nombre+" tiene la contraseña o el correo invalidos","Error", JOptionPane.ERROR_MESSAGE);
        }           
    }

    public void addMiembros(Stakeholder miembro){
        miembros.add(miembro);
    }

    public Stakeholder darMiembro(String email){
        Stakeholder miembro=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email)){
                miembro=miembros.get(i);
            }
        }
        return miembro;
    }

    public void eliminarMiembro(String email){
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email)){
                miembros.remove(i);
            }
        }
    }

    public String mostrarMiembros(){
        String respuesta="Estos son los miembros:";
        if(miembros.size()==0){
            respuesta="Esta empresa no tiene miembros";
        }else {
            for (int i = 0; i < miembros.size(); i++) {
                respuesta = respuesta + "\n" + miembros.get(i).mostrarDatos();
            }
        }
        return respuesta;
    }

    @Override
    public String mostrarDatos() {
        return "Datos Empresa:\nNombre: "+name+"\nNit: "+nit+"\nEmail: "+email+"\nDireccion: "+direccion+"\n";
    }

    @Override
    public void setNombre(String name) {
        if(!name.equals("")){
            this.name=name;
        }else{
            System.out.println("El nombre nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setEmail(String email) {
        if(!email.equals("")){
            int arroba=verificarCorreo(email);
            if(arroba==1){
                this.email=email;
            }
        }else{
            System.out.println("El email nuevo no puede estar vacio!");
        }
    }

    @Override
    public void setPassword(String password) {
        if(!password.equals("")){
            Pattern pattern = Pattern.compile(REG_EXP);
            Matcher matcher = pattern.matcher(password);
            int mayusculas = verificarMayusculas(password);
            if(password.length()>=8 && matcher.find() && mayusculas>=1 ){
                this.password=password;
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
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getNit(){
        return nit;
    }
    
    @Override
    public final int verificarMayusculas(String clave) {
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
    public final int verificarCorreo(String correo) {
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
    public final int verificarNumeros(String clave) {
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
