package oving;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class Card implements Display {

  private int face;
  private char suit;

  private GridPane displayObject;
  private GridPane hoverDisplayObject;

  private ImageView faceVisual;
  private ImageView paperVisual;
  private ImageView suitVisual;

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
    if (suit != 'C' && suit != 'D' && suit != 'H' && suit != 'S') {
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
  public void createDisplayObject(int scale) {
    GridPane gridPane = new GridPane();
    RowConstraints row1 = new RowConstraints();
    row1.setPercentHeight(5);
    gridPane.getRowConstraints().add(row1);

    paperVisual = Load.loadImageView("card.png", 35 * scale);
    faceVisual = Load.loadImageView("numbers/" + face + ".png", 7 * scale);
    suitVisual = Load.loadImageView("symbol/" + suit + ".png", 11 * scale);

    gridPane.add(paperVisual, 0, 0, 1, 3);

    StackPane faceStack = new StackPane(faceVisual);
    StackPane suitStack = new StackPane(suitVisual);

    gridPane.add(faceStack, 0, 1);
    gridPane.add(suitStack, 0, 2);

    displayObject = gridPane;
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
