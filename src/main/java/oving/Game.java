package oving;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Game {

  private DeckOfCards deck;
  private Hand hand;
  private VBox elements;
  private ImageView deckStack;

  private GridPane remainingCardsGrid;
  private Scene scene;

  private Button view;

  public Game(DeckOfCards deck, Stage stage) {
    this.deck = deck;
    this.hand = new Hand();
    deckStack = deck.getBack();

    elements = new VBox();
    elements.getChildren().addAll(deckStack, hand.getDisplayObject(), hand.getScoreVisual(), view);
    deckStack.setOnMouseClicked(e -> {
      hand.clearHand();
      hand.addFiveCards(deck.drawFive());
    });

    scene = new Scene(elements);
    RemainingCards remainingCards = new RemainingCards();
    view = remainingCards.getViewButton();
    view.setOnAction(e -> {
      remainingCardsGrid = remainingCards.createGridPane(deck);
      scene.setRoot(remainingCardsGrid);
    });
    stage.setScene(scene);
    stage.show();
  }

  public GridPane getRemainingCardsGrid() {
    return remainingCardsGrid;
  }

  public void drawCard() {
    hand.addCard(deck.draw());
  }

  public DeckOfCards getDeck() {
    return deck;
  }

  public Hand getHand() {
    return hand;
  }

  public VBox getElements() {
    return elements;
  }
}
