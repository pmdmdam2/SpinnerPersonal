package com.example.ilm.spinnerpersonal.datamodel;

/**
 * Clase ciudad para los elementos de a lista
 * @author Rafa
 * @version 1.0
 */
public class Ciudad {
    //nombre de la ciudad
    private String nombre;
    //descripción de la ciudad
    private String descripcion;
    //número de habitantes
    private int habitantes;
    //imagen asociada a la ciudad
    private int imagen;

    /**
     * Constructor de ciudades a partir de su nombre, descripción, habitantes e imagen
     * @param nombre Nombre de la ciudad
     * @param descripcion Descripción de la ciudad
     * @param habitantes Número de habitantes
     * @param imagen Imagen representativa de la ciudad
     */
    public Ciudad(String nombre, String descripcion, int habitantes, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habitantes = habitantes;
        this.imagen = imagen;
    }
    //getters y setters para propiedades
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
