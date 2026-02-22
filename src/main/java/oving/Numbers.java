package oving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Numbers {

  public static HBox getNumber(int number, int scale) {
    if (number >= 1 && number <= 13) {
      HBox display = new HBox();
      int tensDigit = number / 10;
      int unitsDigit = number % 10;
      ImageView tenPlace = new ImageView(new Image("numbers/" + tensDigit + ".png", scale * 5, scale * 7, true, false));
      ImageView unitsPlace = new ImageView(
          new Image("numbers/" + unitsDigit + ".png", scale * 5, scale * 7, true, false));

      display.getChildren().addAll(tenPlace, unitsPlace);

      return display;
    } else {
      throw new IllegalArgumentException("number must be between 1 and 13");
    }
  }
}
