package oving;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    DeckOfCards deckOfCards = new DeckOfCards();
    deckOfCards.shuffle();
    Scene scene = new Scene(deckOfCards.getAllCards());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
