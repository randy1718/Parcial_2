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
public class AccesoProxy implements Operaciones{
    private static AccesoProxy instancia = null;
    private Master master=Master.laConstructora();
    protected boolean validacion=false;
    
    public static AccesoProxy laConstructora(){
        if(instancia==null){
            instancia=new AccesoProxy();
	}
       return instancia;
    }
    
    @Override
    public boolean validacionDatos(String name, String password){
        boolean respuesta=this.master.validacionDatos(name,password);
        validacion=respuesta;
        return respuesta;
    }

    @Override
    public void addBiciusuario(String nombre, String email, String password, String fechaNacimiento) {
        master.addBiciusuario(nombre, email, password, fechaNacimiento);
    }

    @Override
    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
        
    }

    @Override
    public void addBicicleta(String emailBiciusuario,Bicicleta bike) {
        if(validacion==true){
            this.master.addBicicleta(emailBiciusuario,bike);
            System.out.println("Bicicleta añadida correctamente!");
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarBiciusuario(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEmpresa(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stakeholder buscarBiciusuario(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Stakeholder buscarEmpresa(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarEmailEmpresa(String emailNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPassowordEmpresa(String passwordNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarDireccionEmpresa(String direccionNueva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarNitEmpresa(String nitNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarNombreBiciusuario(String nombreNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarEmailBiciusuario(String emailNuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarPasswordBiciusuario(String claveNueva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
