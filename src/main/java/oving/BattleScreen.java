package oving;

import java.lang.reflect.Array;
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
  private DiscardPile discardPile;

  public BattleScreen(ScreenManager screenManager, Deck deck) {
    this.deck = deck;
    hand = new Hand();
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    HBox stacks = new HBox();
    VBox root = new VBox();
    discardPile = hand.getDiscardPile();

    stacks.getChildren().addAll(drawPile(), discardPile.getDisplayObject());
    root.getChildren().addAll(hand.getDisplayObject(), hand.getScoreDisplayObject(), stacks);

    return root;
  }

  @Override
  protected void setupButtons() {
    nextShop = new Button("Next Shop");

    nextShop.setOnAction(e -> {
      deck.addCards(discardPile.getCards());
      deck.addCards(hand.getCards());
      deck.shuflle();
      screenManager.switchToScreen(new ShopScreen(screenManager, deck));
    });

    root.getChildren().addAll(nextShop);
  }

  public Pane drawPile() {
    StackPane stack = deck.getDisplayObject();

    stack.setOnMouseClicked(e -> {
      ArrayList<Card> drawnCards = deck.drawFive(5);
      hand.addFiveCard(drawnCards);
    });

    return stack;
  }

  @Override
  public void onEnter() {
  }

  @Override
  public void onExit() {
    deck.addCards(hand.getCards());
    hand.clearHand();
  }
}
