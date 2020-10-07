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
    public void addViaje(String emailUser,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros) {
        if(validacion.equals("true") && email.equals(emailUser)) {
            this.master.addViaje(emailUser,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
        }else if(validacion.equals("Movelo")) {
            this.master.addViaje(emailUser,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
        }else{
            System.out.println("No tienes acceso!");
        }

    }

    @Override
    public void addRuta(String emailUser, String codigoRuta,String coordenadasIniciales,String coordenadasFinales) {
        if(validacion.equals("true") && email.equals(emailUser)) {
            this.master.addRuta(emailUser, codigoRuta, coordenadasIniciales, coordenadasFinales);
        }else if(validacion.equals("Movelo")) {
            this.master.addRuta(emailUser, codigoRuta, coordenadasIniciales, coordenadasFinales);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarRuta(String emailUser,String codigoRuta) {
        if(validacion.equals("true") && email.equals(emailUser)) {
            this.master.eliminarRuta(emailUser,codigoRuta);
        }else if(validacion.equals("Movelo")) {
            this.master.eliminarRuta(emailUser,codigoRuta);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public String botonPanico(String email, String mensaje) {
        String respuesta="";
        if(validacion.equals("true") && this.email.equals(email)) {
            respuesta= this.master.botonPanico(email, mensaje);
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
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
        Stakeholder biciusuario=null;
        if(validacion.equals("Movelo") || validacion.equals("true")) {
            biciusuario=this.master.buscarBiciusuario(email);
        }else{
            System.out.println("No tienes acceso!");
        }
        return biciusuario;
    }

    @Override
    public Stakeholder buscarEmpresa(String email) {
        Stakeholder empresa=null;
        if(validacion.equals("Movelo")) {
            empresa=this.master.buscarEmpresa(email);
        }else{
            System.out.println("No tienes acceso!");
        }
        return empresa;
    }

    @Override
    public Stakeholder buscarMiembroEmpresa(String emailEmpresa,String emailMiembro) {
        Stakeholder miembro=null;
        if(validacion.equals("true") && this.email.equals(emailEmpresa)) {
            miembro=this.master.buscarMiembroEmpresa(emailEmpresa, emailMiembro);
        }else{
            System.out.println("No tienes acceso!");
        }
        return miembro;
    }

    @Override
    public Bicycle buscarBicicleta(String emailBiciusuario,String serial) {
        Bicycle bike=null;
        if(validacion.equals("true") && this.email.equals(emailBiciusuario)) {
            bike=this.master.buscarBicicleta(emailBiciusuario, serial);
        }else{
            System.out.println("No tienes acceso!");
        }
        return bike;
    }

    @Override
    public void addMiembroEmpresa(String emailEmpresa, Stakeholder miembro) {
        if(validacion.equals("true") && this.email.equals(emailEmpresa)) {
            this.master.addMiembroEmpresa(emailEmpresa, miembro);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        if(validacion.equals("true") && this.email.equals(emailEmpresa)){
        this.master.eliminarMiembroEmpresa(emailEmpresa,emailUsuario);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public String mostrarMiembros() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarMiembros();
        }
        return respuesta;
    }

    @Override
    public String mostrarMiembrosEmpresa(String emailEmpresa) {
        String respuesta="";
        if(validacion.equals("true") && this.email.equals(emailEmpresa)){
            respuesta=this.master.mostrarMiembrosEmpresa(emailEmpresa);
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }

    @Override
    public String mostrarBiciusuarios() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarBiciusuarios();
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }

    @Override
    public String mostrarEmpresas() {
        String respuesta="";
        if(validacion.equals("Movelo")) {
            respuesta=this.master.mostrarEmpresas();
        }else{
            System.out.println("No tienes acceso!");
        }
        return respuesta;
    }

    @Override
    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarNombreEmpresa(emailEmpresa, nameNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarEmailEmpresa(emailEmpresa, emailNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarPassowordEmpresa(emailEmpresa, passwordNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarDireccionEmpresa(emailEmpresa, direccionNueva);
        }else{
            System.out.println("No tienes acceso!");
        }
    }

    @Override
    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo) {
        if(validacion.equals("true") && email.equals(emailEmpresa)) {
            this.master.actualizarNitEmpresa(emailEmpresa, nitNuevo);
        }else{
            System.out.println("No tienes acceso!");
        }
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
