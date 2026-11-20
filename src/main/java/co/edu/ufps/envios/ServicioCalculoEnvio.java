package co.edu.ufps.envios;

/** Baseline intencional: ramas de tipo, peso, distancia, cliente y temporada mezcladas. */
public class ServicioCalculoEnvio {
    public double calcularCosto(SolicitudEnvio s) {
        double costo = 0;
        if (s.pesoKg() <= 0) throw new IllegalArgumentException("El peso debe ser positivo");
        if (s.tipo() == TipoEnvio.ESTANDAR) {
            costo = 5000 + s.pesoKg() * 300 + s.distanciaKm() * 100;
            if (s.distanciaKm() > 100) costo += 2500;
            if (s.premium()) costo *= 0.95;
            if (s.temporadaAlta()) costo += 3500;
        }
        if (s.tipo() == TipoEnvio.EXPRESS) {
            costo = 9000 + s.pesoKg() * 500 + s.distanciaKm() * 150;
            if (s.distanciaKm() > 100) costo += 6000;
            if (s.pesoKg() > 10) costo += 5000;
            if (s.premium()) costo *= 0.9;
            if (s.temporadaAlta()) costo += 7000;
        }
        if (s.tipo() == TipoEnvio.REFRIGERADO) {
            costo = 12000 + s.pesoKg() * 650 + s.distanciaKm() * 180;
            if (s.distanciaKm() > 100) costo += 8000;
            if (s.fragil()) costo += 3000;
            if (s.premium()) costo *= 0.92;
            if (s.temporadaAlta()) costo += 9000;
        }
        if (s.tipo() == TipoEnvio.INTERNACIONAL) {
            costo = 20000 + s.pesoKg() * 900 + s.distanciaKm() * 250;
            if (s.distanciaKm() > 1000) costo += 18000;
            if (s.fragil()) costo += 5000;
            if (s.temporadaAlta()) costo += 15000;
        }
        return Math.round(costo * 100.0) / 100.0;
    }
}
