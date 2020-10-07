package parcial_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mensaje {

    String emailUser="",mensaje="",ubicacion="";
    String date="";

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

}
