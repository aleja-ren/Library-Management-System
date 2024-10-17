/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import practica.uva.ipc.practica2.main.Main;
import practica.uva.ipc.practica2.modelo.Libro;
import practica.uva.ipc.practica2.modelo.Biblioteca;


/**
 * Clase Controlador que maneja las solicitudes del usuario de la vista de búsqueda
 * y envía la respuesta adecuada a la vista.
 * @author Sara Aparicio
 * @author Alejandra Gavino-Dias
 */
public class ControladorBusqueda {
    
    private VistaBusqueda vista;
    private Biblioteca modelo;
    ArrayList<Libro> historialAux;
    int tipoOrdenar; // tipoOrdenar = 1 es ordenarPrecio, si es = 2 ordenarTitulo, si es = 0 ninguno seleccionado
    int tipoBuscar;  // tipoOBuscar = 1 es BuscarTitulo, si es = 2 buscarIsbn, si es = 0 ninguno seleccionado
            
   /**
    * Crea un nuevo controlador, asociado con el modelo y finalmente muestra el posible contenido de la biblioteca.
    * @param vista La vista de búsqueda asociada con este controlador.
    */
    public ControladorBusqueda(VistaBusqueda vista) {
        this.vista = vista;
        this.modelo = Main.getModelo();
        muestraHistorial();
        setHistorialAux(modelo.getHistorial());
        tipoOrdenar = 0;
        tipoBuscar = 0;
    }
    
    /**
     * Procesa la accion de volver al menú principal.
     */
    public void procesarVolverMenu(){
        Main.getGestorVistas().mostrarVistaMenu();
    }
    
    /**
     * Procesa la acción de editar un libro desde la vista de búsqueda, se debe abrir
     * la vista de edición manual con los datos del libro elegido.
     */
    public void procesarEditar(){
        //tengo que coger el libro seleccionado y mostrar los datos de este
        String seleccionado = vista.libroSelecionado();
        
        if(seleccionado!=null){
            //aqui tengo que hacer que en la otra vista muestre los datos del libro
            modelo.setSeleccionado(seleccionado);
        }
        Main.getGestorVistas().mostrarVistaEdicion();
        
    }

