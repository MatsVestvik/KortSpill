package oving;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    PlayingCard test = new PlayingCard('C', 13);
    Scene scene = new Scene(test.getDisplayObject());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    DeckOfCards deck = new DeckOfCards();
    System.out.println(deck.toString());
    launch(args);
  }
}
