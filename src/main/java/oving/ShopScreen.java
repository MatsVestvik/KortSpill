package oving;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShopScreen extends Screen {

  private Button saq;
  private Button battle;
  private int scale;
  private Deck deck;

  public ShopScreen(ScreenManager screenManager, Deck deck) {
    this.deck = deck;
    scale = 5;
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    saq = new Button("Save & Quit");
    battle = new Button("Battle");
    StackPane deckVisual = deck.getDisplayObject();

    saq.setOnAction(e -> {
      screenManager.switchToScreen(new StartScreen(screenManager));
    });
    battle.setOnAction(e -> {
      screenManager.switchToScreen(new BattleScreen(screenManager, deck));
    });
    deckVisual.setOnMouseClicked(e -> {
      screenManager.switchToScreen(new RemainingScreen(screenManager, deck));
    });

    root.getChildren().addAll(saq, battle, deckVisual);
  }

  @Override
  public void onEnter() {

  }

  @Override
  public void onExit() {
  }
}
