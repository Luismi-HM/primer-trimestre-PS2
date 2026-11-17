package modelo;

public class Actividad {
    int idActividad;
    String nombreActividad;
    double precioMensual;

    public Actividad(int idActividad, String nombreActividad, double precioMensual) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.precioMensual = precioMensual;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public void setPrecioMensual(double precioMensual) {
        this.precioMensual = precioMensual;
    }

    @Override
    public String toString() {
        return nombreActividad;
    }
}
