package com.gol.gameoflife;


import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.Map;
import java.util.Random;

public class Main extends GameApplication {
    private final double Width = 1280d;
    private final double Height = 720d;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth((int)Width);
        gameSettings.setHeight((int)Height);
        gameSettings.setTitle("Game of Life");
        gameSettings.setVersion("");
    }


    private Entity player;
    /*
    private final StringProperty leftPixelsMoved = new SimpleStringProperty();
    private final StringProperty left = new SimpleStringProperty();
    private final StringProperty rightPixelsMoved = new SimpleStringProperty();
    private final StringProperty right = new SimpleStringProperty();
    private final StringProperty upPixelsMoved = new SimpleStringProperty();
    private final StringProperty up = new SimpleStringProperty();
    private final StringProperty downPixelsMoved = new SimpleStringProperty();
    private final StringProperty down = new SimpleStringProperty();
     */
    private final StringProperty xProp = new SimpleStringProperty();
    private final StringProperty yProp = new SimpleStringProperty();

    @Override
    protected void initGame(){
        /*
        left.setValue("Pixels moved Left: " + FXGL.getWorldProperties().getInt("pixelsMovedLeft"));
        leftPixelsMoved.bind(FXGL.getWorldProperties().intProperty("pixelsMovedLeft").asString());
        leftPixelsMoved.addListener((v,oldV,newV) ->{
            left.setValue("Pixels moved Left: " + newV);
        });

        right.setValue("Pixels moved Right: " + FXGL.getWorldProperties().getInt("pixelsMovedRight"));
        rightPixelsMoved.bind(FXGL.getWorldProperties().intProperty("pixelsMovedRight").asString());
        rightPixelsMoved.addListener((v,oldV,newV) ->{
            right.setValue("Pixels moved Right: " + newV);
        });

        up.setValue("Pixels moved Up: " + FXGL.getWorldProperties().getInt("pixelsMovedUp"));
        upPixelsMoved.bind(FXGL.getWorldProperties().intProperty("pixelsMovedUp").asString());
        upPixelsMoved.addListener((v,oldV,newV) ->{
            up.setValue("Pixels moved Up: " + newV);
        });

        down.setValue("Pixels moved Down: " + FXGL.getWorldProperties().getInt("pixelsMovedDown"));
        downPixelsMoved.bind(FXGL.getWorldProperties().intProperty("pixelsMovedDown").asString());
        downPixelsMoved.addListener((v,oldV,newV) ->{
            down.setValue("Pixels moved Down: " + newV);
        });
         */
        player = FXGL.entityBuilder()
                .at(100,100)
                .view(new Rectangle(25,25, Color.BLUE))
                .buildAndAttach();

        xProp.setValue("X: " + player.getX());
        player.xProperty().addListener((v,oldV,newV) ->{
            xProp.setValue("X: " + newV);
        });

        yProp.setValue("Y: " + player.getY());
        player.yProperty().addListener((v,oldV,newV) ->{
            yProp.setValue("Y: " + newV);
        });
    }

    @Override
    protected void initInput(){
        //Right
        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5d);
            //FXGL.inc("pixelsMovedRight", + 5);
        });
        //Left
        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5d);
            //FXGL.inc("pixelsMovedLeft", + 5);
        });
        //Down
        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5d);
            //FXGL.inc("pixelsMovedDown", + 5);
        });
        //Up
        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5d);
            //FXGL.inc("pixelsMovedUp", + 5);
        });
    }

    @Override
    protected void initUI(){
        Text[] tFMovedPixels = new Text[2];

        for (int i = 0; i < 2; i++) {
            tFMovedPixels[i] = new Text();
            tFMovedPixels[i].setTranslateX(10d);
            tFMovedPixels[i].setTranslateY(10d + (tFMovedPixels[i].getLayoutBounds().getHeight() * i));
            FXGL.getGameScene().addUINode(tFMovedPixels[i]);

            switch (i) {
                /*
                case 0 -> tFMovedPixels[i].textProperty().bind(left);
                case 1 -> tFMovedPixels[i].textProperty().bind(right);
                case 2 -> tFMovedPixels[i].textProperty().bind(up);
                case 3 -> tFMovedPixels[i].textProperty().bind(down);
                 */
                case 0 -> tFMovedPixels[i].textProperty().bind(xProp);
                case 1 -> tFMovedPixels[i].textProperty().bind(yProp);
            }
        }
    }

    @Override
    protected void initGameVars(Map<String, Object> vars){
        /*
        vars.put("pixelsMovedLeft", 0);
        vars.put("pixelsMovedRight", 0);
        vars.put("pixelsMovedUp", 0);
        vars.put("pixelsMovedDown", 0);
         */
    }
}