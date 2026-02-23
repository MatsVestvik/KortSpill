package oving;

import javafx.scene.layout.GridPane;

public interface Display {

  public void createDisplayObject(int scale);

  public GridPane getDisplayObject();

  public void createHoverDisplayObject(int scale);

  public GridPane getHoverDisplayObject();
}
