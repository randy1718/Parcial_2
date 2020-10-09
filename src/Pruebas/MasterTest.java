package Pruebas;

import org.junit.jupiter.api.Test;
import parcial_2.*;

import static org.junit.jupiter.api.Assertions.*;

class MasterTest {

    @Test
    void addBiciusuario() {

        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Alejandro","alejo@outlook.com","123qweQ%4","2000/12/22");
        acceso.addBiciusuario(user);
        Stakeholder miembro=acceso.buscarBiciusuario("alejo@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String date=((Biciusuario)miembro).getFechaNacimiento();
        assertEquals("Alejandroalejo@outlook.com123qweQ%42000/12/22",name+email+password+date);

    }

    @Test
    void addEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Amazon","amazon@gmail.com","1234aSAD%$","carrera 8 #109-08","123444356");
        acceso.addEmpresa(empresa);
        Stakeholder miembro=acceso.buscarEmpresa("amazon@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String nit=((Empresa)miembro).getNit();
        assertEquals("Amazon123444356amazon@gmail.com1234aSAD%$",name+nit+email+password);
    }

    @Test
    void addMoveloUser() {
        Master acceso=Master.laConstructora();
        Stakeholder movelo=new MoveloAdapter("movelo20","movelo@movelo.com","12345Q%3");
        acceso.addMoveloUser(movelo);
        Stakeholder miembro=acceso.buscarUserMovelo("movelo@movelo.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        assertEquals("movelo20movelo@movelo.com",name+email);
    }

    @Test
    void addBicicleta() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Camila","camila@outlook.com","123qweQ%4","2000/12/22");
        acceso.addBiciusuario(user);
        Bicycle bike=new Bicicleta("1234","src","rojo");
        acceso.addBicicleta("camila@outlook.com",bike);
        Bicycle b=acceso.buscarBicicleta("camila@outlook.com","1234");
        String serial=b.getSerial();
        String marca=b.getMarca();
        String color=b.getColor();
        assertEquals("1234srcrojo",serial+marca+color);

    }

    @Test
    void eliminarBiciusuario() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Alejo","alejo17@outlook.com","123qweQ%4","2000/12/22");
        acceso.addBiciusuario(user);
        Stakeholder miembro=acceso.buscarBiciusuario("alejo17@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String date=((Biciusuario)miembro).getFechaNacimiento();
        assertEquals("Alejoalejo17@outlook.com123qweQ%42000/12/22",name+email+password+date);
        acceso.eliminarBiciusuario("alejo17@outlook.com");
        Stakeholder member=acceso.buscarBiciusuario("alejo17@outlook.com");
        if(member!=null){
            fail("No se eliminó correctamente el biciusuario!");
        }
    }

    @Test
    void eliminarEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("IBM","ibm@gmail.com","1234aSAD%$","carrera 8 #109-08","147894356");
        acceso.addEmpresa(empresa);
        Stakeholder miembro=acceso.buscarEmpresa("ibm@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String nit=((Empresa)miembro).getNit();
        assertEquals("IBM147894356ibm@gmail.com1234aSAD%$",name+nit+email+password);
        acceso.eliminarEmpresa("ibm@gmail.com");
        Stakeholder mem=acceso.buscarEmpresa("ibm@gmail.com");
        if(mem!=null){
            fail("No se eliminó correctamente la empresa");
        }
    }

    @Test
    void eliminarBicicleta(){
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Sofocles","sof@outlook.com","123qqeQ%5","2002/10/12");
        acceso.addBiciusuario(user);
        Bicycle bike=new Bicicleta("12544","rzas","azul");
        acceso.addBicicleta("sof@outlook.com",bike);
        Bicycle b=acceso.buscarBicicleta("sof@outlook.com","12544");
        String serial=b.getSerial();
        String marca=b.getMarca();
        String color=b.getColor();
        assertEquals("12544rzasazul",serial+marca+color);
        acceso.eliminarBicicleta("sof@outlook.com","12544");
        Bicycle buscada=null;
        try {
             buscada= acceso.buscarBicicleta("sof@outlook.com", "12544");
        }catch (Exception e){

        }
        if (buscada!=null) {
            fail("No se eliminó correctamente la bicicleta");
        }
    }

    @Test
    void buscarBiciusuario() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Sofia","sofia@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        Stakeholder miembro=acceso.buscarBiciusuario("sofia@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String date=((Biciusuario)miembro).getFechaNacimiento();
        assertEquals("Sofiasofia@outlook.com123qqeQ%42002/10/22",name+email+password+date);
    }

    @Test
    void buscarEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Oracle","oracle@gmail.com","1234aSAF%$","carrera 8 #109-08","121234356");
        acceso.addEmpresa(empresa);
        Stakeholder emp=new Empresa("Samsung","samsung@gmail.com","1234aSED%$","carrera 8 #109-08","127864356");
        acceso.addEmpresa(emp);
        Stakeholder miembro=acceso.buscarEmpresa("samsung@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String nit=((Empresa)miembro).getNit();
        assertEquals("Samsung127864356samsung@gmail.com1234aSED%$",name+nit+email+password);
    }

    @Test
    void buscarUserMovelo() {
        Master acceso=Master.laConstructora();
        Stakeholder movelo=new MoveloAdapter("movelo2018","movelo09@movelo.com","21345Q%3");
        acceso.addMoveloUser(movelo);
        Stakeholder miembro=acceso.buscarUserMovelo("movelo09@movelo.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        assertEquals("movelo2018movelo09@movelo.com",name+email);
    }

    @Test
    void buscarMiembroEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Nutresa","nutresa@gmail.com","1231aSAF%$","carrera 8 #109-08","122234356");
        acceso.addEmpresa(empresa);
        Stakeholder user=new Biciusuario("Silvana","silvana@outlook.com","1313qqeQ%4","1992/10/22");
        acceso.addMiembroEmpresa("nutresa@gmail.com",user);
        Stakeholder miembro1=new Empresa("Tesla","tesla@gmail.com","1231aSAF%$","carrera 8 #109-08","122238756");
        acceso.addMiembroEmpresa("nutresa@gmail.com",miembro1);
        Stakeholder membe=acceso.buscarMiembroEmpresa("nutresa@gmail.com","tesla@gmail.com");
        String name=membe.getNombre();
        String email=membe.getEmail();
        String password=membe.getPassword();
        assertEquals("Teslatesla@gmail.com1231aSAF%$",name+email+password);
    }

    @Test
    void buscarBicicleta() {
    }

    @Test
    void addMiembroEmpresa() {
    }

    @Test
    void eliminarMiembroEmpresa() {
    }

    @Test
    void mostrarMiembrosEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Starbucks","starbucks@gmail.com","1231aSAF%$","carrera 8 #109-08","196234356");
        acceso.addEmpresa(empresa);
        Stakeholder user=new Biciusuario("Silvia","silvia@outlook.com","1313qqeQ%4","1992/10/22");
        acceso.addMiembroEmpresa("starbucks@gmail.com",user);
        Stakeholder miembro1=new Empresa("Tostao","tostao@gmail.com","1231aSAF%$","carrera 8 #109-08","987238756");
        acceso.addMiembroEmpresa("starbucks@gmail.com",miembro1);
        String mostrar=acceso.mostrarMiembrosEmpresa("starbucks@gmail.com");
        assertEquals("Estos son los miembros:\nDatos Biciusuario: \nNombre: Silvia\nEmail: silvia@outlook.com\nFecha de Nacimiento: 1992/10/22\n" +
                "\n\nDatos Empresa:\nNombre: Tostao\nNit: 987238756\nEmail: tostao@gmail.com\nDireccion: carrera 8 #109-08\n\n",mostrar);
    }

