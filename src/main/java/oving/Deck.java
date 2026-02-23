package oving;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class Deck implements Display {
  private ArrayList<Card> cards;
  private GridPane displayObject;
  private GridPane hoverDisplayObject;

  public Deck(ArrayList<Card> cards) {
    this.cards = cards;
    createDisplayObject();
    createHoverDisplayObject();
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  @Override
  public void createDisplayObject() {
    displayObject = new GridPane();
  }

  @Override
  public GridPane getDisplayObject() {
    return displayObject;
  }

  @Override
  public void createHoverDisplayObject() {
    hoverDisplayObject = new GridPane();
  }

  @Override
  public GridPane getHoverDisplayObject() {
    return hoverDisplayObject;
  }
}
