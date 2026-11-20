package co.edu.ufps.envios;
public record SolicitudEnvio(TipoEnvio tipo, double pesoKg, double distanciaKm,
                             boolean fragil, boolean premium, boolean temporadaAlta) { }
