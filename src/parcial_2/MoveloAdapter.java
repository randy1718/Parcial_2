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
public class MoveloAdapter implements Stakeholder{
    
    protected Movelo movelo;
    
    public MoveloAdapter(String username, String email, String password){
        super();
        movelo=new Movelo(username,email, password);
    }

    @Override
    public String mostrarDatos() {
        String respuesta=this.movelo.mostrarInformacion();
        return respuesta;
    }

    @Override
    public void setNombre(String name) {
        this.movelo.setUsername(name);
    }

    @Override
    public void setEmail(String email) {
        this.movelo.setCorreo(email);
    }

    @Override
    public void setPassword(String password) {
        this.movelo.setClave(password);
    }

    @Override
    public String getNombre() {
        String respuesta=this.movelo.getUsername();
        return respuesta;
    }

    @Override
    public String getEmail() {
        String respuesta=this.movelo.getCorreo();
        return respuesta;
    }

    @Override
    public String getPassword() {
        String respuesta=this.movelo.getClave();
        return respuesta;
    }

    @Override
    public int verificarMayusculas(String clave) {
        int respuesta=this.movelo.verificarLetrasMayusculas(clave);
        return respuesta;
    }

    @Override
    public int verificarCorreo(String email) {
       int respuesta=this.movelo.verificarEmail(email);
       return respuesta;
    }

    @Override
    public int verificarNumeros(String clave) {
        int respuesta=this.movelo.verificarCantidadNumeros(clave);
        return respuesta;
    }
    
}
