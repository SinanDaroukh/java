package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MyButton extends Button implements EventHandler<ActionEvent> {

    private int compteur = 0;

    public MyButton() {
        super("0");
        setOnAction(this::handle);
    }

    public void incrementer(){
        this.compteur++;
        setText(String.valueOf(compteur));
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        incrementer();
    }
}
