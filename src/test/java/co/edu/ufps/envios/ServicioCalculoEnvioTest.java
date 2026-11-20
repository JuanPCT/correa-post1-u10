package co.edu.ufps.envios;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class ServicioCalculoEnvioTest {
    private ServicioCalculoEnvio servicio;
    @BeforeEach void setUp(){servicio=new ServicioCalculoEnvio(List.of(new Estandar(),new Express(),new Refrigerado(),new Internacional()));}
    @Test void calculaTarifasBasePorEstrategia(){
        assertEquals(10000,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.ESTANDAR,10,20,false,false,false)));
        assertEquals(17000,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.EXPRESS,10,20,false,false,false)));
        assertEquals(22100,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.REFRIGERADO,10,20,false,false,false)));
        assertEquals(34000,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.INTERNACIONAL,10,20,false,false,false)));
    }
    @Test void aplicaRecargosLimitesYDescuentoPremium(){
        assertEquals(35800,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.ESTANDAR,25,150,true,true,true)));
        assertEquals(52000,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.EXPRESS,15,150,true,true,true)));
        assertEquals(72940,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.REFRIGERADO,20,150,true,true,true)));
        assertEquals(383500,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.INTERNACIONAL,15,1200,true,true,true)));
    }
    @Test void rechazaPesoInvalido(){assertThrows(IllegalArgumentException.class,()->servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.ESTANDAR,0,20,false,false,false)));}
    @Test void reportaTipoSinEstrategia(){
        var incompleto=new ServicioCalculoEnvio(List.of(new Estandar()));
        assertThrows(IllegalArgumentException.class,()->incompleto.calcularCosto(new SolicitudEnvio(TipoEnvio.EXPRESS,5,10,false,false,false)));
    }
}
