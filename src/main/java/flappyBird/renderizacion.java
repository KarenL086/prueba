/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappyBird;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Eduardo
 */
    public class renderizacion extends JPanel
{
    // 
    private static final long serialVersionUID = 1L;
    
//Este método hace una invocación de repintado, en este proyecto servirá para llamar a este método cuando comience el 
//juego y se necesite usar como "fotogramas o frames" o repintar como se suele llamar, asi el programa tendrá el        
// aspecto donde la figura va avanzando
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        FlappyBird.flappyBird.color(g);
    }
}

