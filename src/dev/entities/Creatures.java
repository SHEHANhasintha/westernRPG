/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.entities;

import dev.env.Tile;
import dev.game.Handler;
import dev.game.westernRPG;












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
    
    public Creatures(Handler handler,float x,float y,int width,int height){
        super(handler,x,y,width,height);
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
       moveX();
       moveY();
    }
    
    public void moveX(){
        if(xMove > 0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if ((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)) && 
                    (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT))){
                x += xMove;
            }
        }else if(xMove < 0){//Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if ((!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT)) && 
                    (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT))){
                x += xMove;
            }
        } 
    }
    
    public void moveY(){
        if(yMove < 0){//Moving right
            int ty = (int)(y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH,ty) && 
                    !collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH,ty)){
                y += yMove;
            }
        }else if(yMove > 0){//Moving left
            int ty = (int)(y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH,ty) && 
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH,ty)){
                y += yMove;
            }
        }
    }
    
    protected boolean collisionWithTile(int x,int y){
        return handler.getWorld().getTile(x,y).isSolid();
    }
    
}











