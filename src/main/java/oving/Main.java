package oving;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage stage) {

    DeckOfCards deck = new DeckOfCards();
    deck.shuffle();
    Game game = new Game(deck);
    Scene scene = new Scene(game.getElements());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
