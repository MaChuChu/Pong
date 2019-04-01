
package pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite {
    protected double x,y,width,height;
    private String colour;
    protected Rectangle rect;
    
    Sprite(double x, double y, double width, double height, Color colour){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        rect = new Rectangle(x,y,width,height);
        rect.setFill(colour);
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

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }
}
