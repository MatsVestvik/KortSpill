package oving;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public abstract class Tarot implements Display {

  private int cost;
  private Label name;
  private Label description;
  private GridPane displayObject;
  private GridPane hoverDisplayObject;
  private ImageView paperVisual;

  public Tarot(String name, String description, int cost) {
    this.name = new Label(name);
    this.description = new Label(description);
    this.cost = cost;
  }

  public abstract void alterCard(Card card);

  @Override
  public void createDisplayObject(int scale) {
    GridPane gridPane = new GridPane();

    paperVisual = Load.loadImageView("card.png", 35 * scale);

    gridPane.add(paperVisual, 0, 0, 1, 3);

    StackPane faceStack = new StackPane(name);
    StackPane suitStack = new StackPane(description);

    gridPane.add(faceStack, 0, 1);
    gridPane.add(suitStack, 0, 2);

    displayObject = gridPane;
  }

  public GridPane getDisplayObject() {
    return displayObject;
  }

  public void createHoverDisplayObject(int scale) {
    hoverDisplayObject = new GridPane();
  }

  public GridPane getHoverDisplayObject() {
    return hoverDisplayObject;
  }
}
