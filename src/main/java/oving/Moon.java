package oving;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Moon extends Tarot {

  public Moon() {
    super("Moon", "turn card into club", 1);
  }

  @Override
  public void alterCard(Card card) {
    card.setSuit('C');
  }
}
