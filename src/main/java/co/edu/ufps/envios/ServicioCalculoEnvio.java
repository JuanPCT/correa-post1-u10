package co.edu.ufps.envios;
import java.util.*;
public class ServicioCalculoEnvio {
    private final Map<TipoEnvio,EstrategiaEnvio> estrategias;
    public ServicioCalculoEnvio(List<EstrategiaEnvio> disponibles){
        estrategias=new EnumMap<>(TipoEnvio.class);
        disponibles.forEach(e->estrategias.put(e.tipo(),e));
    }
    public double calcularCosto(SolicitudEnvio solicitud){
        if(solicitud.pesoKg()<=0) throw new IllegalArgumentException("El peso debe ser positivo");
        EstrategiaEnvio estrategia=estrategias.get(solicitud.tipo());
        if(estrategia==null) throw new IllegalArgumentException("Tipo de envío sin tarifa: "+solicitud.tipo());
        return estrategia.calcular(solicitud);
    }
}
