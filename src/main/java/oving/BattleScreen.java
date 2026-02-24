package oving;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BattleScreen extends Screen {

  private Button nextShop;
  private Deck deck;
  private Hand hand;
  private HBox score;

  public BattleScreen(ScreenManager screenManager, Deck deck) {
    this.deck = deck;
    hand = new Hand();
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    VBox root = new VBox();

    root.getChildren().addAll(drawPile(), hand.getDisplayObject(), hand.getScoreDisplayObject());

    return root;
  }

  @Override
  protected void setupButtons() {
    nextShop = new Button("Next Shop");

    nextShop.setOnAction(e -> {
      screenManager.switchToScreen(new ShopScreen(screenManager, deck));
    });

    root.getChildren().addAll(nextShop);
  }

  public Pane drawPile() {
    StackPane stack = deck.getDisplayObject();

    stack.setOnMouseClicked(e -> {
      hand.addCard(deck.draw());
    });

    return stack;
  }

  @Override
  public void onEnter() {
  }

  @Override
  public void onExit() {
  }
}
