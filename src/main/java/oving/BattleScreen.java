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

public class BattleScreen extends Screen {

  private Button nextShop;
  private Deck deck;

  public BattleScreen(ScreenManager screenManager, Deck deck) {
    this.deck = deck;
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    nextShop = new Button("Next Shop");

    nextShop.setOnAction(e -> {
      screenManager.switchToScreen(new ShopScreen(screenManager, deck));
    });

    root.getChildren().addAll(nextShop);
  }

  @Override
  public void onEnter() {
  }

  @Override
  public void onExit() {
  }

  public ArrayList<Card> createStandardDeck() {
    ArrayList<Card> deck = new ArrayList<>();
    char[] suits = { 'C', 'D', 'H', 'S' };
    for (char suit : suits) {
      for (int i = 1; i <= 13; i++) {
        deck.add(new Card(i, suit));
      }
    }
    return deck;
  }
}
