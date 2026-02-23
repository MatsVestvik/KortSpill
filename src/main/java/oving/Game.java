package oving;

import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;

public class Game {

  private DeckOfCards deck;
  private Hand hand;
  private VBox elements;
  private ImageView deckStack;

  public Game(DeckOfCards deck) {
    this.deck = deck;
    this.hand = new Hand();
    deckStack = deck.getBack();

    elements = new VBox();
    elements.getChildren().addAll(deckStack, hand.getDisplayObject(), hand.getScoreVisual());
    deckStack.setOnMouseClicked(e -> {
      hand.clearHand();
      hand.addFiveCards(deck.drawFive());
    });
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
