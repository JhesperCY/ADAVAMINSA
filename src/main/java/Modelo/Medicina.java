package Modelo;

public class Medicina {
    private int idMedicina;
    private String nombre;           // Nombre del fármaco
    private String lote;             // Número de lote para trazabilidad
    private String fechaVencimiento; // Crítico para alertas de caducidad
    private int cantidad;            // Stock disponible en almacén
    private String categoria;        // Ej. Antibióticos, Material Quirúrgico, etc.

    public Medicina() {
    }

    public Medicina(int idMedicina, String nombre, String lote, String fechaVencimiento, int cantidad, String categoria) {
        this.idMedicina = idMedicina;
        this.nombre = nombre;
        this.lote = lote;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public int getIdMedicina() {
        return idMedicina;
    }

    public void setIdMedicina(int idMedicina) {
        this.idMedicina = idMedicina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
