/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jhesp
 */
public class Voluntario {
    private int idVoluntario;
    private String dni;              // Documento Nacional de Identidad
    private String nombre;
    private String apellido;
    private String telefono;          // Datos de contacto para coordinaciones
    private String especialidad;      // Ej. Pediatría, Enfermería, etc.
    private String disponibilidad;    // Días y horarios disponibles
    private String estado;            // Activo, Asignado o Inactivo
    private int horasServicio;        // Historial de horas de servicio cumplidas

    public Voluntario() {
    }

    public Voluntario(int idVoluntario, String dni, String nombre, String apellido,
            String telefono, String especialidad, String disponibilidad,
            String estado, int horasServicio) {
        this.idVoluntario = idVoluntario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.disponibilidad = disponibilidad;
        this.estado = estado;
        this.horasServicio = horasServicio;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getHorasServicio() {
        return horasServicio;
    }

    public void setHorasServicio(int horasServicio) {
        this.horasServicio = horasServicio;
    }
}
