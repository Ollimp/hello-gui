package org.itstep;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App extends Application {

    public static final Paint WHITE = Paint.valueOf("#ffffff");
    public static final Paint BLACK = Paint.valueOf("#000000");
    public static final Paint DARKGREEN = Paint.valueOf("#127258");
    public static final Font LABEL_FONT = Font.font("Roboto", FontWeight.BOLD, 18);
    public static final int HEIGHT = 600;
    public static final int WIDTH_RECTANGLE_1 = 530;
    public static final int WIDTH = 800;
    public static final Background BUTTON_BACKGROUND = new Background(new BackgroundFill(Paint.valueOf("#C4C4C4"), null, null));
    public static final Font CASH_LABEL_FONT = Font.font("Robot", FontWeight.MEDIUM, 24);

    @Override
    public void start(Stage stage) {


        Pane root= new Pane();

        Rectangle greenRect = new Rectangle(WIDTH_RECTANGLE_1, HEIGHT);
        greenRect.setFill(DARKGREEN);

        Rectangle blackRect =new Rectangle(WIDTH - WIDTH_RECTANGLE_1,HEIGHT);
        blackRect.setFill(BLACK);
        blackRect.relocate(WIDTH_RECTANGLE_1,0);

        Label dealerLabel= new Label("Dealer: 0");
        dealerLabel.setTextFill(WHITE);
        dealerLabel.setFont(LABEL_FONT);
        dealerLabel.relocate(153,15);
        dealerLabel.setPrefWidth(194);
        dealerLabel.setAlignment(Pos.CENTER);
      //  dealerLabel.setBorder(new Border(new BorderStroke(Paint.valueOf("#ffffff"), BorderStrokeStyle.SOLID,null,new BorderWidths(1))));

        Label blackJackLabel = new Label("Black Jack");
        blackJackLabel.setTextFill(WHITE);
        blackJackLabel.setFont(Font.font("Robot", FontWeight.MEDIUM, 48));
        blackJackLabel.relocate(135,272);

        Label playerLabel = new Label("Player: 0");
        playerLabel.setTextFill(WHITE);
        playerLabel.setFont(LABEL_FONT);
        playerLabel.setPrefWidth(217);
        playerLabel.setAlignment(Pos.CENTER);
        playerLabel.relocate(157,565);
       // playerLabel.setBorder(new Border(new BorderStroke(Paint.valueOf("#ffffff"), BorderStrokeStyle.SOLID,null,new BorderWidths(1))));

Label cashLabel = new Label("Cash: 1000");
cashLabel.setTextFill(WHITE);
cashLabel.setFont(CASH_LABEL_FONT);
cashLabel.relocate(603,11);
cashLabel.setPrefWidth(122);
cashLabel.setAlignment(Pos.CENTER);


        Button buttonHit = new Button("HIT");
        buttonHit.setBackground(BUTTON_BACKGROUND);
        buttonHit.setFont(LABEL_FONT);
        buttonHit.setPrefWidth(190);
        buttonHit.setPrefHeight(40);
        buttonHit.relocate(572,156);

        Button buttonStand = new Button("STAND");
        buttonStand.setBackground(BUTTON_BACKGROUND);
        buttonStand.setFont(LABEL_FONT);
        buttonStand.setPrefWidth(190);
        buttonStand.setPrefHeight(40);
        buttonStand.relocate(572,236);

        Button buttonPlay = new Button("PLAY");
        buttonPlay.setBackground(BUTTON_BACKGROUND);
        buttonPlay.setFont(LABEL_FONT);
        buttonPlay.setPrefWidth(190);
        buttonPlay.setPrefHeight(40);
        buttonPlay.relocate(572,537);


        TextField textField = new TextField("100");
        textField.setPrefHeight(54);
        textField.setPrefWidth(190);
        textField.setAlignment(Pos.CENTER);
        textField.setFont(CASH_LABEL_FONT);
        textField.relocate(572,368);


        Label labelBet = new Label( "BET");
        labelBet.setTextFill(WHITE);
        labelBet.setFont(LABEL_FONT);
        labelBet.relocate(573,308);
        labelBet.setPrefWidth(179);
        labelBet.setAlignment(Pos.CENTER);







        root.getChildren().add(greenRect);
        root.getChildren().add(blackRect);
        root.getChildren().add(dealerLabel);
        root.getChildren().add(blackJackLabel);
        root.getChildren().add(playerLabel);
        root.getChildren().add(cashLabel);
        root.getChildren().add(buttonHit);
        root.getChildren().add(buttonStand);
        root.getChildren().add(buttonPlay);
        root.getChildren().add(textField);
        root.getChildren().add(labelBet);




        Scene scene = new Scene(root, WIDTH, HEIGHT);

        stage.setScene(scene);
        stage.setTitle("Simple application in JavaFX");
        stage.getIcons().add(new Image("icon.png"));
        stage.setResizable(false);
        stage.show();
    }

    private String pathToCard(String cardFilename) {
        if(cardFilename == null) return null;
        String[] parts = cardFilename.split("/");
        return App.class.getClassLoader().getResource(parts[0]) + (parts.length == 2 ? parts[1] : "");
    }

    private void playAnimation(ImageView logoView) {
        //Creating scale Transition
        FadeTransition fadeTransition = new FadeTransition();
        ScaleTransition scaleTransition = new ScaleTransition();

        final Duration duration = Duration.millis(1500);

        //Setting the duration for the transition
        scaleTransition.setDuration(duration);
        fadeTransition.setDuration(duration);

        //Setting the node for the transition
        scaleTransition.setNode(logoView);
        fadeTransition.setNode(logoView);

        //Setting the dimensions for scaling
        scaleTransition.setByY(2);
        scaleTransition.setByX(2);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        //Setting the cycle count for the translation
        //scaleTransition.setCycleCount(50);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);

        scaleTransition.play();
        fadeTransition.play();
    }

    public static void main(String[] args) throws URISyntaxException {
        launch();
    }

}