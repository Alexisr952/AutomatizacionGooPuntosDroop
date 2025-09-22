package utils;

public class GuiaInfo {
    private final String codigoRemision;
    private final String etiqueta1d;

    public GuiaInfo(String codigoRemision, String etiqueta1d) {
        this.codigoRemision = codigoRemision;
        this.etiqueta1d = etiqueta1d;
    }

    public String getCodigoRemision() {
        return codigoRemision;
    }

    public String getEtiqueta1d() {
        return etiqueta1d;
    }
}


