package edu.bsu.cs222;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class MainGUI3 {

    private Stage stage;
    private BorderPane root;
    private Scene scene;
    private Insets INSETS = new Insets(10, 10, 10, 10);

    public MainGUI3(Stage stage) {
        this.stage = stage;
        buildUI();
    }

    private void buildUI() {
        root = new BorderPane();

        VBox leftMenu = createVbox("Left");
        Button buttonD = new Button("D");
        Button buttonE = new Button("E");
        Button buttonF = new Button("F");
        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);

        Button top = createButton("Top");
        Button center = createButton("Center");
        //Button right = createButton("Right");
        Button bottom = createButton("Bottom");

        root.setTop(top);
        root.setLeft(leftMenu);
        root.setCenter(center);
        //root.setRight(right);
        root.setBottom(bottom);

        scene = new Scene(root);
        stage.setTitle("Art Generator");
        stage.setScene(scene);
        stage.setMinWidth(550);
        stage.setMinHeight(400);
        stage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMinWidth(150);
        BorderPane.setMargin(button, INSETS);
        BorderPane.setAlignment(button, Pos.CENTER);
        return button;
    }

    private VBox createVbox(String text) {
        VBox vbox = new VBox();
        vbox.setMaxWidth(Double.MAX_VALUE);
        vbox.setMaxHeight(Double.MAX_VALUE);
        vbox.setMinWidth(150);
        BorderPane.setMargin(vbox, INSETS);
        BorderPane.setAlignment(vbox, Pos.CENTER);
        return vbox;
    }
}