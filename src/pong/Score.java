/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author 9087
 */
public class Score {

    private double x, y;
    private int p1Score, p2Score;
    protected Text text;
    
    Score(int p1Score, int p2Score, double x, double y){
        this.p1Score = p1Score;
        this.p2Score = p2Score;
        this.x = x;
        this.y = y;
        String output = p1Score + ":" + p2Score;
        text = new Text(x,y, output);
        text.setFont(Font.font ("Verdana", 80));
        text.setWrappingWidth(300);
        text.setFill(Color.AQUAMARINE);
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
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
    
    public void updateScore(){
         
        text.setText(p1Score + ":" + p2Score);
    }
}

