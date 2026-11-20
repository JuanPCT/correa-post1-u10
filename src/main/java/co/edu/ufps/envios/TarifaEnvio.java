package co.edu.ufps.envios;
record TarifaEnvio(double base,double porKg,double porKm,double umbralDistancia,double adicionalDistancia,
                   double umbralPeso,double adicionalPeso,double adicionalFragil,double factorPremium,double adicionalTemporada){
    double calcular(SolicitudEnvio s){
        double costo=base+s.pesoKg()*porKg+s.distanciaKm()*porKm;
        if(s.distanciaKm()>umbralDistancia)costo+=adicionalDistancia;
        if(s.pesoKg()>umbralPeso)costo+=adicionalPeso;
        if(s.fragil())costo+=adicionalFragil;
        if(s.premium())costo*=factorPremium;
        if(s.temporadaAlta())costo+=adicionalTemporada;
        return Math.round(costo*100.0)/100.0;
    }
}
