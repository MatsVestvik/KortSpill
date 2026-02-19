package oving;

import java.util.ArrayList;

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
}
