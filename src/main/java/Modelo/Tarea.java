package Modelo;

public class Tarea {
    private int idTarea;
    private int idVoluntario;   // Vínculo con el voluntario asignado
    private int idHospital;     // Vínculo con el hospital del MINSA solicitante
    private String fecha;       // Fecha programada para la labor
    private String hora;        // Hora de inicio de la actividad
    private String descripcion; // Detalle de la labor asistencial a realizar
    private String estado;      // Pendiente o Finalizada

    public Tarea() {
    }

    public Tarea(int idTarea, int idVoluntario, int idHospital, String fecha,
            String hora, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.idVoluntario = idVoluntario;
        this.idHospital = idHospital;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
