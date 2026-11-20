package co.edu.ufps.envios;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ServicioCalculoEnvioTest {
    private final ServicioCalculoEnvio servicio=new ServicioCalculoEnvio();
    @Test void calculaTarifaEstandar(){assertEquals(10000.0,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.ESTANDAR,10,20,false,false,false)));}
    @Test void calculaTarifaExpress(){assertEquals(17000.0,servicio.calcularCosto(new SolicitudEnvio(TipoEnvio.EXPRESS,10,20,false,false,false)));}
}
