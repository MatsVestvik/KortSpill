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

public class StartScreen extends Screen {

  private Button startGame;
  private int scale;

  public StartScreen(ScreenManager screenManager) {
    super(screenManager);
    this.scale = 5;
    init();
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    startGame = new Button("Start Game");
    Deck deck = new Deck(createStandardDeck(), scale);
    deck.shuflle();

    startGame.setOnAction(e -> {
      screenManager.switchToScreen(new ShopScreen(screenManager, deck));
    });

    root.getChildren().addAll(startGame);
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
