/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.modelo;

import java.util.ArrayList;

/**
 * Biblioteca que contiene todos los libros de la aplicación.
 * @author Alejandra Gavino-Dias
 * @author Sara Aparicio Fernandez
 */
public class Biblioteca {
    
    private ArrayList<Libro> historial;
    private double resultado;
    private String seleccionado;
    
    /**
     * Contructor de la clase biblioteca.
     */
    public Biblioteca() {
        historial = new ArrayList<>();
        datosBiblioteca();
    }
    
    /**
     * Devuelve los libros de la biblioteca.
     * @return 
     */
    public ArrayList<Libro> getHistorial() {
        return this.historial;
    }
    
    /**
     * Establece los libros de la biblioteca.
     * @param historial 
     */
    public void setHistorial(ArrayList<Libro> historial){
        this.historial = historial;
    }
    
    /**
     * Añade un libro a la biblioteca.
     * @param libro, libro que se desea anadir
     */
    public void addLibroHistorial(Libro libro) {
        //tenemos que hacer aqui la validacion de los datos
        this.historial.add(libro);
    }
    
    /**
     * Elimina un libro de la biblioteca.
     * @param libro, libro que se desea eliminar
     */
    public void removeLibroHistorial(Libro libro){
        this.historial.remove(libro);
    }
    
    /**
     * Libros iniciales que hemos creado de la biblioteca.
     */
    public void datosBiblioteca(){
        Libro libro = new Libro("El Rey Leon","libro infantil sobre leones","1234",5.50,"bueno",true);
        Libro libro2 = new Libro("El mago de oz","libro de fantasia","8765",8.40,"regular",false);
        Libro libro3 = new Libro("Don Quijote","libro clasico","3334",3.70,"regular",true);
        addLibroHistorial(libro);
        addLibroHistorial(libro2);
        addLibroHistorial(libro3);
    }
    
    /**
     * Vacía el contenido de la biblioteca eliminando todos los libros.
     */
    public void vaciarHistorial(){
        this.historial.clear();
    }
    
    /**
     * Devuelve un libro seleccionado.
     * @return seleccionado, libro seleccionado
     */
    public String getSeleccionado(){
        return seleccionado;
    }
    
    /**
     * Almacena un libro seleccionado.
     * @param seleccionado libro a almacenar.
     */
    public void setSeleccionado(String seleccionado){
        this.seleccionado = seleccionado;
    }


}
