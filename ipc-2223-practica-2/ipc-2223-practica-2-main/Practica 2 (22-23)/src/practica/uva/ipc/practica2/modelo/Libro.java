/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.modelo;

/**
 * Clase que modela el objeto libro, perteneciente a la biblioteca.
 * 
 * @author Alejandra Gavino-Dias
 * @author Sara Aparicio Fernandez
 */
public class Libro {
    private String titulo;
    private String descripcion;
    private String isbn;
    private double precio;
    private String estado;
    private boolean leido;
    
    /**
     * Constructor de la clase libro
     * @param titulo, titulo del libro
     * @param descripcion, descripcion del libro
     * @param isbn, isbn del libro
     * @param estado, estado del libro
     * @param precio, precio del libro
     * @param leido , true si se ha leido el libro o false en caso contrario
     */
    public Libro(String titulo, String descripcion, String isbn, double precio, String estado, boolean leido){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.isbn=isbn;
        this.precio=precio;
        this.estado=estado;
        this.leido=leido;
    }
    
    /**
     * Devuelve el tútlo de un libro.
     * @return titulo del libro
     */
    public String getTitulo(){
        return titulo;
    }

    /**
     * Devuelve la descripción de un libro.
     * @return descripcion del libro
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el ISBN de un libro.
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Devuelve el precio de un libro.
     * @return precio del libro
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Devuelve la valoración de un libro.
     * @return valoracion del libro 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Devuelve el estado de un libro, si se ha leído o no.
     * @return true si se ha leido y false en caso contrario
     */
    public boolean getLeido() {
        return leido;
    }
    
    /**
     * Guarda el titulo del libro
     * @param titulo, titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Guarda la descripcion del libro
     * @param descripcion, descripcion del libro
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Guarda el isbn del libro
     * @param isbn, isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Guarda el precio del libro
     * @param precio, precio del libro
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Guarda la opinion del libro
     * @param estado, opinion del libro
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Guarda si se ha leido o no el libro
     * @param leido, true si se ha leido el libro y false en caso contrario
     */
    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
