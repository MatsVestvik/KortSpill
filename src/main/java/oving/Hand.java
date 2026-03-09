package oving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.scene.layout.HBox;

public class Hand {

  private int score;
  private ArrayList<PlayingCard> cards;
  private HBox displayObject;
  private HBox scoreVisual;

  public Hand() {
    cards = new ArrayList<>();
    displayObject = new HBox();
    calculateScore();
    updateHandVisual();
    createScoreVisual();
  }

  public void updateHandVisual() {
    displayObject.getChildren().clear();
    for (PlayingCard card : cards) {
      displayObject.getChildren().add(card.getDisplayObject());
    }
  }

  public int getScore() {
    return score;
  }

  public HBox getScoreVisual() {
    return this.scoreVisual;
  }

  public void createScoreVisual() {
    HBox newScoreVisual = Numbers.getLargeNumber(score, 10);
    if (scoreVisual != null && scoreVisual.getParent() != null) {
      // Replace the old score visual with the new one in its parent
      ((javafx.scene.layout.Pane) scoreVisual.getParent()).getChildren().set(
          ((javafx.scene.layout.Pane) scoreVisual.getParent()).getChildren().indexOf(scoreVisual),
          newScoreVisual);
    }
    scoreVisual = newScoreVisual;
  }

  public void calculateScore() {
    this.score = evaluateHandScore();
  }

  private int evaluateHandScore() {
    if (cards.size() != 5) {
      int temp = 0;
      for (PlayingCard card : cards) {
        temp += getRankValue(card.getFace());
      }
      return temp;
    }

    Map<Integer, Integer> faceCounts = new HashMap<>();
    for (PlayingCard card : cards) {
      int face = card.getFace();
      faceCounts.put(face, faceCounts.getOrDefault(face, 0) + 1);
    }

    boolean flush = isFlush();
    int straightHigh = getStraightHigh();
    boolean straight = straightHigh > 0;

    if (flush && straight && straightHigh == 14) {
      return 1000;
    }
    if (flush && straight) {
      return 900 + straightHigh;
    }

    Integer fourOfAKindFace = getFaceWithCount(faceCounts, 4);
    if (fourOfAKindFace != null) {
      return 800 + getRankValue(fourOfAKindFace);
    }

    Integer threeOfAKindFace = getFaceWithCount(faceCounts, 3);
    Integer pairFace = getFaceWithCount(faceCounts, 2);
    if (threeOfAKindFace != null && pairFace != null) {
      return 700 + getRankValue(threeOfAKindFace);
    }

    if (flush) {
      return 600 + getHighestRank();
    }
    if (straight) {
      return 500 + straightHigh;
    }

    if (threeOfAKindFace != null) {
      return 400 + getRankValue(threeOfAKindFace);
    }

    ArrayList<Integer> pairs = faceCounts.entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 2)
        .map(Map.Entry::getKey)
        .map(this::getRankValue)
        .sorted()
        .collect(Collectors.toCollection(ArrayList::new));

    if (pairs.size() == 2) {
      int lowPair = pairs.get(0);
      int highPair = pairs.get(1);
      return 300 + (highPair * 15) + lowPair;
    }

    if (pairs.size() == 1) {
      return 200 + pairs.getFirst();
    }

    return 100 + getHighestRank();
  }

  private boolean isFlush() {
    char firstSuit = cards.getFirst().getSuit();
    for (PlayingCard card : cards) {
      if (card.getSuit() != firstSuit) {
        return false;
      }
    }
    return true;
  }

  private int getStraightHigh() {
    ArrayList<Integer> uniqueFaces = cards.stream()
        .map(PlayingCard::getFace)
        .distinct()
        .sorted()
        .collect(Collectors.toCollection(ArrayList::new));

    if (uniqueFaces.size() != 5) {
      return 0;
    }

    if (uniqueFaces.equals(List.of(1, 10, 11, 12, 13))) {
      return 14;
    }

    if (uniqueFaces.equals(List.of(1, 2, 3, 4, 5))) {
      return 5;
    }

    for (int i = 1; i < uniqueFaces.size(); i++) {
      if (uniqueFaces.get(i) != uniqueFaces.get(i - 1) + 1) {
        return 0;
      }
    }

    return getRankValue(uniqueFaces.getLast());
  }

  private int getHighestRank() {
    int high = 0;
    for (PlayingCard card : cards) {
      high = Math.max(high, getRankValue(card.getFace()));
    }
    return high;
  }

  private int getRankValue(int face) {
    return face == 1 ? 14 : face;
  }

  private Integer getFaceWithCount(Map<Integer, Integer> faceCounts, int count) {
    Integer foundFace = null;
    int bestRank = -1;
    for (Map.Entry<Integer, Integer> entry : faceCounts.entrySet()) {
      if (entry.getValue() == count) {
        int rank = getRankValue(entry.getKey());
        if (rank > bestRank) {
          bestRank = rank;
          foundFace = entry.getKey();
        }
      }
    }
    return foundFace;
  }

  public void addCard(PlayingCard card) {
    cards.add(card);
    updateHandVisual();
    calculateScore();
    createScoreVisual();
  }

  public void addFiveCards(ArrayList<PlayingCard> cards) {
    for (PlayingCard card : cards) {
      addCard(card);
    }
  }

  public void clearHand() {
    cards.clear();
    updateHandVisual();
    calculateScore();
    createScoreVisual();
  }

  public HBox getDisplayObject() {
    return this.displayObject;
  }
}
