/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SHEHAN
 */



package window;
import javax.swing.JFrame;
import gamerpg.canvas;
import java.awt.Canvas;
public class window {
    private JFrame frame;
    private int height,width;
    private String title;
    private canvas canvas;
    
    public window(String title,int width,int height){
        this.title = title;
        this.height = height;
        this.width = width;
        
        createWindow();
    }
    
    public void createWindow(){
        frame = new JFrame(this.title);
        frame.setSize(this.width,this.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canvas = new canvas(this.width,this.height);
        
        frame.add(canvas.canvas);
        frame.pack();
    }
    
    public Canvas getCanvas(){
        return canvas.canvas;
    }
    
    public JFrame getJframe(){
        return frame;
    }
    
    
}












