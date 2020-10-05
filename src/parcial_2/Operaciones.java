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
public interface Operaciones {
    public void addBiciusuario(String nombre,String email,String password, String fechaNacimiento);
    public void addEmpresa(String nombre,String nit, String email, String direccion,String password);
    public void addMoveloUser(String username,String email, String password);
    public void addBicicleta(String emailBiciusuario,Bicycle bike);
    public void eliminarBiciusuario(String email);
    public void eliminarEmpresa(String email);
    public Stakeholder buscarBiciusuario(String email);
    public Stakeholder buscarEmpresa(String email);
    public Bicycle buscarBicicleta(String email);
    public void addMiembroEmpresa(String emailEmpresa,String emailUsuario);
    public void eliminarMiembroEmpresa(String emailEmpresa,String emailUsuario);
    public String mostrarMiembros();
    public String mostrarBiciusuarios();
    public String mostrarEmpresas();
    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo);
    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo);
    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo);
    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva);
    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo);
    public void actualizarNombreBiciusuario(String correo,String nombreNuevo);
    public void actualizarEmailBiciusuario(String correo,String emailNuevo);
    public void actualizarPasswordBiciusuario(String correo,String claveNueva);
    public String validacionDatos(String email, String password);
    public String mostrarBicicletas(String emailBiciusuario);
    public void addViaje();
    public void addRuta(String emailBiciusuario);
    public void eliminarRuta(String emailBiciusuario);
    public String botonPanico(String email,String mensaje);
    
}
