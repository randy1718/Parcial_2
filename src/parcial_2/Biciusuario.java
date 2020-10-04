/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import java.util.ArrayList;

/**
 *
 * @author Randy
 */
public class Biciusuario implements Stakeholder{
    private ArrayList<Bicicleta> bicicletas;
    private String name,correo,clave,date;
    private String REG_EXP = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\\)+|"
                + "\\%+|\\&+|\\(+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]"
                + "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\/+|\\\"+";
    
    public Biciusuario(String nombre,String email,String password, String fechaNacimiento){
        name=nombre;
        correo=email;
        clave=password;
        date=fechaNacimiento;
        bicicletas=new ArrayList<>();
        System.out.println("creando...");
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
