/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practica.uva.ipc.practica2.vista;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import practica.uva.ipc.practica2.modelo.Biblioteca;


/**
 * Esta clase es responsable de presentar los datos al usuario final y envia elementos al controlador
 * cuando se interactua con la interfaz grafica.
 * 
 * @author Sara Aparicio
 * @author Alejandra Gavino-Dias
 */
public class VistaMenu extends javax.swing.JFrame {

    private ControladorMenu controladorMenu;
    private Biblioteca modelo;
    
    /**
     * Constructor de la clase menú e inicializacion de los componentes.
     */
    public VistaMenu(Biblioteca modelo) {
        initComponents();
        this.modelo = modelo;
        this.controladorMenu = new ControladorMenu(this);
        controladorMenu.Imagen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ImagenBiblioteca = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButtonEdicion = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonBusqueda = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNumeroLibros = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumeroLeidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumNoLeidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPrecioMedio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/practica/uva/ipc/practica2/imagenes/icono_biblioteca.png")));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 58)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Bienvenido a la ");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 62)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("BIBLIOTECA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(ImagenBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(ImagenBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)))
                .addGap(32, 32, 32))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Opciones :");

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jButtonEdicion.setBackground(new java.awt.Color(204, 204, 255));
        jButtonEdicion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/uva/ipc/practica2/imagenes/icono_editar.png"))); // NOI18N
        jButtonEdicion.setText("Edición manual");
        jButtonEdicion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonEdicion.setMaximumSize(new java.awt.Dimension(200, 30));
        jButtonEdicion.setMinimumSize(new java.awt.Dimension(200, 30));
        jButtonEdicion.setPreferredSize(new java.awt.Dimension(200, 30));
        jButtonEdicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEdicionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonEdicionMouseExited(evt);
            }
        });
        jButtonEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdicionActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonEdicion);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jButtonBusqueda.setBackground(new java.awt.Color(204, 204, 255));
        jButtonBusqueda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practica/uva/ipc/practica2/imagenes/icono_busqueda.png"))); // NOI18N
        jButtonBusqueda.setText("Búsqueda de libros");
        jButtonBusqueda.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButtonBusqueda.setMaximumSize(new java.awt.Dimension(200, 30));
        jButtonBusqueda.setMinimumSize(new java.awt.Dimension(200, 30));
        jButtonBusqueda.setPreferredSize(new java.awt.Dimension(200, 30));
        jButtonBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonBusquedaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonBusquedaMouseExited(evt);
            }
        });
        jButtonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusquedaActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonBusqueda);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(148, 148, 148))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setText("Número total de libros en la biblioteca:");

        jTextFieldNumeroLibros.setEditable(false);
        jTextFieldNumeroLibros.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldNumeroLibros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel3.setText("Número de libros leídos:");

        jTextFieldNumeroLeidos.setEditable(false);
        jTextFieldNumeroLeidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldNumeroLeidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setText("Número de libros no leídos:");

        jTextFieldNumNoLeidos.setEditable(false);
        jTextFieldNumNoLeidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldNumNoLeidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel5.setText("Precio medio de los libros de la biblioteca:");

        jTextFieldPrecioMedio.setEditable(false);
        jTextFieldPrecioMedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextFieldPrecioMedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPrecioMedio)
                    .addComponent(jTextFieldNumNoLeidos)
                    .addComponent(jTextFieldNumeroLeidos)
                    .addComponent(jTextFieldNumeroLibros))
                .addGap(151, 151, 151))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldNumeroLibros))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldNumeroLeidos))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldNumNoLeidos))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextFieldPrecioMedio))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdicionActionPerformed
        controladorMenu.procesarEdicion();
    }//GEN-LAST:event_jButtonEdicionActionPerformed

    private void jButtonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusquedaActionPerformed
        controladorMenu.procesarBusqueda();
    }//GEN-LAST:event_jButtonBusquedaActionPerformed

    private void jButtonEdicionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEdicionMouseEntered
        jButtonEdicion.setBackground(new Color(51,204,255));
        
    }//GEN-LAST:event_jButtonEdicionMouseEntered

    private void jButtonBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBusquedaMouseEntered
        jButtonBusqueda.setBackground(new Color(51,204,255));
    }//GEN-LAST:event_jButtonBusquedaMouseEntered

    private void jButtonEdicionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEdicionMouseExited
        jButtonEdicion.setBackground(new Color(204,204,255));
    }//GEN-LAST:event_jButtonEdicionMouseExited

    private void jButtonBusquedaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBusquedaMouseExited
        jButtonBusqueda.setBackground(new Color(204,204,255));
    }//GEN-LAST:event_jButtonBusquedaMouseExited

    /**
     * Muestra el número total de libros en la biblioteca.
     * @param total 
     */
    public void mostrarNumeroTotal(int total){
        jTextFieldNumeroLibros.setText(Integer.toString(total));
    }
    
    /**
     * Muestra el número de libros leídos.
     * @param leidos numero de libros leídos
     */
    public void mostrarNumeroLeidos(int leidos){
        jTextFieldNumeroLeidos.setText(Integer.toString(leidos));
    }
    
    /**
     * Muestra el número de libros no leídos.
     * @param noLeidos número de libros no leidos
     */
    public void mostrarNumeroNoLeidos(int noLeidos){
        jTextFieldNumNoLeidos.setText(Integer.toString(noLeidos));
    }
    
    /**
     * Muestra el precio medio de los libros de la biblioteca.
     * @param precioMedio precio medio de los libros de la biblioteca
     */
    public void mostrarPrecioMedio(double precioMedio){
        jTextFieldPrecioMedio.setText(Double.toString(precioMedio)+ " € ");
    }
    
    /**
     * Metodo que establece el icono de la imagen Tarjeta
     * @param ruta indica donde se haya la ruta para reconocer la imagen e implementarla
     */
    public void setImagenBiblioteca(String ruta) {
        this.ImagenBiblioteca.setIcon(new ImageIcon(ruta));
    }
    
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenBiblioteca;
    private javax.swing.JButton jButtonBusqueda;
    private javax.swing.JButton jButtonEdicion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextFieldNumNoLeidos;
    private javax.swing.JTextField jTextFieldNumeroLeidos;
    private javax.swing.JTextField jTextFieldNumeroLibros;
    private javax.swing.JTextField jTextFieldPrecioMedio;
    // End of variables declaration//GEN-END:variables
}
