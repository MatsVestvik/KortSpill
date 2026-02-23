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

  private Scene scene;
  private Button startGame;

  public StartScreen(ScreenManager screenManager) {
    super(screenManager);
  }

  @Override
  protected Pane createRoot() {
    return new VBox(10);
  }

  @Override
  protected void setupButtons() {
    Button startButton = new Button("Start Game");

    startButton.setOnAction(e -> {
      screenManager.switchToScreen(new ShopScreen(screenManager));
    });

    root.getChildren().addAll(startButton);
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
