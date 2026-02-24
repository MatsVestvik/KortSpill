package oving;

import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Deck implements Display {
  private ArrayList<Card> cards;
  private StackPane displayObject;
  private GridPane hoverDisplayObject;

  public Deck(ArrayList<Card> cards, int scale) {
    this.cards = cards;

    createDisplayObject(scale);
    createHoverDisplayObject(scale);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public Card draw() {
    return cards.getFirst();
  }

  public void shuflle() {
    Collections.shuffle(cards);
  }

  @Override
  public void createDisplayObject(int scale) {
    StackPane stack = new StackPane();
    int vOffset = 0;

    for (Card card : cards) {
      ImageView image = Load.loadImageView("back.png", 35 * scale);
      stack.getChildren().add(image);
      StackPane.setAlignment(image, Pos.TOP_CENTER);
      StackPane.setMargin(image, new Insets(vOffset, 0, 0, 0));
      vOffset += scale * 2;
    }
    displayObject = stack;
  }

  @Override
  public StackPane getDisplayObject() {
    return displayObject;
  }

  @Override
  public void createHoverDisplayObject(int scale) {
    hoverDisplayObject = new GridPane();
  }

  @Override
  public Node getHoverDisplayObject() {
    return hoverDisplayObject;
  }
}
