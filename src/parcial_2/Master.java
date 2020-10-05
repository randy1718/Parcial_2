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
    private final ArrayList<Stakeholder> miembros=new ArrayList<>();
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
        Empresa company=new Empresa(nombre,email,password,direccion,nit);
        miembros.add(company);
    }

    @Override
    public void addMoveloUser(String username, String email, String password) {
        MoveloAdapter movelo=new MoveloAdapter(username,email,password);
        miembros.add(movelo);
    }

    @Override
    public void addBicicleta(String emailBiciusuario,Bicycle bike) {
        for (Stakeholder miembro : miembros) {
            if (miembro instanceof Biciusuario) {
                Biciusuario user = (Biciusuario) miembro;
                if (miembro.getEmail().equals(emailBiciusuario)) {
                    user.addBicicleta(bike);
                    System.out.println("Bicicleta añadida correctamente al biciusuario con correo " + emailBiciusuario + " !");
                }
            }
        }
    }

    @Override
    public void eliminarBiciusuario(String email) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(email)) {
                    miembros.remove(miembros.get(i));
                    System.out.println("Biciusuario con email " + email + " Eliminado!");
                }
            }
        }
    }

    @Override
    public void eliminarEmpresa(String email) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(email)) {
                    miembros.remove(miembros.get(i));
                    System.out.println("Biciusuario con email " + email + " Eliminado!");
                }
            }
        }
    }

    @Override
    public void eliminarBicicleta(String emailBiciusuario, String serial) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailBiciusuario)) {
                    ((Biciusuario) miembros.get(i)).eliminarBicicleta(serial);
                }
            }
        }
    }

    @Override
    public Stakeholder buscarBiciusuario(String email) {
        Stakeholder res=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(email)) {
                    res = miembros.get(i);
                }
            }
        }
        return res;
    }

    @Override
    public Stakeholder buscarEmpresa(String email) {
        Stakeholder res=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(email)) {
                    res = miembros.get(i);
                }
            }
        }
        return res;
    }

    @Override
    public Stakeholder buscarMiembroEmpresa(String emailEmpresa,String emailMiembro) {
        Stakeholder res=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                    res = ((Empresa) miembros.get(i)).darMiembro(emailMiembro);
                }
            }
        }
        return res;
    }

    @Override
    public Bicycle buscarBicicleta(String emailBiciusuario,String serial) {
        Bicycle bike=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailBiciusuario)) {
                    bike = ((Biciusuario) miembros.get(i)).darBicicleta(serial);
                }
            }
        }
        return bike;
    }

    @Override
    public void addMiembroEmpresa(String emailEmpresa, Stakeholder miembro) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                    ((Empresa) miembros.get(i)).addMiembros(miembro);
                    System.out.println("Miembro añadido correctamente!");
                }
            }
        }
    }

    @Override
    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                    ((Empresa) miembros.get(i)).eliminarMiembro(emailUsuario);
                }
            }
        }
    }

    @Override
    public String mostrarMiembros() {
        String respuesta="";
        for(int i=0;i<miembros.size();i++){
            respuesta=respuesta+miembros.get(i).mostrarDatos();
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public String mostrarMiembrosEmpresa(String emailEmpresa) {
        String respuesta="";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                    respuesta=respuesta+((Empresa) miembros.get(i)).mostrarMiembros();
                }
            }
        }
        System.out.println(respuesta);
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
    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo) {

    }

    @Override
    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {

    }

    @Override
    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo) {

    }

    @Override
    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva) {

    }

    @Override
    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo) {

    }

    @Override
    public void actualizarNombreBiciusuario(String correo,String nombreNuevo) {

    }

    @Override
    public void actualizarEmailBiciusuario(String correo,String emailNuevo) {

    }

    @Override
    public void actualizarPasswordBiciusuario(String correo,String claveNueva) {

    }

    @Override
    public String validacionDatos(String email, String password) {
        String respuesta="false";
        try{
            for(int i=0;i<miembros.size();i++){
                Stakeholder miembro=miembros.get(i);
                if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password) && miembro instanceof MoveloAdapter){
                    respuesta="Movelo";
                    break;
                }else if(miembro.getEmail().equals(email) && miembro.getPassword().equals(password)){
                    respuesta="true";
                    break;
                }
            }
        }catch (Exception e){

        }

        return respuesta;
    }

    @Override
    public String mostrarBicicletas(String emailBiciusuario) {
        return null;
    }

    @Override
    public void addViaje(String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad) {

    }

    @Override
    public void addRuta(String emailBiciusuario, String codigoRuta,String coordenadasIniciales,String coordenadasFinales) {

    }

    @Override
    public void eliminarRuta(String emailBiciusuario,String codigoRuta) {

    }

    @Override
    public String botonPanico(String email, String mensaje) {
        return null;
    }

}
