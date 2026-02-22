package oving;

import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class Game {

  private DeckOfCards deck;
  private Hand hand;
  private VBox elements;

  public Game(DeckOfCards deck) {
    this.deck = deck;
    this.hand = new Hand();

    createElements();
  }

  private void createElements() {
    elements = new VBox();
    ImageView back = deck.getBack();
    back.setOnMouseClicked(e -> {
      drawCard();
    });

    elements.getChildren().addAll(back, hand.getDisplayObject(), hand.getScoreVisual());

  }

  public void drawCard() {
    hand.addCard(deck.draw());
  }

  public DeckOfCards getDeck() {
    return deck;
  }

  public Hand getHand() {
    return hand;
  }

  public VBox getElements() {
    return elements;
  }
}
