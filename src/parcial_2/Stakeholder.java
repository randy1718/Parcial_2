/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

/**
 *
 * @author Randy
 */
public interface Stakeholder {
    public String mostrarDatos();
    public void setNombre(String name);
    public void setEmail(String email);
    public void setPassword(String password);
    public String getNombre();
    public String getEmail();
    public String getPassword();
    public int verificarMayusculas(String clave);
    public int verificarCorreo(String email);
    public int verificarNumeros(String clave);
    
}
