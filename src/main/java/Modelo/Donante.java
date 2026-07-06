package Modelo;

public class Donante {
    private int idDonante;
    private String nombre;        // Nombre de la persona o Razón Social de la empresa
    private String tipoDonante;   // Natural o Jurídica
    private String rucDni;       // RUC para empresas o DNI para personas naturales
    private String direccion;
    private String telefono;
    private String correo;

    public Donante() {
    }

    public Donante(int idDonante, String nombre, String tipoDonante, String rucDni,
            String direccion, String telefono, String correo) {
        this.idDonante = idDonante;
        this.nombre = nombre;
        this.tipoDonante = tipoDonante;
        this.rucDni = rucDni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDonante() {
        return tipoDonante;
    }

    public void setTipoDonante(String tipoDonante) {
        this.tipoDonante = tipoDonante;
    }

    public String getRucDni() {
        return rucDni;
    }

    public void setRucDni(String rucDni) {
        this.rucDni = rucDni;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
