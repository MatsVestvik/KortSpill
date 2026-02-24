package oving;

import javafx.scene.layout.GridPane;
import javafx.scene.Node;

public interface Display {

  public void createDisplayObject(int scale);

  public Node getDisplayObject();

  public void createHoverDisplayObject(int scale);

  public Node getHoverDisplayObject();
}
