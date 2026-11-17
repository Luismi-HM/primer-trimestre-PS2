package modelo;

public class Socio {
    int idSocio;
    String nombre;
    String apellido;
    String dni;
    String fechaAlta;

    public Socio(int idSocio, String nombre, String apellido, String dni, String fechaAlta) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
