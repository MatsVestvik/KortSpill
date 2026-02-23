package oving;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Number {

  public static HBox createNumber(int num, int scale) {
    HBox hbox = new HBox();

    String numStr = String.valueOf(num);
    int[] digits = new int[numStr.length()];

    for (int i = 0; i < numStr.length(); i++) {
      digits[i] = Character.getNumericValue(numStr.charAt(i));
    }

    for (int digit : digits) {
      hbox.getChildren().add(
          new ImageView(
              new Image("numbers/" + digit + ".png", 5 * scale, 7 * scale, true, false)));
    }

    hbox.setSpacing(scale);
    return hbox;

  }

}
