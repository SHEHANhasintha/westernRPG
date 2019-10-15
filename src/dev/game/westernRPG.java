







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.game;

/**
 *
 * @author SHEHAN
 */
import gamerpg.canvas;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import window.window;

public class westernRPG implements Runnable{
    private window display;
    
    private String title;
    private int width, height;
    
    private Thread thread;
    private boolean running = false;
    
    private canvas canvas;
    
    private BufferStrategy bs;
    private Graphics graphic;
    
    public westernRPG(String title,int width,int height){
        this.title = title;
        this.width = width;
        this.height = height;
        
    }
    
    public void createWindow(){
        display.createWindow();
    }

    public void init(){
        display = new window(this.title,this.width,this.height);
        canvas = new canvas(this.width,this.height);
        
                
    }
    
    public void tick(){
        
    }
    
    public void render(){
        bs = canvas.getCanvas().getBufferStrategy();
        if (bs == null){
            canvas.getCanvas().createBufferStrategy(3);
            return;
        }
        graphic = bs.getDrawGraphics();
        graphic.fillRect(0, 0, this.width, this.height);
        
        bs.show();
        graphic.dispose();
    }
    
    //@Override
    public void run() {

        init();
        
        while (running){
            tick();
            render();
        }
        
        stop();
        
    }
    
    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if (!running){
            return;
        }
        running = false;
        try{
            thread.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    
    
}










