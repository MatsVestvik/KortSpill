package oving;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public interface Display {

  public void createDisplayObject(int scale);

  public Node getDisplayObject();

  public void createHoverDisplayObject(int scale);

  public Node getHoverDisplayObject();
}
