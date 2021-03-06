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
public class Master{

    private final ArrayList<Stakeholder> miembros=new ArrayList<>();

    private static Master instancia = null;

    public static Master laConstructora(){
        if(instancia==null){
            instancia=new Master();
	}
       return instancia;
    }


    public void addBiciusuario(Stakeholder biciusuario) {
        int contador=0;
        for(int i=0;i<miembros.size();i++){
            if(biciusuario.getEmail().equals(miembros.get(i).getEmail()) || biciusuario.getNombre().equals(miembros.get(i).getNombre())){
                System.out.println("El biciusuario ya existe!");
            }
            else{
                contador++;
            }
        }
        if(contador==miembros.size()){
            miembros.add(biciusuario);
        }

    }

    public void addEmpresa(Stakeholder empresa) {
        int contador=0;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof  Empresa) {
                if (empresa.getEmail().equals(miembros.get(i).getEmail()) || empresa.getNombre().equals(miembros.get(i).getNombre()) ||((Empresa)empresa).getNit().equals(((Empresa)miembros.get(i)).getNit()) ) {
                    System.out.println("La empresa ya existe!");
                }else{
                    contador++;
                }
            }else{
                contador++;
            }
        }
        if(contador==miembros.size()){
            miembros.add(empresa);
            System.out.println("Empresa creada correctamente "+empresa.getNombre());
        }

    }

    public void addMoveloUser(Stakeholder movelo) {
        miembros.add(movelo);
    }


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


    public void eliminarBicicleta(String emailBiciusuario, String serial) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailBiciusuario)) {
                    ((Biciusuario) miembros.get(i)).eliminarBicicleta(serial);
                    System.out.println("Se borro correctamente la bicicleta"+serial);
                }
            }
        }
    }


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

    public Stakeholder buscarUserMovelo(String email){
        Stakeholder res=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof MoveloAdapter) {
                if (miembros.get(i).getEmail().equals(email)) {
                    res = miembros.get(i);
                }
            }
        }
        return res;
    }


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


    public Bicycle buscarBicicleta(String emailBiciusuario,String serial) {
        Bicycle bike=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailBiciusuario)) {
                    bike = ((Biciusuario) miembros.get(i)).darBicicleta(serial);
                }
            }
        }
        System.out.println(bike.showBicycle());
        return bike;
    }


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


    public void eliminarMiembroEmpresa(String emailEmpresa, String emailUsuario) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Empresa) {
                if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                    ((Empresa) miembros.get(i)).eliminarMiembro(emailUsuario);
                }
            }
        }
    }


    public String mostrarMiembros() {
        String respuesta="";
        for(int i=0;i<miembros.size();i++){
            respuesta=respuesta+miembros.get(i).mostrarDatos();
        }
        System.out.println(respuesta);
        return respuesta;
    }


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

    public void actualizarEmailEmpresa(String emailEmpresa,String emailNuevo) {
        if(emailEmpresa.equals("")||emailNuevo.equals("")) {
            System.out.println("Los datos no pueden estar vacios");
        }else{
            for (int i = 0; i < miembros.size(); i++) {
                if (miembros.get(i) instanceof Empresa) {
                    if (miembros.get(i).getEmail().equals(emailEmpresa)) {
                        if (miembros.get(i).getEmail().equals(emailNuevo)) {
                            System.out.println("Ese email ya esta registrado para esa empresa");
                        }else {
                            ((Empresa) miembros.get(i)).setEmail(emailNuevo);
                        }
                    }
                }
            }
        }
    }

    public void actualizarPasswordEmpresa(String emailEmpresa,String passwordNuevo) {
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

    public void addViaje(String emailUser,String code,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros) {
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Biciusuario) miembros.get(i)).addViaje(code,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(emailUser)) {
                    ((Empresa) miembros.get(i)).addViaje(code,coordenadasIniciales,coordenadasFinales,duracion,velocidad,distanciaKilometros);
                }
            }
        }
    }

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

    public ArrayList<Mensaje> getMessages(String email, String emailUser){
        ArrayList<Mensaje> messages=new ArrayList<>();
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof  MoveloAdapter) {
                if (miembros.get(i).getEmail().equals(email)) {
                    messages =((MoveloAdapter)miembros.get(i)).getMensajes(emailUser);
                }
            }
        }
        return messages;
    }

    public Viaje buscarViaje(String email,String code){
        Viaje v=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(email)) {
                    v=((Biciusuario) miembros.get(i)).getViaje(code);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(email)) {
                    v=((Empresa) miembros.get(i)).getViaje(code);
                }
            }
        }
        return v;
    }

    public Ruta buscarRuta(String email,String code){
        Ruta v=null;
        for(int i=0;i<miembros.size();i++){
            if(miembros.get(i) instanceof Biciusuario) {
                if (miembros.get(i).getEmail().equals(email)) {
                    v=((Biciusuario) miembros.get(i)).getRuta(code);
                }
            }else if(miembros.get(i) instanceof Empresa){
                if (miembros.get(i).getEmail().equals(email)) {
                    v=((Empresa) miembros.get(i)).getRuta(code);
                }
            }
        }
        return v;
    }

}
