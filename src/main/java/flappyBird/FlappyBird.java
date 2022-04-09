package flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Eduardo Ernesto
 */

public class FlappyBird implements ActionListener
{
//atributos
    public static FlappyBird flappyBird;
    
    public final int WIDTH = 800, HEIGHT = 700;
    
    public renderizacion renderizacion;
    
    public Rectangle pajaro;
    
    public int ticks, ymotion;
    
    public int puntaje;
    
    public int movimiento;
    
    public boolean gameOver, started=true;
    
    public boolean inicio;
    
    public ArrayList<Rectangle> columnas;
    
    public Random rand;
   
    
    public FlappyBird()
    {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(20, this);
        
        renderizacion = new renderizacion();
        rand = new Random();
        
        jframe.add(renderizacion);
        jframe.setTitle("Flappy Bird");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);
        
        
        pajaro = new Rectangle(WIDTH /2 - 10, HEIGHT /2 - 10, 20, 20);
        columnas = new ArrayList<Rectangle>();
        //nuevooo
        agregarColumna(true);
        agregarColumna(true);
        agregarColumna(true);
        agregarColumna(true);
        
        timer.start();
    }
    

    public void agregarColumna(boolean start)
    {
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
    
    public void pintarColumna(Graphics g, Rectangle columna)
    {
        g.setColor(Color.green.darker());
        g.fillRect(columna.x, columna.y, columna.width, columna.height);
                
    }
    // nuevoooo
    // metodo para controlar el redibujado de los componentes del juego
    @Override
    public void actionPerformed(ActionEvent e)
    {
        int speed = 10;
        
        ticks++;
        
        if(started){
        
        for (int i = 0; i < columnas.size(); i++)
        {
            Rectangle columna = columnas.get(i);
            
            columna.x -= speed;
        }
        if(ticks % 2 == 0 && ymotion < 15)
        {
            ymotion += 2;
        }
        
        for (int i = 0; i < columnas.size(); i++)
        {
            Rectangle columna = columnas.get(i);
            
            if (columna.x + columna.width < 0)
            {
                columnas.remove(columna);
                
                if (columna.y == 0)
                {
                    agregarColumna(false);
                }
            }       
        }
        
        pajaro.y += ymotion;
        
        for (Rectangle columna : columnas)
        {
            if (columna.intersects(pajaro))
            {
                gameOver = true;
                
                pajaro.x = columna.x - pajaro.width;
            }
        }
        
        if (pajaro.y > HEIGHT - 120 || pajaro.y < 0)
        {
            
            gameOver = true;
        }
        
        if (gameOver){
            pajaro.y = HEIGHT  - 120 - pajaro.height;
        }
    }
        
    renderizacion.repaint();
        
    }
     
        
//definicion de metodo 
   public void saltar()
	{
            
        }
   
//Metodo de ordenacion burbuja
   public static String[] ordenBurbuja(String[] p)
    {
       String auxiliar;
        for(int i = 0;i < (p.length - 1); i++){
            for(int j = 0;j < (p.length - 1); j++){
                if(p[j].compareTo(p[j+1]) > 0){
                    auxiliar = p[j];
                    p[j] = p[j+1];
                    p[j+1] = auxiliar;
                }       
            }
        }
        return p;
}
 //Metodo de busqueda binaria
   public static int busqBin(int[] b, int elemento) {
        int inicio = 0;
        int fin = b.length - 1;
        int pos;
        while (inicio <= fin) {
            pos = (inicio+fin) / 2;
            if ( b[pos] == elemento )
              return pos;
            else if ( b[pos] < elemento) {
         inicio = pos+1;
            } else {
         fin = pos-1;
            }
        }
        return -1;
     } 
 
//Metodo de ordenamiento por Insercion
public static void ordenInsercion(int[] q)
    {
        int i, aux, N=q.length;
        for(int j=1;j<N;j++){
          aux= q[j];
          i= j-1;
          while(i>-1 && q[i]>aux){
              q[i+1]=q[i];
              i=i-1;
          }
          q[i+1]=aux;
        }
    }
   
//Metodo de busqueda secuencial
 public static  int busquedaSecuencial(String c[], String Elemento){
    int posicion = -1;
  for(int i = 0; i < c.length; i++){
      if(Elemento.equals(c[i])){
    posicion = i;
    break;
   }
 }
 return posicion;
}  
 
public static void mostrarArreglo(int a[]){
     for (int i=1; i<=a.length; i++){
         System.out.print(a[i-1]+" ");
     }
     System.out.print("\n");
 } 
   
// Encapsulación del entorno del juego
    void color(Graphics g) 
    {
        //Seleccionar fondo
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        //Seleccionar color del piso
        g.setColor(Color.orange);
        g.fillRect(0, HEIGHT - 120, WIDTH,120);
        
        //Seleccionar color del césped
        g.setColor(Color.green);
        g.fillRect(0, HEIGHT - 120, WIDTH,20);
        
        //Seleccionar color de la figura
        g.setColor(Color.red);
        g.fillRect(pajaro.x, pajaro.y, pajaro.width, pajaro.height);
        
        for (Rectangle columna : columnas){
            pintarColumna(g, columna);
        }
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1,50));
        
        //Boton de inicio
        if (!gameOver)
        {
            g.drawString("Click para empezar:", 50, HEIGHT / 4 - 70);
        }
        
        if (gameOver)
        {
            g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
        }
    }

    public static void main(String[] args)
    {
        flappyBird = new FlappyBird(); 
        
    }
}
        
       