/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.uva.ipc.practica2.vista;

import javax.swing.JFrame;
import practica.uva.ipc.practica2.modelo.Biblioteca;


/**
 * Gestiona las vistas de la aplicación.
 * @author Sara Aparicio
 * @author Alejandra Gavino-Dias
 */
public class GestorVistas {
    
    private JFrame vistaActual;
    private JFrame Vista;
    private static Biblioteca modelo;
    
    /**
     * Crea un nuevo gestor y muestra de forma inicial la vista del menú principal.
     * @param modelo 
     */
    public GestorVistas(Biblioteca modelo){
        this.modelo = modelo;
        mostrarVistaMenu();
    }
    
    /**
     * Muestra la vista de menú principal.
     */
    void mostrarVistaMenu(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(vistaActual!=null){
                    vistaActual.setVisible(false);
                    vistaActual.dispose();
                }
                vistaActual = new VistaMenu(modelo);
                vistaActual.setVisible(true);
            }
        });   
    }
    
    /**
     * Muestra la vista del modo búsqueda.
     */
    void mostrarVistaBusqueda(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(vistaActual!=null){
                    vistaActual.setVisible(false);
                    vistaActual.dispose();
                }
                vistaActual = new VistaBusqueda(modelo);
                vistaActual.setVisible(true);
            }
        }); 
    }
    
    /**
     * Muestra la vista del modo edición.
     */
    void mostrarVistaEdicion(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(vistaActual!=null){
                    vistaActual.setVisible(false);
                    vistaActual.dispose();
                }
                vistaActual = new VistaEdicion(modelo);
                vistaActual.setVisible(true);
            }
        }); 
    }
}
