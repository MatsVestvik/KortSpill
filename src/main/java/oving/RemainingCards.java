package oving;

import javafx.scene.layout.GridPane;

public class RemainingCards {
  private DeckOfCards deck;

  public RemainingCards(DeckOfCards deck) {
    this.deck = deck;

  }

  public GridPane createGridPane(){
    GridPane grid = new GridPane();
    for (PlayingCard card : deck){
    for (PlayingCard card : suitedDeck) {
    }
      
    }
    return grid;
  }
}
