package co.edu.ufps.envios;
public class Estandar implements EstrategiaEnvio {
    private final TarifaEnvio tarifa=new TarifaEnvio(5000,300,100,100,2500,20,4000,0,0.95,3500);
    public TipoEnvio tipo(){return TipoEnvio.ESTANDAR;}
    public double calcular(SolicitudEnvio s){return tarifa.calcular(s);}
}
