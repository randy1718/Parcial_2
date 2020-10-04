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
    public void addBicicleta(String emailBiciusuario,Bicicleta bike);
    public void eliminarBiciusuario(String email);
    public void eliminarEmpresa(String nit);
    public Stakeholder buscarBiciusuario(String email);
    public Stakeholder buscarEmpresa(String email);
    public void addMiembroEmpresa(String emailEmpresa,String emailUsuario);
    public void eliminarMiembroEmpresa(String emailEmpresa,String emailUsuario);
    public String mostrarMiembros();
    public String mostrarBiciusuarios();
    public String mostrarEmpresas();
    public void actualizarNombreEmpresa(String nameNuevo);
    public void actualizarEmailEmpresa(String emailNuevo);
    public void actualizarPassowordEmpresa(String passwordNuevo);
    public void actualizarDireccionEmpresa(String direccionNueva);
    public void actualizarNitEmpresa(String nitNuevo);
    public void actualizarNombreBiciusuario(String nombreNuevo);
    public void actualizarEmailBiciusuario(String emailNuevo);
    public void actualizarPasswordBiciusuario(String claveNueva);
    public boolean validacionDatos(String name, String password);
    
}
