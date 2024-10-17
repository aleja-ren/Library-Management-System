/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica.uva.ipc.practica2.main;

import practica.uva.ipc.practica2.modelo.Biblioteca;
import practica.uva.ipc.practica2.vista.GestorVistas;



/**
 * Clase principal en la que se va a ejecutar el programa
 * @author Alejandra Gavino-Dias
 * @author Sara Aparicio Fernandez
 */
public class Main {
    
    private static GestorVistas gestorVistas;
    private static Biblioteca modelo;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        modelo = new Biblioteca();
        gestorVistas = new GestorVistas(modelo);
    }
    
    public static GestorVistas getGestorVistas(){
        return gestorVistas;
    }
    
    public static Biblioteca getModelo(){
        return modelo;
    }
} 
