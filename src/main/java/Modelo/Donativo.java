package Modelo;

public class Donativo {
    private int idDonativo;
    private int idDonante;      // Relación con la entidad Donante
    private int idMedicina;     // Relación con la entidad Medicina
    private String fecha;       // Fecha de recepción del donativo
    private int cantidad;       // Cantidad ingresada según el acta de recepción
    private String observaciones; // Detalles adicionales del ingreso

    public Donativo() {
    }

    public Donativo(int idDonativo, int idDonante, int idMedicina, String fecha, int cantidad, String observaciones) {
        this.idDonativo = idDonativo;
        this.idDonante = idDonante;
        this.idMedicina = idMedicina;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }

    public int getIdDonativo() {
        return idDonativo;
    }

    public void setIdDonativo(int idDonativo) {
        this.idDonativo = idDonativo;
    }

    public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public int getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(int idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
