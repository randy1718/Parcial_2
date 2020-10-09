package parcial_2;

public class Viaje {

    String ci="",cf="",duracion="",velocidad="",code="";
    int distancia=0;
    int arbolesObtenidos=0;
    public Viaje(String codigo,String coordenadasIniciales,String coordenadasFinales,String duracion,String velocidad, int distanciaKilometros){
        ci=coordenadasIniciales;
        cf=coordenadasFinales;
        this.duracion=duracion;
        this.velocidad=velocidad;
        code=codigo;
        distancia=distanciaKilometros;
        arbolesObtenidos=distanciaKilometros;
    }

    public String getCodigo(){
        return code;
    }

    public String getCoordenadasIniciales(){
        return ci;
    }

    public String getCoordenadasFinales(){
        return cf;
    }

    public String getDuracion(){
        return duracion;
    }

    public String getVelocidad(){
        return velocidad;
    }

    public int getDistancia(){
        return distancia;
    }

    public int getArbolesObtenidos(){
        return arbolesObtenidos;
    }

}
