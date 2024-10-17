/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.vista;

import java.util.ArrayList;
import practica.uva.ipc.practica2.main.Main;
import practica.uva.ipc.practica2.modelo.Libro;
import practica.uva.ipc.practica2.modelo.Biblioteca;

/**
 * Clase Controlador que maneja las solicitudes del usuario de la vista de edición
 * y envía la respuesta adecuada a la vista.
 * 
 * @author Alejandra Gavino-Dias
 * @author Sara Aparicio Fernandez
 */
public class ControladorEdicion {
    
    private final VistaEdicion vista;
    private final Biblioteca modelo;
    
    private boolean editar = false;
    private boolean estadoEditar = false;
    private Libro libro;
   
    /**
    * Crea un nuevo controlador, asociado con el modelo, muestra el posible contenido de la biblioteca y si
    * hay algún libro seleccionado del modelo (proveniente de la vista búsqueda), se muestran los campos.
    * @param vista La vista de edición asociada con este controlador.
    */
    public ControladorEdicion(VistaEdicion vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
        muestraHistorial();
        if(modelo.getSeleccionado()!=null){
            mostrarDatosSeleccionado();
        }
    }
    
    /**
     * Procesa la acción de guardar un libro, comprueba si el libro existe en la biblioteca
     * y si no existe lo añade y reinicia los campos de la vista..
     */
    public void procesarGuardar(){
        vista.mostrarMensaje("");
  
        if(comprobaDatos()){
            if(editar){ /*Si es true es porque estoy guardando un libro que estoy editando */
                    modelo.removeLibroHistorial(getLibroEditando());
                    anadirLibro();
                    vista.mostrarDatos("", "", "","Malo", 0.00, false);
                    vista.isbnEditable(true);
                    editar = false;
            }else{
                boolean existeLibro = false;
                   
                for(Libro l : modelo.getHistorial()){
                    if(l.getIsbn().equals(this.vista.getIsbn())){
                        this.vista.mostrarMensaje("<html><p>El libro tiene un isbn que ya esta presente en la lista</p></html>");
                        existeLibro = true;
                    }
                }
                if(!existeLibro){
                    anadirLibro();
                    vista.mostrarDatos("", "", "","Malo", 0.00, false);
                }
            }
            modelo.setSeleccionado(null);
        }
    }
    
    /**
     * Comprueba si los datos del libro escritos por el usuario son correctos.
     * @return true si son correctos, false si no lo son
     */
    public boolean comprobaDatos(){
 
        String titulo = this.vista.getTitulo();
        if(titulo.length()< 1 || titulo.length()> 20){
            this.vista.mostrarMensaje("<html><p>El titulo debe tener entre 1 y 20 caracteres</p></html>");
            return false;
        } 
         
        String isbn = this.vista.getIsbn();
        if(isbn.length()< 1 || isbn.length()> 13){
            this.vista.mostrarMensaje("<html><p>El isbn debe tener entre 1 y 13 caracteres</p></html>");
            return false;
        } 
        
        if(!isNumeric(isbn)){
            this.vista.mostrarMensaje("<html><p>El isbn debe tener unicamente caracteres numericos</p></html>");
            return false;
        }
        
        if(this.vista.getEuros() == 0 && this.vista.getCentimos() == 0){
            this.vista.mostrarMensaje("<html><p>El precio tiene que ser mayor de 0.00 €</p></html>");
            return false;
        }
        return true;
    }
    
    /**
     * Añade el libro a la biblioteca, lo muestra en el listado de la vista
     * y reinicia los campos de la vista.
     */
    public void anadirLibro(){
        String descripcion = vista.getDescripcion();
        String estado = vista.getEstado();
        double precio = vista.getEuros() + vista.getCentimos()*0.01;
        boolean leido = vista.getLeido();
                
        Libro libro = new Libro(this.vista.getTitulo(), descripcion, this.vista.getIsbn(), precio, estado, leido);
               
        modelo.addLibroHistorial(libro);
        muestraHistorial();
        vista.mostrarDatos("", "", "","Malo", 0.00, false);
        vista.mostrarMensaje("");
    }
    
    /**
     * Muestra el titulo y el isbn de los libros guardados en la biblioteca.
     */
    public void muestraHistorial() {
        ArrayList <Libro> libros = modelo.getHistorial();
        String[] array;
        array = new String[libros.size()];
        int i = 0;
        for (Libro libro : libros) {
            array[i]=("Titulo:" +libro.getTitulo() + " ISBN:" + libro.getIsbn());
            i++;
        }        
        vista.actualizarHistorial(array);
    }
    
    /**
     * Procesa la accion de editar un libro y actualiza el historial con los nuevos datos
     * a mostrar del libro.
     */
    public void procesarEditar(){
        modelo.setSeleccionado(null);
        vista.mostrarMensaje("");
        String seleccionado = vista.libroSelecionado();
        
        if(seleccionado == null){
            this.vista.mostrarMensaje("<html><p>No hay ningún libro seleccionado en la lista</p></html>");
        }else{
            vista.isbnEditable(false);
            
            String[] datos = seleccionado.split("ISBN:");
            for(Libro libro : modelo.getHistorial()){
                if(libro.getIsbn().equals(datos[1])){
                    vista.mostrarDatos(libro.getTitulo(), libro.getDescripcion(), libro.getIsbn(), 
                            libro.getEstado(), libro.getPrecio(), libro.getLeido());
                    setLibroEditando(libro);
                    editar = true;
                }
            }
        }
    }
        
