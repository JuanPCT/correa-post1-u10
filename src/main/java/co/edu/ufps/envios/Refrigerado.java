package co.edu.ufps.envios;
public class Refrigerado implements EstrategiaEnvio {
    private final TarifaEnvio tarifa=new TarifaEnvio(12000,650,180,100,8000,15,6500,3000,0.92,9000);
    public TipoEnvio tipo(){return TipoEnvio.REFRIGERADO;}
    public double calcular(SolicitudEnvio s){return tarifa.calcular(s);}
}
