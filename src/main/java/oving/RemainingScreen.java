package oving;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemainingScreen extends Screen {

  private int scale;
  private Deck deck;

  public RemainingScreen(ScreenManager screenManager, Deck deck) {
    super(screenManager);
    this.deck = deck;
    this.scale = 5;
    init();
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    GridPane grid = deck.createRemainingVisual();
    Button back = new Button("Back");

    back.setOnAction(e -> {
      screenManager.switchToScreen(new ShopScreen(screenManager, deck));
    });

    root.getChildren().addAll(grid, back);
  }

  @Override
  public void onEnter() {
  }

  @Override
  public void onExit() {
  }
}
