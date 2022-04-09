/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flappyBird;

import java.awt.Rectangle;

/**
 *
 * @author Eduardo
 */
public class Easy extends FlappyBird{
    public Easy(){
        super();
    }
    @Override
    public void agregarColumna(boolean start)
    {
        int speed = 10;
        int space = 450;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        
        if (start)
        {
            columnas.add(new Rectangle(WIDTH + width + columnas.size() * 300, HEIGHT - height -120, width, height));
            columnas.add(new Rectangle(WIDTH + width + (columnas.size() - 1) * 300, 0, width, HEIGHT - height - space));
        }
        else
        {
            columnas.add(new Rectangle(columnas.get(columnas.size() -1). x + 600, HEIGHT - height -120, width, height));
            columnas.add(new Rectangle(columnas.get(columnas.size() -1).x, 0, width, HEIGHT - height - space));
        }
    }
        
}
