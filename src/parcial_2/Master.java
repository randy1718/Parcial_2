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
public class Master implements Operaciones{
    private ArrayList<Stakeholder> miembros=new ArrayList<>();
    private static Master instancia = null;
    
    public static Master laConstructora(){
        if(instancia==null){
            instancia=new Master();
	}
       return instancia;
    }

    @Override
    public void addBiciusuario(String nombre, String email, String password, String fechaNacimiento) {
       Biciusuario user=new Biciusuario(nombre,email,password,fechaNacimiento);
       miembros.add(user);
    }

    @Override
    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
       
    }

    @Override
    public void addBicicleta(String emailBiciusuario,Bicicleta bike) {
        
    }

    @Override
    public void eliminarBiciusuario(String email) {
        
    }

    @Override
    public void eliminarEmpresa(String nit) {
        
    }

    @Override
    public Stakeholder buscarBiciusuario(String email) {
        Stakeholder res=null;
        for(int i=0;i<miembros.size();i++){
           if(miembros.get(i).getEmail().equals(email)){
               res=miembros.get(i);
           }
        }
        return res;
    }

    @Override
    public Stakeholder buscarEmpresa(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        
    }

    @Override
    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        
    }

    @Override
    public String mostrarMiembros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mostrarBiciusuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String mostrarEmpresas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarNombreEmpresa(String nameNuevo) {
        
    }

    @Override
    public void actualizarEmailEmpresa(String emailNuevo) {
        
    }

    @Override
    public void actualizarPassowordEmpresa(String passwordNuevo) {
        
    }

    @Override
    public void actualizarDireccionEmpresa(String direccionNueva) {
        
    }

    @Override
    public void actualizarNitEmpresa(String nitNuevo) {
        
    }

    @Override
    public void actualizarNombreBiciusuario(String nombreNuevo) {
        
    }

    @Override
    public void actualizarEmailBiciusuario(String emailNuevo) {
        
    }

    @Override
    public void actualizarPasswordBiciusuario(String claveNueva) {
        
    }

    @Override
    public boolean validacionDatos(String email, String password) {
        boolean respuesta=false;
        for(int i=0;i<miembros.size();i++){
            Stakeholder miembro=miembros.get(i);
            if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password)){
                respuesta=true;
            }
        }
        return respuesta;
    }
    
}
