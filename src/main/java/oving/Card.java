package oving;

import javafx.scene.layout.GridPane;

public class Card implements Display {
  private GridPane displayObject;
  private GridPane hoverDisplayObject;

  public Card() {

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
