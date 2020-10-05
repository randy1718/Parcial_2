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
    private final Master master=Master.laConstructora();
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
    public void addViaje(String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad) {
        this.master.addViaje(coordenadasIniciales,coordenadasFinales,duracion,velocidad);
    }

    @Override
    public void addRuta(String emailBiciusuario, String codigoRuta,String coordenadasIniciales,String coordenadasFinales) {
        this.master.addRuta(emailBiciusuario,codigoRuta,coordenadasIniciales,coordenadasFinales);
    }

    @Override
    public void eliminarRuta(String emailBiciusuario,String codigoRuta) {
        this.master.eliminarRuta(emailBiciusuario,codigoRuta);
    }

    @Override
    public String botonPanico(String email, String mensaje) {
        return this.master.botonPanico(email,mensaje);
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
        if(validacion.equals("true") && this.email.equals(email)){
            this.master.eliminarBiciusuario(email);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarBiciusuario(email);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarEmpresa(String email) {
        if(validacion.equals("true") && this.email.equals(email)) {
            this.master.eliminarEmpresa(email);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarEmpresa(email);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarBicicleta(String emailBiciusuario, String serial) {
        if(validacion.equals("true") && this.email.equals(emailBiciusuario)) {
            this.master.eliminarBicicleta(emailBiciusuario,serial);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarBicicleta(emailBiciusuario,serial);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public Stakeholder buscarBiciusuario(String email) {
        return this.master.buscarBiciusuario(email);
    }

    @Override
    public Stakeholder buscarEmpresa(String email) {
        return this.master.buscarEmpresa(email);
    }

    @Override
    public Stakeholder buscarMiembroEmpresa(String emailEmpresa,String emailMiembro) {
        return this.master.buscarMiembroEmpresa(emailEmpresa,emailMiembro);
    }

    @Override
    public Bicycle buscarBicicleta(String emailBiciusuario,String serial) {
        return this.master.buscarBicicleta(emailBiciusuario,serial);
    }

    @Override
    public void addMiembroEmpresa(String emailEmpresa, Stakeholder miembro) {
        this.master.addMiembroEmpresa(emailEmpresa,miembro);
    }

    @Override
    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        this.master.eliminarMiembroEmpresa(emailEmpresa,emailUsuario);
    }

    @Override
    public String mostrarMiembros() {
        return this.master.mostrarMiembros();
    }

    @Override
    public String mostrarMiembrosEmpresa(String emailEmpresa) {
        return this.master.mostrarMiembrosEmpresa(emailEmpresa);
    }

    @Override
    public String mostrarBiciusuarios() {
        return this.master.mostrarBiciusuarios();
    }

    @Override
    public String mostrarEmpresas() {
        return this.master.mostrarEmpresas();
    }

    @Override
    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo) {
        this.master.actualizarNombreEmpresa(emailEmpresa,nameNuevo);
    }

    @Override
    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {
        this.master.actualizarEmailEmpresa(emailEmpresa,emailNuevo);
    }

    @Override
    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo) {
        this.master.actualizarPassowordEmpresa(emailEmpresa,passwordNuevo);
    }

    @Override
    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva) {
        this.master.actualizarDireccionEmpresa(emailEmpresa,direccionNueva);
    }

    @Override
    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo) {
        this.master.actualizarNitEmpresa(emailEmpresa,nitNuevo);
    }

    @Override
    public void actualizarNombreBiciusuario(String correo,String nombreNuevo) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarNombreBiciusuario(correo,nombreNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarEmailBiciusuario(String correo,String emailNuevo) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarEmailBiciusuario(correo,emailNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarPasswordBiciusuario(String correo,String claveNueva) {
        if(validacion.equals("true") && email.equals(correo)) {
            this.master.actualizarPasswordBiciusuario(correo,claveNueva);
        }else{
            System.out.println("No tienes acceso!");
        }
    }
}
