package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        MyButton btn = new MyButton();
        MyButton btn1 = new MyButton();
        MyButton btn2 = new MyButton();
        MyButton btn3 = new MyButton();
        MyButton btn4 = new MyButton();
        MyButton btn5 = new MyButton();
        MyButton btn6 = new MyButton();

        Alert alert =  new Alert(Alert.AlertType.WARNING, "C'est la mère noire, les potes ! ");
        Optional<ButtonType> result = alert.showAndWait();

        HBox root = new HBox();

        root.getChildren().add(btn);
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