    /**
     * Procesa la acción de exportar los datos de la biblioteca, se puede exportar la biblioteca completa
     * o la biblioteca "reducida" con los libros resultantes del filtrado o búsqueda que se haya hecho, para
     * escoger esta segunda opción, solo si se ha reducido se mostrará un JOptionPane dando a elegir,
     * si el fichero se ha generado correctamente se mostrará otro JOptionPane notificando al usuario.
     */
    public void procesarGenerarFichero() {
        //si la lista obtenida del list es menor que el modelo.getHistorial()
        //quiere decir que se ha aplicado algún filtro
        ArrayList<String> listaLibros = vista.getLista();
        int opcion = 0;
        if(listaLibros.size()!=modelo.getHistorial().size()){
            String[] botones = {"Completa", "Resultado filtrado/búsqueda"};
            opcion = JOptionPane.showOptionDialog(null, "¿Quieres descargar la biblioteca completa \n o el resultado del filtrado/búsqueda?", "Generar fichero", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        }
        File dir = null;

        JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            dir = fc.getSelectedFile();
        }
        if(dir==null){
            JOptionPane.showConfirmDialog(null, "El fichero no se ha podido guardar", "Guardar libros", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }else{
            File file = new File(dir, "biblioteca.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(file);
                //aqui en vez de escribir esto tengo que coger todos los datos de los libros y ponerles
                if(opcion==0){
                    //lo quiero completo
                    for(Libro libro : modelo.getHistorial()){
                        fw.write(libro.getTitulo()+";"+libro.getDescripcion()+";"+libro.getIsbn()+";"+libro.getEstado()+";"+libro.getPrecio()+";"+libro.getLeido()+"\r\n");
                    }
                }else{
                    //no lo quiero completo, lo que hago es coger de la lista
                    //en listaLibros tengo Strings, tengo que buscar de cada String el libro al que corresponde
                    for(String cadena:listaLibros){
                        String[] datos = cadena.split("ISBN:");
                        for(Libro libro : modelo.getHistorial()){
                            if(libro.getIsbn().equals(datos[1])){
                                //ahora que tengo el libro seleccionado le tengo que escribir en el fichero
                                fw.write(libro.getTitulo()+";"+libro.getDescripcion()+";"+libro.getIsbn()+";"+libro.getEstado()+";"+libro.getPrecio()+";"+libro.getLeido()+"\r\n");
                            }
                        }
                    }
                }
                fw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if(fw != null) {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                    }
                }
                JOptionPane.showConfirmDialog(null, "Fichero generado correctamente en: "+dir, "Guardar libros", JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
    /**
     * Procesa la acción de buscar en el listado de libros por el campo del ISBN, solo se mostrarán
     * aquellos que contengan los números a buscar.
     */
    public void procesarBusquedaIsbn() {
        tipoBuscar = 2;
        //necesitamos coger el termino que estamos buscando
        String isbn = vista.getTextoBusqueda();
        if(isbn.length() == 0){
            this.vista.mostrarMensaje("<html><p>No hay ningún término de búsqueda</p></html>");
        }else{
            String[] datos;
            datos = new String[modelo.getHistorial().size()];
            ArrayList<Libro> historial = new ArrayList<>();
            int i = 0;
            for(Libro libro : modelo.getHistorial()){
                if(libro.getIsbn().contains(isbn)){
                    datos[i]=("Titulo:" +libro.getTitulo() +" Precio:" +libro.getPrecio() +" ISBN:" + libro.getIsbn());
                    historial.add(libro);
                    i++;
                }
            }
            if(i == 0){
                this.vista.mostrarMensaje("<html><p>No hay ningún libro que contenga el término de búsqueda</p></html>");
            }
            setHistorialAux(historial);
            
            if(tipoOrdenar == 1){
                procesarOrdenarPrecio();
            }else if(tipoOrdenar == 2){
                procesarOrdenarTitulo();
            }else{
                vista.actualizarLista(datos);
            }           
        }
    }
    
    /**
     * Procesa la acción de buscar en el listado de libros por el campo del título, solo se mostrarán
     * aquellos que contengan la cadena a buscar.
     */
    public void procesarBusquedaTitulo() {
        tipoBuscar = 1;
        String titulo = vista.getTextoBusqueda();
        if(titulo.length() == 0){
            this.vista.mostrarMensaje("<html><p>No hay ningún término de búsqueda</p></html>");
        }else{
            String[] datos;
            datos = new String[modelo.getHistorial().size()];
            ArrayList<Libro> historial = new ArrayList<>();
            int i = 0;
            for(Libro libro : modelo.getHistorial()){
                if(libro.getTitulo().contains(titulo)){
                    datos[i]=("Titulo:" +libro.getTitulo() +" Precio:" +libro.getPrecio() +" ISBN:" + libro.getIsbn());
                    historial.add(libro);
                    i++;
                }
            }
            if(i == 0){
                this.vista.mostrarMensaje("<html><p>No hay ningún libro que contenga el término de búsqueda</p></html>");
            }
            setHistorialAux(historial);
            if(tipoOrdenar == 1){
                procesarOrdenarPrecio();
            }else if(tipoOrdenar == 2){
                procesarOrdenarTitulo();
            }else{
                vista.actualizarLista(datos);    
            }
        }
    }
    
    /**
     * Procesa la acción de ordenar el listado de libros por el campo del título, 
     * se mostrará el listado ordenado.
     */
    public void procesarOrdenarTitulo() {
        tipoOrdenar = 2;
        
        //lo primero que hacemos es ordenar el arraylist
        ArrayList<Libro> historial = getHistorialAux();
        Collections.sort(historial, (libro1,libro2)->libro1.getTitulo().compareTo(libro2.getTitulo()));

        String[] datos;
            datos = new String[historial.size()];
            int i = 0;
            for(Libro libro : historial){
                datos[i]=("Titulo:" +libro.getTitulo() +" Precio:" +libro.getPrecio() +" ISBN:" + libro.getIsbn());
                i++;
            }
        vista.actualizarLista(datos);
        /*
        sort tiene dos params, el primero es la lista que queremos ordenar
        y el segundo es de tipo Comparator, pero como estamos ordenando objetos
        hemos usado una expresion lambda que hace lo siguiente:
        comparamos con compare to el atributo titulo de los libros 1 y 2
        */
    }
    
    /**
     * Procesa la acción de ordenar el listado de libros por el campo del ISBN, 
     * se mostrará el listado ordenado.
     */
    public void procesarOrdenarPrecio() {
        tipoOrdenar = 1;
        ArrayList<Libro> historial = getHistorialAux();
        //con la expresion lambda primero libro2 y luego libro1 lo ordenaremos de mayor a menor precio
        Collections.sort(historial, (libro1, libro2)->Double.compare(libro2.getPrecio(), libro1.getPrecio()));
        
        String[] datos;
        datos = new String[historial.size()];
        int i = 0;
        for(Libro libro : historial){
            datos[i]=("Titulo:" +libro.getTitulo() +" Precio:" +libro.getPrecio() +" ISBN:" + libro.getIsbn());
            i++;
        }
        vista.actualizarLista(datos);
    }
    
    /**
     * Muestra en la lista los libros que contiene la biblioteca.
     */
    private void muestraHistorial() {
        String[] datos;
        datos = new String[modelo.getHistorial().size()];
        int i = 0; 
        for(Libro libro : modelo.getHistorial()){
            datos[i]=("Titulo:" +libro.getTitulo() +" Precio:" +libro.getPrecio() +" ISBN:" + libro.getIsbn());
            i++;
        }
        vista.actualizarLista(datos);
    }
    
    /**
     * Procesa la acción de importar un fichero con libros a la biblioteca, se puede sustituir o añadir los
     * libros a la biblioteca, para dar a elegir entre estas dos opciones, junto con un checkbox, se mostrará
     * un JOptionPane en caso de que se quiera reemplazar la biblioteca para asegurarse de su elección.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void procesarCargar() throws FileNotFoundException, IOException {
        boolean sustituir = vista.getValorSustituir();
        int libroRepe = 0;
        boolean repetido = false;
        
        //si lo que queremos es sutituir la biblioteca tenemos que vaciar el modelo
        if(sustituir){
            String[] botones = {"Sí", "No"};
            int opcion = JOptionPane.showOptionDialog(null, "¿Quieres sustituir la biblioteca actual? \n No podrás recuperar los libros que reemplaces", "Sustituir biblioteca", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
            if(opcion==0){
                //se quiere vaciar el modelo
                modelo.vaciarHistorial();
            }
        }
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
            //dialogo de la ventana para seleccionar los archivos
            fileChooser.setDialogTitle("Elige un archivo para cargar los libros: ");

            //filtro para mostrar solo ficheros txt
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                // Obtener el archivo seleccionado
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                System.out.println(selectedFile.getAbsolutePath());

                //una vez esta seleccionado ya el archivo hay que comprobar que el formato es correcto
                FileReader fileReader = new FileReader(filePath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linea;
                while((linea = bufferedReader.readLine()) != null){
                    //System.out.println(linea);
                    //comprobacion de la la linea
                    String[] datos=linea.split(";");
                    if(datos.length != 6){
                        //numero de trozos incorrecto
                        this.vista.mostrarMensaje("<html><p>El fichero no tiene un formato correcto</p></html>");
                    }else if(comprobarTrozos(datos)){
                        //si alguna de las partes es null -> incorrecto
                        this.vista.mostrarMensaje("<html><p>El fichero no tiene un formato correcto</p></html>");
                    }else{
                        //aqui es correcto
                        //título;descripción;isbn;estado;precio;leído
                        String titulo = datos[0];
                        String descripcion = datos[1];
                        String isbn = datos[2];
                        isbn = isbn.replace("-", "");
                        String estado = datos[3];
                        double precio = Double.parseDouble(datos[4]);
                        boolean leido = Boolean.parseBoolean(datos[5]);
                        Libro libro = new Libro(titulo, descripcion, isbn, precio, estado, leido);
                        
                        int tam = modelo.getHistorial().size();
                        
                        for(int i=0; i<tam-1; i++){
                            Libro libro1 = modelo.getHistorial().get(i);
                            if(libro1.getIsbn().equals(isbn)){
                                libroRepe++;
                                repetido = true;
                                i = tam;
                            }
                        }
                        if(!repetido){
                            modelo.addLibroHistorial(libro); 
                        }
                        repetido = false;
                    }                
                }
                if(libroRepe != 0){
                    String[] botones = {"Sí", "No"};
                    int opcionRepes = JOptionPane.showOptionDialog(null, "Hay " + libroRepe + " libros con ISBN repetidos. \n\n Si: importa la lista sin los repetidos \n No: no se importa la lista de libros \n" , "Libros repetidos", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
                    if(opcionRepes == 0){
                        muestraHistorial(); 
                    }
                }else{
                    setHistorialAux(modelo.getHistorial());
                
                    if(tipoBuscar == 1){
                        procesarBusquedaTitulo();
                    }else if(tipoBuscar == 2){
                        procesarBusquedaIsbn();
                    }else{
                        if(tipoOrdenar == 1){
                            procesarOrdenarPrecio();
                        }else if(tipoOrdenar == 2){
                            procesarOrdenarTitulo();
                        }else{
                            muestraHistorial(); 
                        }
                    }
                }
                
                //aqui tendria que poner como desmarcada la opcion de sustituir
                vista.setValorSustituir(false);
        }else{
                //si damos al botón de cancelar también se resetea la opción de sustituir
            vista.setValorSustituir(false);
        }
    }
    
    /**
     * Comprueba si alguno de los campos del fichero txt que se importe es nulo.
     * @param datos
     * @return 
     */
    private boolean comprobarTrozos(String[] datos){
        boolean nulo=false;
        for (String dato : datos) {
            if (dato == null) {
                nulo=true;
                break;
            }
        }
        return nulo;
    }
    
    /**
     * Procesa la acción de borrar los filtros y campo de búsqueda.
     */
    public void eliminarFiltros(){
        this.vista.mostrarMensaje("");
        tipoOrdenar = 0;
        tipoBuscar = 0;
        historialAux = modelo.getHistorial();
        muestraHistorial();
    }
    
    /**
     * Devuelve el historial auxiliar
     * @return historial auxiliar
     */
    public ArrayList<Libro> getHistorialAux() {
        return historialAux;
    }
    
    /**
     * Establece el historial auxiliar
     * @param historial 
     */
    public void setHistorialAux(ArrayList<Libro> historial) {
        this.historialAux = historial;
    }
}

