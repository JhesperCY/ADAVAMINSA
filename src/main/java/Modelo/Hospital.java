package Modelo;

public class Hospital {
    private int idHospital;
    private String nombre;        // Nombre del hospital o centro de salud
    private String direccion;     // Ubicación física para la asistencia
    private String telefono;      // Contacto para coordinar la llegada del voluntario
    private String redSalud;      // Red o micro-red del MINSA a la que pertenece

    public Hospital() {
    }

    public Hospital(int idHospital, String nombre, String direccion, String telefono, String redSalud) {
        this.idHospital = idHospital;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.redSalud = redSalud;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRedSalud() {
        return redSalud;
    }

    public void setRedSalud(String redSalud) {
        this.redSalud = redSalud;
    }
}
