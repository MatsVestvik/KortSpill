package oving;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Hand implements Display {

  private ArrayList<Card> cards;
  private HBox displayObject;
  private HBox hoverDisplayObject;
  private int score;
  private Label scoreDisplayObject;
  private int scale;

  public Hand() {
    cards = new ArrayList<>();
    score = 0;
    displayObject = new HBox();
    scoreDisplayObject = new Label();
    scale = 5;
    createScoreDisplayObject();
  }

  public Node getDisplayObject() {
    return displayObject;
  }

  public Node getScoreDisplayObject() {
    return scoreDisplayObject;
  }

  public void createHoverDisplayObject(int scale) {
    hoverDisplayObject = new HBox();
  }

  public Node getHoverDisplayObject() {
    return hoverDisplayObject;
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public int getScore() {
    return score;
  }

  public void createScoreDisplayObject() {
    scoreDisplayObject.setText("Score: " + score);
  }

  public void scoreHand() {
    int tempScore = 0;

    for (Card card : cards) {
      tempScore += card.getFace();
    }
    score = tempScore;
    createScoreDisplayObject();
  }

  public void clearHand() {
    cards.clear();
    displayObject.getChildren().clear();
  }

  public void addCard(Card card) {
    cards.add(card);
    displayObject.getChildren().add(card.getDisplayObject());
    scoreHand();
  }

  @Override
  public void createDisplayObject(int scale) {
    displayObject = new HBox();

    for (Card card : cards) {
      displayObject.getChildren().add(card.getDisplayObject());
    }
  }

}
