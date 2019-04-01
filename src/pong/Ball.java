
package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ball extends Sprite{
    //private double x, y;
    private double width,height;
    private double xSpeed, ySpeed;

    Ball(double x, double y, double width, double height, double xSpeed, double ySpeed,Color colour) {
        super(x, y, width, height, colour);
//        this.x = x;
//        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        rect = new Rectangle(x, y, width, height);
        rect.setFill(colour);
        rect.setArcHeight(100);
        rect.setArcWidth(100);
    }
    public void move(){
//        if((x<=0) || (x>=984)){
//            setxSpeed(-getxSpeed());
//        }
        if ((y<=0)||(y>=546)) {
            setySpeed(-getySpeed());
        }
        
        x += getxSpeed();
        y += getySpeed();
        rect.setY(y);
        rect.setX(x);
        
    }
    
    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
}
