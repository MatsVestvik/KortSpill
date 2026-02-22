package oving;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Numbers {

  public static HBox getNumber(int number) {
    if (number <= 13 || number >= 0) {
      HBox display = new HBox();
      int tensDigit = number / 10;
      int unitsDigit = number % 10;
      ImageView tenPlace = new ImageView("numbers/" + tensDigit + ".png");
      ImageView unitsPlace = new ImageView("numbers/" + unitsDigit + ".png");

      display.getChildren().addAll(tenPlace, unitsPlace);

      return display;
    } else {
      throw new IllegalArgumentException("number must be between 0 and 13");
    }
  }
}
