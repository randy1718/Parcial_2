package parcial_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensaje {

    private String emailUser="",mensaje="",ubicacion="";
    private String date="";

    SimpleDateFormat formatter;

    public Mensaje(String emailUser, String mensaje){
        this.emailUser=emailUser;
        this.mensaje=mensaje;
        Double latitud=123.3;
        Double longitud=1232.1;
        ubicacion="Su ubicicacion es: \nLatitud: "+latitud+"\nLongitud: "+longitud;
        Date datetime=new Date();
        formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        date=formatter.format(datetime);
    }

    public String getDate(){
        System.out.println(date);
        return date;
    }

    public String getEmailUser(){
        return emailUser;
    }

    public String getMensaje(){
        return mensaje;
    }

    public String mostrarDatos(){
        return "Mensaje:\nEmail usuario: "+emailUser+"\nMensaje: "+mensaje+"\nFecha: "+date;
    }


}
