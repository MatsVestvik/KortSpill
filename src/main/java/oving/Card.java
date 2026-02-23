package oving;

import javafx.scene.layout.GridPane;

public class Card implements Display {

  private int face;
  private char suit;

  private GridPane displayObject;
  private GridPane hoverDisplayObject;

  public Card(int face, char suit) {
    setFace(face);
    setSuit(suit);
  }

  public void setFace(int face) {
    if (face <= 13 && face > 0) {
      this.face = face;
    } else {
      throw new IllegalArgumentException("face must be true value");
    }
  }

  public void setSuit(char suit) {
    if (suit != 'C' || suit != 'D' || suit != 'H' || suit != 'S') {
      throw new IllegalArgumentException("sutit must be real");
    }
    this.suit = suit;
  }

  public int getFace() {
    return face;
  }

  public char getSuit() {
    return suit;
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
