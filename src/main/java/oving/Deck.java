package oving;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class Deck implements Display {
  private ArrayList<Card> cards;
  private GridPane displayObject;
  private GridPane hoverDisplayObject;

  public Deck(ArrayList<Card> cards, int scale) {
    this.cards = cards;
    createDisplayObject(scale);
    createHoverDisplayObject(scale);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  @Override
  public void createDisplayObject(int scale) {
    displayObject = new GridPane();
  }

  @Override
  public GridPane getDisplayObject() {
    return displayObject;
  }

  @Override
  public void createHoverDisplayObject(int scale) {
    hoverDisplayObject = new GridPane();
  }

  @Override
  public GridPane getHoverDisplayObject() {
    return hoverDisplayObject;
  }
}
