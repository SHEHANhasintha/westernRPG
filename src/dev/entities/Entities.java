/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.entities;

import dev.game.Handler;
import dev.game.westernRPG;
import java.awt.Graphics;
import java.awt.Rectangle;










/**
 *
 * @author SHEHAN
 */
public abstract class Entities {
    protected Handler handler;
    protected float x,y;
    protected int width,height;
    
    protected Rectangle bounds;
    
    public Entities(Handler handler,float x,float y,int width,int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        bounds = new Rectangle(0,0,width,height);
    }
    
    public float getWidth(){
        return width;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
    
    public float getHeight(){
        return height;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public float getX(){
        return x;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setY(float y){
        this.y = y;
    }
    

    
    public abstract void tick();
    public abstract void render(Graphics graphic);
}








