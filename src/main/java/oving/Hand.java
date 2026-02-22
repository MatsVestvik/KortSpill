package oving;

import java.util.ArrayList;

public class Hand {

  private int score;
  private ArrayList<PlayingCard> cards;

  public Hand() {
    cards = new ArrayList<>();
    calculateScore();
  }

  public int getScore() {
    return score;
  }

  public void calculateScore() {
    score = 1;
  }

  public void addCard(PlayingCard card) {
    cards.add(card);
  }
}
