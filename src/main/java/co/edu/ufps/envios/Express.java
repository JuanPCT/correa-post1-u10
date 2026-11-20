package co.edu.ufps.envios;
public class Express implements EstrategiaEnvio {
    private final TarifaEnvio tarifa=new TarifaEnvio(9000,500,150,100,6000,10,5000,0,0.9,7000);
    public TipoEnvio tipo(){return TipoEnvio.EXPRESS;}
    public double calcular(SolicitudEnvio s){return tarifa.calcular(s);}
}
