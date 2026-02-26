package oving;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class UpgradeScreen extends Screen {

  private int scale;
  private Hand hand;
  private Tarot tarot;
  private Deck deck;

  public UpgradeScreen(ScreenManager screenManager, Tarot tarot, Deck deck) {
    super(screenManager);
    this.scale = 5;
    this.tarot = tarot;
    this.deck = deck;
    init();
  }

  @Override
  protected Pane createRoot() {
    VBox vbox = new VBox();
    hand = new Hand();
    hand.addFiveCard(deck.drawFive(5));

    for (Card card : hand.getCards()) {
      card.getDisplayObject().setOnMouseClicked(e -> {
        tarot.alterCard(card);
        deck.addCards(hand.getCards());
        deck.shuflle();
        screenManager.switchToScreen(new ShopScreen(screenManager, deck));
      });
    }

    vbox.getChildren().add(hand.getDisplayObject());

    return vbox;
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
