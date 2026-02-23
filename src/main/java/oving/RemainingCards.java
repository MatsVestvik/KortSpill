package oving;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class RemainingCards {
  private DeckOfCards deck;

  public RemainingCards(DeckOfCards deck) {
    this.deck = deck;

  }

  public GridPane createGridPane() {
    GridPane grid = new GridPane();
    char[] suits = deck.getSuits();
    int col = 0;
    int row = 0;
    for (char suit : suits) {
      ArrayList<PlayingCard> suitedDeck = deck.getCardsOfSuit(suit);
      for (PlayingCard card : suitedDeck) {
        grid.add(card.getDisplayObject(), col, row);
        col++;
      }
      col = 0;
      row++;
    }
    return grid;
  }
}
