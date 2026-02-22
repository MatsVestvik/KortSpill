package oving;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.javafx.PlatformUtil;

import javafx.scene.layout.GridPane;

public class DeckOfCards {

  private ArrayList<PlayingCard> deck;
  private final char[] suit = { 'S', 'H', 'D', 'C' };

  public DeckOfCards() {
    deck = new ArrayList<>();

    for (int i = 0; i < 52; i++) {
      char color = suit[i / 13];
      PlayingCard newCard = new PlayingCard(color, (i % 13) + 1);
      deck.add(newCard);
    }

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (PlayingCard card : deck) {
      sb.append(card.getFace() + ", ");
      sb.append(card.getSuit() + "\n");
    }
    return sb.toString();
  }

  public GridPane getAllCards() {
    int col = 0;
    int row = 0;

    GridPane grid = new GridPane();

    for (PlayingCard card : deck) {
      grid.add(card.getDisplayObject(), col, row);
      col++;

      if (col >= 13) {
        col = 0;
        row++;
      }
    }
    return grid;
  }

  public PlayingCard draw() {

    PlayingCard first;
    first = deck.getFirst();
    deck.remove(0);

    return first;
  }

  public void shuffle() {
    Collections.shuffle(deck);
  }
}
