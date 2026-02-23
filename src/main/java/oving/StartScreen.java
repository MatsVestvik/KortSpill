package oving;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartScreen {

  public StartScreen(Stage stage, Scene scene) {
    Deck deck = new Deck(createStandardDeck(), 5);
    scene.setRoot(deck.getDisplayObject());
    stage.setScene(scene);
    stage.show();
  }

  public ArrayList<Card> createStandardDeck() {
    ArrayList<Card> deck = new ArrayList<>();
    char[] suits = { 'C', 'D', 'H', 'S' };
    for (char suit : suits) {
      for (int i = 0; i <= 14; i++) {
        deck.add(new Card(i, suit));
      }
    }
    return deck;
  }
}
