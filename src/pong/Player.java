
package pong;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Player extends Sprite{
//    private double x, y;
    private double width = 30;
    private double height = 100;
    private double SpeedMulti = 10;
    private double dy;
    
    private boolean up,down;
    private KeyCode upKey;
    private KeyCode downKey;
    
    
    Player(double x, double y, double width, double height,Color colour, KeyCode upKey, KeyCode downKey){
        super(x, y, width, height, colour);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x, y, width, height);
        rect.setFill(colour);
        rect.setArcHeight(20);
        rect.setArcWidth(20);
        this.upKey = upKey;
        this.downKey = downKey;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDy() {
        return dy;
    }

    void keyPressed(KeyEvent code) {
        KeyCode kc = code.getCode();
        if(kc==upKey){
            down = false; up = true;
        }
        else if(kc==downKey){
            down = true; up = false;
        }
        
    }
    
    void keyReleased(KeyEvent code) {
        KeyCode kc = code.getCode();
        if(kc==upKey){
            up = false;
        }
        else if(kc==downKey){
            down = false;
        }
    }

    public void move(){
        if(up){
            if(y>5){
                dy = -SpeedMulti;
            }else{
                up=false; dy=0;       
            }
        }
        else if (down){
            if (y<475) {
                dy = SpeedMulti;
            }else{
                down=false; dy=0; 
            }
        }
        
        y+=getDy();
        rect.setY(y);
    }

    
    
}
