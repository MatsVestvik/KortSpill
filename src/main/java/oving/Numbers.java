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

  public static HBox getLargeNumber(int number, int scale) {
    int num = Math.abs(number);
    int temp = num;
    int length = String.valueOf(num).length();
    int[] digits = new int[length];

    for (int i = length - 1; i >= 0; i--) {
      digits[i] = temp % 10;
      temp = temp / 10;
    }

    HBox hbox = new HBox();
    for (int digit : digits) {
      hbox.getChildren()
          .add(new ImageView(new Image("numbers/" + digit + ".png", 5 * scale, 7 * scale, true, false)));
    }
    return hbox;

  }
}
