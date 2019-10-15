







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
import image.loader.SpriteSheet;
import static image.loader.gfx.loadImage;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import image.loader.SpriteSheet;
import image.loader.gfx;
import java.io.File;
import javax.imageio.ImageIO;
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
    
    private gfx imageLoader;
    
    private BufferedImage img = null;
    
    private SpriteSheet sheet;
    
    
    public westernRPG(String title,int width,int height){
        this.title = title;
        this.width = width;
        this.height = height;
        
    }
    
    private void createWindow(){
        display.createWindow();
    }

    private void init(){
        display = new window(this.title,this.width,this.height);
        canvas = new canvas(this.width,this.height);
        
        try{
        img =  ImageIO.read(new File("./res/app.png"));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        } 
        
        sheet = new SpriteSheet(img);
        
    }
    
    private void tick(){
        
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graphic = bs.getDrawGraphics();
        graphic.fillRect(0, 0, this.width, this.height);
        
        //graphic.clearRect(0,0,this.width,this.height);
        
        graphic.drawImage(sheet.crop(0,0,100,100), 200, 200, null);
        
        
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










