/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.entities;












/**
 *
 * @author SHEHAN
 */
public abstract class Creatures extends Entities {
    protected int health;
    protected float speed;
    
    public static int 
            DEFAULT_HEALTH = 100,
            DEFAULT_CREATURE_WIDTH = 64,
            DEFAULT_CREATURE_HEIGHT = 64;
    
    public static float 
            DEFAULT_SPEED = 3.0f;
    
    protected float xMove,yMove;
    
    public Creatures(float x,float y,int width,int height){
        super(x,y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
    }
    
    public float getHealth(){
        return this.health;
    }
    
    public float getSpeed(){
        return this.speed;
    }
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public float getXMove(){
        return xMove;
    }
    
    public float getYMove(){
        return yMove;
    }
    
    public void setXMove(float xMove){
        this.xMove = xMove;
    }
    
    public void setYMove(float yMove){
        this.yMove = yMove;
    }
    
    public void move(){
        x += xMove;
        y += yMove;
    }
}











