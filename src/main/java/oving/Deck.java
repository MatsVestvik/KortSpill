package oving;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Deck implements Display {
  private ArrayList<Card> cards;
  private StackPane displayObject;
  private GridPane hoverDisplayObject;
  private int scale;

  public Deck(ArrayList<Card> cards, int scale) {
    this.cards = cards;
    this.scale = scale;

    createDisplayObject(scale);
    createHoverDisplayObject(scale);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public Card draw() {
    Card drawnCard = cards.removeFirst();
    createDisplayObject(scale);
    return drawnCard;
  }

  public ArrayList<Card> drawFive(int n) {
    ArrayList<Card> cards = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      cards.add(draw());
    }
    return cards;

  }

  public void shuflle() {
    Collections.shuffle(cards);
  }

  @Override
  public void createDisplayObject(int scale) {
    if (displayObject == null) {
      displayObject = new StackPane();
    }
    displayObject.getChildren().clear();
    int vOffset = 0;

    for (Card card : cards) {
      ImageView image = Load.loadImageView("back.png", 35 * scale);
      displayObject.getChildren().add(image);
      StackPane.setAlignment(image, Pos.TOP_CENTER);
      StackPane.setMargin(image, new Insets(vOffset, 0, 0, 0));
      vOffset += scale * 2;
    }
  }

  @Override
  public StackPane getDisplayObject() {
    return displayObject;
  }

  @Override
  public void createHoverDisplayObject(int scale) {
    hoverDisplayObject = new GridPane();
  }

  @Override
  public Node getHoverDisplayObject() {
    return hoverDisplayObject;
  }

  public ArrayList<Card> getSuitedDeck(char suit) {
    ArrayList<Card> suitedDeck = new ArrayList<>();
    for (Card card : cards) {
      if (card.getSuit() == suit) {
        suitedDeck.add(card);
      }
    }
    return suitedDeck;
  }

  public ArrayList<Card> getDescendingDeck(ArrayList<Card> unSorted) {
    Collections.sort(unSorted, Collections.reverseOrder(Comparator.comparing(Card::getFace)));
    return unSorted;
  }

  public GridPane createRemainingVisual() {
    GridPane grid = new GridPane();
    int col = 0;
    int row = 0;

    char[] suits = { 'C', 'D', 'H', 'S' };

    for (char suit : suits) {
      ArrayList<Card> sortedSuit = getDescendingDeck(getSuitedDeck(suit));
      for (Card card : sortedSuit) {
        grid.add(card.getDisplayObject(), col, row);
        col++;
      }
      col = 0;
      row++;
    }

    return grid;
  }
}
