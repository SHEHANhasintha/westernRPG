





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamerpg;
import java.awt.Canvas;
import java.awt.Dimension;
/**
 *
 * @author SHEHAN
 */
public class canvas {
    private int width,height;
    public Canvas canvas;
    public canvas(int width,int height){
        this.width = width;
        this.height = height;
        createCanvas();
    }
    public void createCanvas(){
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);
        
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
}

    
    
    
    
    
    
    
    
    