    /**
     * Procesa la accion de borrar un libro de la lista y actualiza el historial 
     * de libros que se muestra al usuario.
     */
    public void procesarBorrar(){
        vista.mostrarMensaje("");
        String seleccionado = vista.libroSelecionado();
        
        if(seleccionado == null){
            this.vista.mostrarMensaje("<html><p>No hay ningun libro seleccionado en la lista</p></html>");  
        }else{
            String[] datos = seleccionado.split("ISBN:");
            Libro libroBorrar = null;
            for(Libro libro : modelo.getHistorial()){
                if(libro.getIsbn().equals(datos[1])){
                    libroBorrar=libro;
                }
            }
           modelo.removeLibroHistorial(libroBorrar);
           muestraHistorial();
           vista.mostrarMensaje("");
           limpiarCasillas();
        }
        modelo.setSeleccionado(null);
    }
    
    /**
     * Guarda el libro que se esta editando.
     * @param libro, true si el libro se esta editando y false en caso contrario
     */
    public void setLibroEditando(Libro libro){
        this.libro = libro;
    }
    
    /**
     * Metodo que devuelve el libro que se esta editando.
     * @return libro, libro que se esta editando
     */
    public Libro getLibroEditando(){
        return libro;
    }
    
    /**
     * Metodo que suma los euros y centimos del precio para obtener el precio final.
     * @return precio, pecio del libro
     */
    public double sumaPrecio(){
        double precio = vista.getEuros() + ((double) vista.getCentimos() / 100.0);
        return precio;
    }
 
    /**
     * Metodo que comprueba que la cadena de caracteres de ISBN es numerica.
     * @param num, numero que se quiere comprobar
     * @return true si es numerica y en caso contrario false
     */
    public boolean isNumeric(String num){
        if(num == null){
            return false;
        }
        try{
            double d = Double.parseDouble(num);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    /**
     * Metodo que cambia el estado de edicion a false.
     */
    public void setEditarFalse(){
        editar = false;
    }
    
    /**
     * Metodo que muesta los datos del libro seleccionado en el historia.
     */
    public void mostrarDatosLibro(){
        vista.mostrarMensaje("");
        String seleccionado = vista.libroSelecionado();
        
        if(seleccionado == null){
            this.vista.mostrarMensaje("<html><p>No hay ningun libro seleccionado en la lista</p></html>");
        }else{
            String[] datos = seleccionado.split("ISBN:");

            for(Libro libro : modelo.getHistorial()){
                if(libro.getIsbn().equals(datos[1])){
                    vista.mostrarDatos(libro.getTitulo(), libro.getDescripcion(), libro.getIsbn(), 
                            libro.getEstado(), libro.getPrecio(), libro.getLeido());
                }
            }
        }
    }
    
    /**
     * Limpia los campos de la vista.
     */
    public void limpiarCasillas(){
        if(getEstadoEditar()){
            vista.mostrarMensaje("guarde o cancele la edición del libro actual");
        }else{
            vista.mostrarMensaje("");
            vista.mostrarDatos("","","","Malo",0.0,false);
        }
    }
    
    /**
     * Procesa la accion de volver al menú principal.
     */
    public void procesarMenu(){
        modelo.setSeleccionado(null);
        vista.mostrarMensaje("");
        vista.mostrarDatos("","","","Malo",0.0,false);
        Main.getGestorVistas().mostrarVistaMenu();
    }
    
    /**
     * establece el estado de edición.
     * @param estado boolean. 
     */
    public void setEstadoEditar(boolean estado){
        this.estadoEditar = editar;
    }
    
    /**
     * Devuelve el estado de edición.
     * @return estado de la edición.
     */
    public boolean getEstadoEditar(){
        return estadoEditar;
    }
    
    /**
     * Muestra los datos del libro seleccionado de la biblioteca, enviado por la vista búsqueda,
     * para su edición.
     */
    public void mostrarDatosSeleccionado(){
        
        String seleccionado = modelo.getSeleccionado();
        
        if(seleccionado == null){
            this.vista.mostrarMensaje("<html><p>No hay ningún libro seleccionado en la lista</p></html>");
        }else{
            vista.isbnEditable(false);
            
            String[] datos = seleccionado.split("ISBN:");
            for(Libro libro : modelo.getHistorial()){
                if(libro.getIsbn().equals(datos[1])){
                    vista.mostrarDatos(libro.getTitulo(), libro.getDescripcion(), libro.getIsbn(), 
                            libro.getEstado(), libro.getPrecio(), libro.getLeido());
                    setLibroEditando(libro);
                    editar = true;
                }
            }
        }
    }   
}