    @Test
    void mostrarBiciusuarios() {
    }

    @Test
    void mostrarEmpresas() {
    }

    @Test
    void actualizarNombreEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Postobon","postobon@gmail.com","1231aSAF%$","carrera 8 #109-08","765484356");
        acceso.addEmpresa(empresa);
        acceso.actualizarNombreEmpresa("postobon@gmail.com","Postobon INC.");
        Stakeholder miembro=acceso.buscarEmpresa("postobon@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Postobon INC.postobon@gmail.com1231aSAF%$",name+email+password);
    }

    @Test
    void actualizarEmailEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Coca Cola","cocacola@gmail.com","1231aSAF%$","carrera 8 #109-08","455784356");
        acceso.addEmpresa(empresa);
        acceso.actualizarEmailEmpresa("cocacola@gmail.com","coca2020@gmail.com");
        Stakeholder miembro=acceso.buscarEmpresa("coca2020@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Coca Colacoca2020@gmail.com1231aSAF%$",name+email+password);
    }

    @Test
    void actualizarPasswordEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Zara","zara@gmail.com","1231a56F%$","carrera 10 #109-08","400784356");
        acceso.addEmpresa(empresa);
        acceso.actualizarPasswordEmpresa("zara@gmail.com","1obt5#2QYV");
        Stakeholder miembro=acceso.buscarEmpresa("zara@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Zarazara@gmail.com1obt5#2QYV",name+email+password);
    }

    @Test
    void actualizarDireccionEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("LG","lg@gmail.com","1231b56F%$","carrera 30 #109-08","700784356");
        acceso.addEmpresa(empresa);
        acceso.actualizarDireccionEmpresa("lg@gmail.com","Calle 8 # 34-12");
        Stakeholder miembro=acceso.buscarEmpresa("lg@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String dir=((Empresa)miembro).getDireccion();
        assertEquals("LGlg@gmail.com1231b56F%$Calle 8 # 34-12",name+email+password+dir);
    }

    @Test
    void actualizarNitEmpresa() {
        Master acceso=Master.laConstructora();
        Stakeholder empresa=new Empresa("Xiaomi","xiami@gmail.com","1261a56F%$","carrera 19 #109-08","900784356");
        acceso.addEmpresa(empresa);
        acceso.actualizarNitEmpresa("xiami@gmail.com","987654124");
        Stakeholder miembro=acceso.buscarEmpresa("xiami@gmail.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        String nit=((Empresa)miembro).getNit();
        assertEquals("Xiaomixiami@gmail.com1261a56F%$987654124",name+email+password+nit);
    }

    @Test
    void actualizarNombreBiciusuario() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Eduardo","eduardo@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        acceso.actualizarNombreBiciusuario("eduardo@outlook.com","Eduardo Gomez");
        Stakeholder miembro=acceso.buscarBiciusuario("eduardo@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Eduardo Gomezeduardo@outlook.com123qqeQ%4",name+email+password);
    }

    @Test
    void actualizarEmailBiciusuario() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Odette","odette@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        acceso.actualizarEmailBiciusuario("odette@outlook.com","odette12@outlook.com");
        Stakeholder miembro=acceso.buscarBiciusuario("odette12@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Odetteodette12@outlook.com123qqeQ%4",name+email+password);
    }

    @Test
    void actualizarPasswordBiciusuario() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Jesus","jesus@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        acceso.actualizarPasswordBiciusuario("jesus@outlook.com","76y57#$Q");
        Stakeholder miembro=acceso.buscarBiciusuario("jesus@outlook.com");
        String name=miembro.getNombre();
        String email=miembro.getEmail();
        String password=miembro.getPassword();
        assertEquals("Jesusjesus@outlook.com76y57#$Q",name+email+password);
    }

    @Test
    void mostrarBicicletas() {
        Master acceso=Master.laConstructora();
        String bicis=acceso.mostrarBicicletas("camila@outlook.com");
        assertEquals("Estas son las bicicletas:\n\n\nBicicleta \nSerial: 1234\nMarca: src\nColor: rojo",bicis);
    }

    @Test
    void addViaje() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Josefina","josefina@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        acceso.addViaje("josefina@outlook.com","12345","123.6543","862.234","30min","126 km/h",2);
        Viaje v=acceso.buscarViaje("josefina@outlook.com","12345");
        String code=v.getCodigo();
        String ci=v.getCoordenadasIniciales();
        String cf=v.getCoordenadasFinales();
        String duracion=v.getDuracion();
        String velocidad=v.getVelocidad();
        int arboles=v.getArbolesObtenidos();
        assertEquals("12345123.6543862.23430min2126 km/h",code+ci+cf+duracion+arboles+velocidad);
    }

    @Test
    void addRuta() {
    }

    @Test
    void eliminarRuta() {
        Master acceso=Master.laConstructora();
        Stakeholder user=new Biciusuario("Julia","julia@outlook.com","123qqeQ%4","2002/10/22");
        acceso.addBiciusuario(user);
        acceso.addRuta("julia@outlook.com","116721","8543.1342","87654.132");
        acceso.addRuta("julia@outlook.com","113211","86543.1342","81254.132");
        Ruta rut=acceso.buscarRuta("julia@outlook.com","113211");
        String code=rut.getCodigo();
        String ci=rut.getCoordIniciales();
        String cf=rut.getCoordFinales();
        assertEquals("11321186543.134281254.132",code+ci+cf);
        acceso.eliminarRuta("julia@outlook.com","113211");
        Ruta ru=acceso.buscarRuta("julia@outlook.com","113211");
        if(ru!=null){
            fail("La ruta no se eliminó correctamente!");
        }

    }

    @Test
    void botonPanico() {
    }

    @Test
    void getMessages() {
    }
}