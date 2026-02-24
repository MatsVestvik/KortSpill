package oving;

import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {

  // Returns the multiplier value for special hands
  public static int evaluateHand(ArrayList<Card> hand) {
    if (hand.size() != 5)
      return 0;

    // Sort hand by face value for easier checking
    ArrayList<Card> sortedHand = new ArrayList<>(hand);
    Collections.sort(sortedHand, (c1, c2) -> Integer.compare(c1.getFace(), c2.getFace()));

    boolean isFlush = checkFlush(sortedHand);
    boolean isStraight = checkStraight(sortedHand);

    // Check for straight flush and royal flush first
    if (isFlush && isStraight) {
      // Check if it's a royal flush (10 through Ace)
      if (sortedHand.get(0).getFace() == 10) {
        return 100; // Royal Flush
      }
      return 50; // Straight Flush
    }

    // Check for four of a kind
    int fourKindFace = checkFourOfAKind(sortedHand);
    if (fourKindFace != -1) {
      return 30; // Four of a Kind
    }

    // Check for full house
    if (checkFullHouse(sortedHand)) {
      return 25; // Full House
    }

    if (isFlush) {
      return 20; // Flush
    }

    if (isStraight) {
      return 15; // Straight
    }

    // Check for three of a kind
    int threeKindFace = checkThreeOfAKind(sortedHand);
    if (threeKindFace != -1) {
      return 10; // Three of a Kind
    }

    // Check for two pair
    if (checkTwoPair(sortedHand)) {
      return 5; // Two Pair
    }

    // Check for one pair
    int pairFace = checkOnePair(sortedHand);
    if (pairFace != -1) {
      return 2; // One Pair
    }

    return 1; // High card (default multiplier)
  }

  private static boolean checkFlush(ArrayList<Card> hand) {
    char firstSuit = hand.get(0).getSuit();
    for (Card card : hand) {
      if (card.getSuit() != firstSuit) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkStraight(ArrayList<Card> hand) {
    // Check for Ace-low straight (A,2,3,4,5)
    if (hand.get(0).getFace() == 2 &&
        hand.get(1).getFace() == 3 &&
        hand.get(2).getFace() == 4 &&
        hand.get(3).getFace() == 5 &&
        hand.get(4).getFace() == 14) {
      return true;
    }

    // Check normal straight
    for (int i = 0; i < hand.size() - 1; i++) {
      if (hand.get(i + 1).getFace() != hand.get(i).getFace() + 1) {
        return false;
      }
    }
    return true;
  }

  private static int checkFourOfAKind(ArrayList<Card> hand) {
    // Check first 4 cards
    if (hand.get(0).getFace() == hand.get(1).getFace() &&
        hand.get(1).getFace() == hand.get(2).getFace() &&
        hand.get(2).getFace() == hand.get(3).getFace()) {
      return hand.get(0).getFace();
    }

    // Check last 4 cards
    if (hand.get(1).getFace() == hand.get(2).getFace() &&
        hand.get(2).getFace() == hand.get(3).getFace() &&
        hand.get(3).getFace() == hand.get(4).getFace()) {
      return hand.get(1).getFace();
    }

    return -1;
  }

  private static boolean checkFullHouse(ArrayList<Card> hand) {
    // Pattern: AAABB
    if (hand.get(0).getFace() == hand.get(1).getFace() &&
        hand.get(1).getFace() == hand.get(2).getFace() &&
        hand.get(3).getFace() == hand.get(4).getFace() &&
        hand.get(2).getFace() != hand.get(3).getFace()) {
      return true;
    }

    // Pattern: AABBB
    if (hand.get(0).getFace() == hand.get(1).getFace() &&
        hand.get(2).getFace() == hand.get(3).getFace() &&
        hand.get(3).getFace() == hand.get(4).getFace() &&
        hand.get(1).getFace() != hand.get(2).getFace()) {
      return true;
    }

    return false;
  }

  private static int checkThreeOfAKind(ArrayList<Card> hand) {
    for (int i = 0; i < hand.size() - 2; i++) {
      if (hand.get(i).getFace() == hand.get(i + 1).getFace() &&
          hand.get(i + 1).getFace() == hand.get(i + 2).getFace()) {
        return hand.get(i).getFace();
      }
    }
    return -1;
  }

  private static boolean checkTwoPair(ArrayList<Card> hand) {
    int pairCount = 0;
    for (int i = 0; i < hand.size() - 1; i++) {
      if (hand.get(i).getFace() == hand.get(i + 1).getFace()) {
        pairCount++;
        i++; // Skip the next card since it's part of this pair
      }
    }
    return pairCount == 2;
  }

  private static int checkOnePair(ArrayList<Card> hand) {
    for (int i = 0; i < hand.size() - 1; i++) {
      if (hand.get(i).getFace() == hand.get(i + 1).getFace()) {
        return hand.get(i).getFace();
      }
    }
    return -1;
  }
}
