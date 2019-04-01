package pong;

import java.net.URL;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Pong extends Application {
    int width = 1024;
    int height = 576;
    
    Scene scene;
    MediaPlayer mp;
        
    Player player,player2;
    int pWidth = 30;
    int pHeight = 100;
    Ball ball;
    Score score;
    Random rand;
    
    
    @Override
    public void start(Stage primaryStage) {
        
        URL path = getClass().getResource("sans.mp3");
        Media m = new Media(path.toString());
        mp = new MediaPlayer(m);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.play();
        
        Group g = new Group();
        
        player = new Player(50,height/2-(pHeight/2),30,100,Color.WHITE, KeyCode.W, KeyCode.S);
        player2 = new Player(width-(50+pWidth),height/2-(pHeight/2),30,100,Color.WHITE,KeyCode.UP, KeyCode.DOWN);
        
        ball = new Ball((width/2)-30,(height/2)-30,30,30,4,4,Color.ALICEBLUE);
        
        score = new Score(0,0,(width/2)-100, 80);
        
        g.getChildren().add(player.getRect());
        g.getChildren().add(player2.getRect());
        g.getChildren().add(ball.getRect());
        g.getChildren().add(score.getText());
        
        scene = new Scene(g, width, height);
        scene.setFill(Color.BLACK);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                    player2.keyPressed(event);
                    player.keyPressed(event);
                }
                 
            });          
        
        primaryStage.setTitle("Pong!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                
                System.out.println("pointP1: "+score.getP1Score());
                System.out.println("pointP2: "+score.getP2Score());
                player2.move();
                player.move();
                ball.move();
                hit();
                point();
            }

            
         }.start();
    }
    private void hit(){
        if (player.getRect().getBoundsInParent().intersects(ball.getRect().getBoundsInParent()) || player2.getRect().getBoundsInParent().intersects(ball.getRect().getBoundsInParent())) {
        ball.setxSpeed(-ball.getxSpeed());  
        ball.setxSpeed(ball.getxSpeed()*1.25);
        ball.setySpeed(ball.getySpeed()*1.25);
        }
    }
    private void point() {
        int r = (int) (Math.random()*255);
        int g = (int) (Math.random()*255);
        int b = (int) (Math.random()*255);
        
        if (ball.getX() > 984) {
            score.setP1Score(score.getP1Score()+1);
            ball.setX((width/2)-30);
            ball.setY((height/2)-30);
            ball.setxSpeed(4);
            ball.setySpeed(4);
            scene.setFill(Color.rgb(r, g, b));
        }
        if (ball.getX() < 0) {
            score.setP2Score(score.getP2Score()+1);
            ball.setX((width/2)-30);
            ball.setY((height/2)-30);
            ball.setxSpeed(4);
            ball.setySpeed(4);
            scene.setFill(Color.rgb(r, g, b));
        }
        score.updateScore();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
