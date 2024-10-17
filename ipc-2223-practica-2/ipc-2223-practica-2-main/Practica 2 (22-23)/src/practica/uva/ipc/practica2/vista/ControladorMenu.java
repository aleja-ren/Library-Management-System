/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.vista;

import practica.uva.ipc.practica2.main.Main;
import practica.uva.ipc.practica2.modelo.Libro;
import practica.uva.ipc.practica2.modelo.Biblioteca;


/**
 * Clase Controlador que maneja las solicitudes del usuario de la vista del menú
 * y envía la respuesta adecuada a la vista.
 * 
 * @author Sara Aparicio
 * @author Alejandra Gavino-Dias
 */
public class ControladorMenu {
    
    private VistaMenu vista;
    private Biblioteca modelo;
    private int libroLeido;
    private int libroNoLeido;
    
   /**
    * Crea un nuevo controlador, asociado con el modelo, calcula los datos de los libros 
    * actuales de la biblioteca y los muestra.
    * 
    * @param vista La vista del menú asociada con este controlador.
    */
    public ControladorMenu(VistaMenu vista) {
        this.vista = vista;
        this.modelo = new Biblioteca();
        calcularDatos();
    }
    
    /**
     * Muestra el icono de la biblioteca en la vista.
     */
    public void Imagen(){
        vista.setImagenBiblioteca("src\\practica\\uva\\ipc\\practica2\\imagenes\\biblioteca.png");
    }
    
    /**
     * Procesa la acción de elegir la opción de edición manual de los libros.
     */
    public void procesarEdicion(){
        Main.getGestorVistas().mostrarVistaEdicion();
    }
    
    /**
     * Procesa la acción de elegir la opción de búsqueda de los libros.
     */
    public void procesarBusqueda(){
        Main.getGestorVistas().mostrarVistaBusqueda();
    }
    
    /**
     * Calcula los datos de la biblioteca actual: el número de libros leídos, los no leídos,
     * el número total de libros y el precio medio de la biblioteca.
     */
    public void calcularDatos(){
        int libroLeido = 0;
        int libroNoLeido = 0;
        double precioMedio = 0;
        for(Libro libro:modelo.getHistorial()){
            precioMedio = precioMedio+libro.getPrecio();
            if(libro.getLeido()){
                libroLeido++;
            }else{
                libroNoLeido++;
            }
        }
        precioMedio=precioMedio/(libroLeido+libroNoLeido);
        double redondeo = Math.round(precioMedio * 100.0)/100.0;
        
        vista.mostrarNumeroTotal(libroLeido+libroNoLeido);
        vista.mostrarNumeroLeidos(libroLeido);
        vista.mostrarNumeroNoLeidos(libroNoLeido);
        vista.mostrarPrecioMedio(redondeo);
    }
}
