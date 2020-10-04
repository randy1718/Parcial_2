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
    protected String validacion="false";
    protected String email="";
    
    public static AccesoProxy laConstructora(){
        if(instancia==null){
            instancia=new AccesoProxy();
	}
       return instancia;
    }
    
    @Override
    public String validacionDatos(String email, String password){
        String respuesta=this.master.validacionDatos(email,password);
        if(respuesta.equals("true") || respuesta.equals("Movelo")) {
            validacion = respuesta;
            this.email=email;
        }
        System.out.println(respuesta);
        return respuesta;
    }

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
    public void addViaje() {

    }

    @Override
    public void addRuta(String emailBiciusuario) {

    }

    @Override
    public void eliminarRuta(String emailBiciusuario) {

    }

    @Override
    public String botonPanico(String email, String mensaje) {
        return null;
    }

    @Override
    public void addBiciusuario(String nombre, String email, String password, String fechaNacimiento) {
        master.addBiciusuario(nombre, email, password, fechaNacimiento);
    }

    @Override
    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
        this.master.addEmpresa(nombre,nit,email,direccion,password);
    }

    @Override
    public void addMoveloUser(String username, String email, String password) {
        this.master.addMoveloUser(username,email,password);
    }

    @Override
    public void addBicicleta(String emailBiciusuario,Bicycle bike) {
        if(validacion.equals("true") && email.equals(emailBiciusuario)){
            this.master.addBicicleta(emailBiciusuario,bike);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarBiciusuario(String email) {
        if(validacion.equals("true") && email.equals(email)){
            this.master.eliminarBiciusuario(email);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarBiciusuario(email);
        }else{
            System.out.println("No tienes acceso!");
        }
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
    public Bicycle buscarBicicleta(String email) {
        return null;
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
       String respuesta=this.master.mostrarMiembros();
       return respuesta;
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
