package co.edu.ufps.envios;
public class Internacional implements EstrategiaEnvio {
    private final TarifaEnvio tarifa=new TarifaEnvio(20000,900,250,1000,18000,10,12000,5000,1.0,15000);
    public TipoEnvio tipo(){return TipoEnvio.INTERNACIONAL;}
    public double calcular(SolicitudEnvio s){return tarifa.calcular(s);}
}
