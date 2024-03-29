/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.Rpg.game;

import dev.game.Handler;
import dev.game.westernRPG;
import java.awt.Graphics;





/**
 *
 * @author SHEHAN
 */
public abstract class State {

    public static State currentState = null;
    
    //CLASS
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
    
    public static void setState(State state){
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    public abstract void tick();
    public abstract void render(Graphics graphic);
}























