package parcial_2;

public class Ruta {

    private String coordIniciales="",coordFinales="",code="";

    public Ruta(String coordenadasIniciales,String coordenadasFinales,String codigo){
        coordIniciales=coordenadasIniciales;
        coordFinales=coordenadasFinales;
        code=codigo;
    }

    public String getCodigo(){
        return code;
    }


    public String getCoordFinales() {
        return coordFinales;
    }

    public String getCoordIniciales() {
        return coordIniciales;
    }
}
