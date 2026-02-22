package oving;

import java.util.ArrayList;

import javafx.scene.layout.HBox;

public class Hand {

  private int score;
  private ArrayList<PlayingCard> cards;
  private HBox displayObject;

  public Hand() {
    cards = new ArrayList<>();
    calculateScore();
    updateHandVisual();
  }

  public void updateHandVisual() {
    for (PlayingCard card : cards) {
      displayObject.getChildren().clear();
      displayObject.getChildren().add(card.getDisplayObject());
    }
  }

  public int getScore() {
    return score;
  }

  public void calculateScore() {
    score = 1;
  }

  public void addCard(PlayingCard card) {
    cards.add(card);
    updateHandVisual();
  }

  public HBox getDisplayObject() {
    return this.displayObject;
  }
}
