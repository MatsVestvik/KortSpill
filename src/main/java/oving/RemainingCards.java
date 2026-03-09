package oving;

import java.util.ArrayList;
import java.util.Comparator;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class RemainingCards {
  private Button view;
  private Button back;

  public RemainingCards() {

    view = new Button("view");
    back = new Button("back");

  }

  public GridPane createGridPane(DeckOfCards deck) {
    GridPane grid = new GridPane();
    char[] suits = deck.getSuits();
    int col = 0;
    int row = 0;
    for (char suit : suits) {
      ArrayList<PlayingCard> suitedDeck = deck.getCardsOfSuit(suit);
      suitedDeck.sort(Comparator.comparingInt(PlayingCard::getFace));
      for (PlayingCard card : suitedDeck) {
        grid.add(card.getDisplayObject(), col, row);
        col++;
      }
      col = 0;
      row++;
    }
    return grid;
  }

  public Button getViewButton() {
    return view;
  }

  public Button getBackButton() {
    return back;
  }

}
