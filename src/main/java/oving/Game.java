package oving;

public class Game {

  private DeckOfCards deck;
  private Hand hand;
  private VBox elements;

  public Game(DeckOfCards deck) {
    this.deck = deck;
    this.hand = new Hand();

    V
  }

  public void drawCard() {
    hand.addCard(deck.draw());
  }
}
