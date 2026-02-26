package oving;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Moon extends Tarot {

  public Moon(Screen returnScreen, Deck deck, ScreenManager screenManager) {
    super("Moon", "turn card into club", 1, returnScreen, deck, screenManager);
  }

  @Override
  public void alterCard(Card card) {
    card.setSuit('C');
  }
}
