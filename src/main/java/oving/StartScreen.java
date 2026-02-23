package oving;

import java.util.ArrayList;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartScreen {

  private Scene scene;

  private Parent root;

  public StartScreen(Scene scene) {
    Deck deck = new Deck(createStandardDeck(), 5);
    deck.shuflle();
    Card card = deck.draw();
    card.createDisplayObject(5);
    root = card.getDisplayObject();
    this.scene = scene;
  }

  public void runScene() {
    scene.setRoot(root);
  }

  public ArrayList<Card> createStandardDeck() {
    ArrayList<Card> deck = new ArrayList<>();
    char[] suits = { 'C', 'D', 'H', 'S' };
    for (char suit : suits) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new Card(i, suit));
      }
    }
    return deck;
  }
}
