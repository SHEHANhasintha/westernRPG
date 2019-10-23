/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
















package dev.entities;

import dev.game.Handler;
import dev.game.westernRPG;
import image.loader.Asserts;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author SHEHAN
 */
public class Player extends Creatures{
    public Player(Handler handler,float x, float y){
        super(handler,x,y,Creatures.DEFAULT_CREATURE_WIDTH,Creatures.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
        
    }
    
    public void Input(){
        xMove = 0;
        yMove = 0;
        if (this.handler.getKeyManager().up)
            yMove -= speed;
        if (this.handler.getKeyManager().down)
            yMove += speed;
        if (this.handler.getKeyManager().left)
            xMove -= speed;
        if (this.handler.getKeyManager().right)
            xMove += speed;
    }

    
    
    @Override
    public void tick() {
        Input();
        move();
        handler.getGameCamara().centerOnEntity(this);
    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Asserts.walk, (int) (x - handler.getGameCamara().getXOffset()), (int) (y - handler.getGameCamara().getYOffset()), width, height, null);
        
        graphic.setColor(Color.red);
        graphic.fillRect((int) (x + bounds.x - handler.getGameCamara().getXOffset()), 
                (int) (y + bounds.y - handler.getGameCamara().getYOffset()), bounds.width, bounds.height);
    
    }
    
    
    
}













