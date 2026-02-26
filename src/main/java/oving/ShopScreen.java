package oving;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    this.scale = 5;
    super(screenManager);
  }

  private HBox items() {
    HBox hbox = new HBox();
    Emperor emperor = new Emperor(new ShopScreen(screenManager, deck), deck, screenManager);
    Moon moon = new Moon(new ShopScreen(screenManager, deck), deck, screenManager);

    emperor.getDisplayObject().setOnMouseClicked(e -> {
      screenManager.switchToScreen(new UpgradeScreen(screenManager, emperor, deck));
    });
    moon.getDisplayObject().setOnMouseClicked(e -> {
      screenManager.switchToScreen(new UpgradeScreen(screenManager, moon, deck));
    });

    hbox.getChildren().addAll(emperor.getDisplayObject(), moon.getDisplayObject());
    return hbox;
  }

  @Override
  protected Pane createRoot() {
    VBox vbox = new VBox();
    HBox hbox = new HBox();

    StackPane deckVisual = deck.getDisplayObject();
    deckVisual.setOnMouseClicked(e -> {
      screenManager.switchToScreen(new RemainingScreen(screenManager, deck));
    });

    saq = new Button("Save & Quit");
    battle = new Button("Battle");

    saq.setOnAction(e -> {
      screenManager.switchToScreen(new StartScreen(screenManager));
    });
    battle.setOnAction(e -> {
      screenManager.switchToScreen(new BattleScreen(screenManager, deck));
    });

    HBox shopItems = items();

    vbox.getChildren().addAll(saq, battle, shopItems);

    hbox.getChildren().addAll(vbox, deckVisual);

    return hbox;
  }

  @Override
  protected void setupButtons() {
  }

  @Override
  public void onEnter() {

  }

  @Override
  public void onExit() {
  }
}
