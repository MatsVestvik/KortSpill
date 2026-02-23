package oving;

import javafx.scene.layout.GridPane;

public interface Display {

  public void createDisplayObject();

  public GridPane getDisplayObject();

  public void createHoverDisplayObject();

  public GridPane getHoverDisplayObject();
}
