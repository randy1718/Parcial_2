/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_2;

import javax.annotation.processing.SupportedSourceVersion;
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
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(nombre)){
                System.out.println("El biciusuario ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(nombre) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre de usuario ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            Biciusuario user=new Biciusuario(nombre,email,password,fechaNacimiento);
            miembros.add(user);
        }

    }

    @Override
    public void addEmpresa(String nombre, String nit, String email, String direccion, String password) {
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(nombre)){
                System.out.println("La empresa ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(nombre) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre de la empresa ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            Empresa company=new Empresa(nombre,email,password,direccion,nit);
            miembros.add(company);
        }

    }

    @Override
    public void addMoveloUser(String username, String email, String password) {
        int contador = 0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i).getEmail().equals(email) && miembros.get(i).getNombre().equals(username)){
                System.out.println("El usario de Movelo ya esta registrado");
            }else if(miembros.get(i).getNombre().equals(username) || miembros.get(i).getEmail().equals(email)){
                System.out.println("El email o el nombre del usuario de Movelo ya estan registrados");
            }else{
                contador++;
            }
        }
        if (contador== miembros.size()) {
            MoveloAdapter movelo=new MoveloAdapter(username,email,password);
            miembros.add(movelo);
        }

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
        String respuesta="Estos son los biciusuarios:\n\n";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                respuesta = respuesta + miembros.get(i).mostrarDatos();
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public String mostrarEmpresas() {
        String respuesta="Estas son las empresas:\n\n";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                respuesta = respuesta + miembros.get(i).mostrarDatos();
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public void actualizarNombreEmpresa(String emailEmpresa,String nameNuevo) {
        if(emailEmpresa.equals("")||nameNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        miembros.get(i).setNombre(nameNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {
        if(emailEmpresa.equals("")||emailNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        ((Empresa) miembros.get(i)).setEmail(emailNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarPassowordEmpresa(String emailEmpresa,String passwordNuevo) {
        if(emailEmpresa.equals("")||passwordNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        ((Empresa) miembros.get(i)).setPassword(passwordNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarDireccionEmpresa(String emailEmpresa,String direccionNueva) {
        if(emailEmpresa.equals("")||direccionNueva.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        ((Empresa) miembros.get(i)).setDireccion(direccionNueva);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarNitEmpresa(String emailEmpresa,String nitNuevo) {
        if(emailEmpresa.equals("")||nitNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        ((Empresa) miembros.get(i)).setNit(nitNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarNombreBiciusuario(String correo,String nombreNuevo) {
        if(correo.equals("")||nombreNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Biciusuario) {
                    if (miembros.get(i).getEmail().equals(correo)) {
                        miembros.get(i).setNombre(nombreNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarEmailBiciusuario(String correo,String emailNuevo) {
        if(correo.equals("")||emailNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Biciusuario) {
                    if (miembros.get(i).getEmail().equals(correo)) {
                        miembros.get(i).setEmail(emailNuevo);
                    }
                }
            }
        }
    }

    @Override
    public void actualizarPasswordBiciusuario(String correo,String claveNueva) {
        if(correo.equals("")||claveNueva.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Biciusuario) {
                    if (miembros.get(i).getEmail().equals(correo)) {
                        miembros.get(i).setPassword(claveNueva);
                    }
                }
            }
        }
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
        String respuesta="Estas son las bicicletas:\n\n";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if(miembros.get(i).getEmail().equals(emailBiciusuario)){
                    respuesta = respuesta + ((Biciusuario) miembros.get(i)).getBicicletas();
                }
            }
        }
        System.out.println(respuesta);
        return respuesta;
    }

    @Override
    public void addViaje(String emailUser,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Biciusuario) miembros.get(i)).addViaje(coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Empresa) miembros.get(i)).addViaje(coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
                }
            }
        }
    }

    @Override
    public void addRuta(String emailUser, String codigoRuta,String coordenadasIniciales,String coordenadasFinales) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Biciusuario) miembros.get(i)).addRuta(codigoRuta,coordenadasIniciales,coordenadasFinales);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Empresa) miembros.get(i)).addRuta(codigoRuta,coordenadasIniciales,coordenadasFinales);
                }
            }
        }
    }

    @Override
    public void eliminarRuta(String emailUser,String codigoRuta) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Biciusuario) miembros.get(i)).eliminarRuta(codigoRuta);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Empresa) miembros.get(i)).eliminarRuta(codigoRuta);
                }
            }
        }
    }

    @Override
    public String botonPanico(String email, String mensaje) {
        String respuesta="";
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof MoveloAdapter){
                ((MoveloAdapter) miembros.get(i)).addMensaje(email,mensaje);
                respuesta="Mensaje enviado correctamente";
                System.out.println(respuesta);
            }
        }
        return respuesta;
    }

}
