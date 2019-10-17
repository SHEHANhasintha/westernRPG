







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
import dev.Rpg.game.KeyManager;
import dev.Rpg.game.MenuState;
import dev.Rpg.game.State;
import dev.Rpg.game.gameState;
import gamerpg.canvas;
import image.loader.Asserts;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
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
    
    private BufferedImage walk;
    
    private State gameState;
    private State menuState;
    
    private KeyManager keyManager;
    
    public westernRPG(String title,int width,int height){
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
        canvas = new canvas(this.width,this.height);

    }
    
    private void createWindow(){
        display.createWindow();
    }

    private void init() {
        display = new window(this.title,this.width,this.height);
        
        Asserts.init();
        Asserts.Loadassert();
        walk = Asserts.walk;
        
        gameState = new gameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
        
        display.getJframe().addKeyListener(keyManager);
    }
    
    int x = 0;
    private void tick(){
        keyManager.tick();
        
        if (State.getState() != null){
            State.getState().tick();
        }
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
        
       // graphic.drawImage(walk, x, 100, (int) 100, (int) 100, null);
        
        
        if (State.getState() != null){
            State.getState().render(graphic);
        }
        
        bs.show();
        graphic.dispose();
    }
    
    @Override
    public void run() {

        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long timer = 0;
        int ticks = 0;
        long lastTime = System.nanoTime();
        
        while (running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            
            if (delta >= 1){
                tick();
                ticks++;
                render();
                delta--;
            }
            
            /*if (timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
                
            }*/
            
        }
        
        stop();
        
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
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










