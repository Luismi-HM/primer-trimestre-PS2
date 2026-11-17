package modelo;

public class Inscripcion {
    String nombreSocio;
    String nombreActividad;
    boolean pagoAlDia;

    public Inscripcion(String nombreSocio, String nombreActividad, boolean pagoAlDia) {
        this.nombreSocio = nombreSocio;
        this.nombreActividad = nombreActividad;
        this.pagoAlDia = pagoAlDia;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public boolean isPagoAlDia() {
        return pagoAlDia;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setPagoAlDia(boolean pagoAlDia) {
        this.pagoAlDia = pagoAlDia;
    }
}
