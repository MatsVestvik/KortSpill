package oving;

import java.util.ArrayList;

import javafx.scene.layout.HBox;

public class Hand {

  private int score;
  private ArrayList<PlayingCard> cards;
  private HBox displayObject;
  private HBox scoreVisual;

  public Hand() {
    cards = new ArrayList<>();
    displayObject = new HBox();
    calculateScore();
    updateHandVisual();
    createScoreVisual();
  }

  public void updateHandVisual() {
    displayObject.getChildren().clear();
    for (PlayingCard card : cards) {
      displayObject.getChildren().add(card.getDisplayObject());
    }
  }

  public int getScore() {
    return score;
  }

  public HBox getScoreVisual() {
    return this.scoreVisual;
  }

  public void createScoreVisual() {
    HBox newScoreVisual = Numbers.getLargeNumber(score, 10);
    if (scoreVisual != null && scoreVisual.getParent() != null) {
      // Replace the old score visual with the new one in its parent
      ((javafx.scene.layout.Pane) scoreVisual.getParent()).getChildren().set(
        ((javafx.scene.layout.Pane) scoreVisual.getParent()).getChildren().indexOf(scoreVisual),
        newScoreVisual
      );
    }
    scoreVisual = newScoreVisual;
  }

  public void calculateScore() {
    int temp = 0;
    for (PlayingCard card : cards) {
      temp += card.getFace();
    }
    this.score = temp;
  }

  public void addCard(PlayingCard card) {
    cards.add(card);
    updateHandVisual();
    calculateScore();
    createScoreVisual();
  }

  public HBox getDisplayObject() {
    return this.displayObject;
  }
}
