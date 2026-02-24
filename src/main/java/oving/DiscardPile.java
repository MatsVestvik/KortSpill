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

public class DiscardPile implements Display {
  private ArrayList<Card> cards;
  private StackPane displayObject;
  private GridPane hoverDisplayObject;
  private int scale;
  private int vOffset;

  public DiscardPile(ArrayList<Card> cards, int scale) {
    this.cards = cards;
    this.scale = scale;

    createDisplayObject(scale);
    createHoverDisplayObject(scale);
  }

  public ArrayList<Card> getCards() {
    return cards;
  }

  public void addCard(Card card) {
    cards.add(card);
    GridPane image = card.getDisplayObject();
    displayObject.getChildren().add(image);
    StackPane.setAlignment(image, Pos.TOP_CENTER);
    StackPane.setMargin(image, new Insets(vOffset, 0, 0, 0));
    vOffset += scale * 2;
  }

  public void addFiveCard(ArrayList<Card> cards) {
    for (Card card : cards) {
      addCard(card);
    }
  }

  @Override
  public void createDisplayObject(int scale) {
    if (displayObject == null) {
      displayObject = new StackPane();
    }
    displayObject.getChildren().clear();
    vOffset = 0;

    for (Card card : cards) {
      GridPane image = card.getDisplayObject();
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
